ses(ValueError, Instr, "CALL_FUNCTION", 2147483647 + 1)
        instr = Instr("CALL_FUNCTION", 2147483647)
        self.assertEqual(instr.arg, 2147483647)

        # not HAVE_ARGUMENT
        self.assertRaises(ValueError, Instr, "NOP", 0)
        Instr("NOP")

    def test_require_arg(self):
        i = Instr("CALL_FUNCTION", 3)
        self.assertTrue(i.require_arg())
        i = Instr("NOP")
        self.assertFalse(i.require_arg())

    def test_attr(self):
        instr = Instr("LOAD_CONST", 3, lineno=5)
        self.assertEqual(instr.name, "LOAD_CONST")
        self.assertEqual(instr.opcode, 100)
        self.assertEqual(instr.arg, 3)
        self.assertEqual(instr.lineno, 5)

        # invalid values/types
        self.assertRaises(ValueError, setattr, instr, "lineno", 0)
        self.assertRaises(TypeError, setattr, instr, "lineno", 1.0)
        self.assertRaises(TypeError, setattr, instr, "name", 5)
        self.assertRaises(TypeError, setattr, instr, "opcode", 1.0)
        self.assertRaises(ValueError, setattr, instr, "opcode", -1)
        self.assertRaises(ValueError, setattr, instr, "opcode", 255)

        # arg can take any attribute but cannot be deleted
        instr.arg = -8
        instr.arg = object()
        self.assertRaises(AttributeError, delattr, instr, "arg")

        # no argument
        instr = Instr("ROT_TWO")
        self.assertIs(instr.arg, UNSET)

    def test_modify_op(self):
        instr = Instr("LOAD_NAME", "x")
        load_fast = opcode.opmap["LOAD_FAST"]
        instr.opcode = load_fast
        self.assertEqual(instr.name, "LOAD_FAST")
        self.assertEqual(instr.opcode, load_fast)

    def test_extended_arg(self):
        instr = Instr("LOAD_CONST", 0x1234ABCD)
        self.assertEqual(instr.arg, 0x1234ABCD)

    def test_slots(self):
        instr = Instr("NOP")
        with self.assertRaises(AttributeError):
            instr.myattr = 1

    def test_compare(self):
        instr = Instr("LOAD_CONST", 3, lineno=7)
        self.assertEqual(instr, Instr("LOAD_CONST", 3, lineno=7))
        self.assertNotEqual(instr, 1)

        # different lineno
        self.assertNotEqual(instr, Instr("LOAD_CONST", 3))
        self.assertNotEqual(instr, Instr("LOAD_CONST", 3, lineno=6))
        # different op
        self.assertNotEqual(instr, Instr("LOAD_FAST", "x", lineno=7))
        # different arg
        self.assertNotEqual(instr, Instr("LOAD_CONST", 4, lineno=7))

    def test_has_jump(self):
        label = Label()
        jump = Instr("JUMP_ABSOLUTE", label)
        self.assertTrue(jump.has_jump())

        instr = Instr("LOAD_FAST", "x")
        self.assertFalse(instr.has_jump())

    def test_is_cond_jump(self):
        label = Label()
        jump = Instr("POP_JUMP_IF_TRUE", label)
        self.assertTrue(jump.is_cond_jump())

        instr = Instr("LOAD_FAST", "x")
        self.assertFalse(instr.is_cond_jump())

    def test_is_uncond_jump(self):
        label = Label()
        jump = Instr("JUMP_ABSOLUTE", label)
        self.assertTrue(jump.is_uncond_jump())

        instr = Instr("POP_JUMP_IF_TRUE", label)
        self.assertFalse(instr.is_uncond_jump())

    def test_const_key_not_equal(self):
        def check(value):
            self.assertEqual(Instr("LOAD_CONST", value), Instr("LOAD_CONST", value))

        def func():
            pass

        check(None)
        check(0)
        check(0.0)
        check(b"bytes")
        check("text")
        check(Ellipsis)
        check((1, 2, 3))
        check(frozenset({1, 2, 3}))
        check(func.__code__)
        check(object())

    def test_const_key_equal(self):
        neg_zero = -0.0
        pos_zero = +0.0

        # int and float: 0 == 0.0
        self.assertNotEqual(Instr("LOAD_CONST", 0), Instr("LOAD_CONST", 0.0))

        # float: -0.0 == +0.0
        self.assertNotEqual(Instr("LOAD_CONST", neg_zero), Instr("LOAD_CONST", pos_zero))

        # complex
        self.assertNotEqual(
            Instr("LOAD_CONST", complex(neg_zero, 1.0)),
            Instr("LOAD_CONST", complex(pos_zero, 1.0)),
        )
        self.assertNotEqual(
            Instr("LOAD_CONST", complex(1.0, neg_zero)),
            Instr("LOAD_CONST", complex(1.0, pos_zero)),
        )

        # tuple
        self.assertNotEqual(Instr("LOAD_CONST", (0,)), Instr("LOAD_CONST", (0.0,)))
        nested_tuple1 = (0,)
        nested_tuple1 = (nested_tuple1,)
        nested_tuple2 = (0.0,)
        nested_tuple2 = (nested_tuple2,)
        self.assertNotEqual(Instr("LOAD_CONST", nested_tuple1), Instr("LOAD_CONST", nested_tuple2))

        # frozenset
        self.assertNotEqual(Instr("LOAD_CONST", frozenset({0})), Instr("LOAD_CONST", frozenset({0.0})))

    def test_stack_effects(self):
        # Verify all opcodes are handled and that "jump=None" really returns
        # the max of the other cases.
        from _pydevd_frame_eval.vendored.bytecode.concrete import ConcreteInstr

        def check(instr):
            jump = instr.stack_effect(jump=True)
            no_jump = instr.stack_effect(jump=False)
            max_effect = instr.stack_effect(jump=None)
            self.assertEqual(instr.stack_effect(), max_effect)
            self.assertEqual(max_effect, max(jump, no_jump))

            if not instr.has_jump():
                self.assertEqual(jump, no_jump)

        for name, op in opcode.opmap.items():
            with self.subTest(name):
                # Use ConcreteInstr instead of Instr because it doesn't care
                # what kind of argument it is constructed with.
                if op < opcode.HAVE_ARGUMENT:
                    check(ConcreteInstr(name))
                else:
                    for arg in range(256):
                        check(ConcreteInstr(name, arg))

        # LOAD_CONST uses a concrete python object as its oparg, however, in
        #       dis.stack_effect(opcode.opmap['LOAD_CONST'], oparg),
        # oparg should be the index of that python object in the constants.
        #
        # Fortunately, for an instruction whose oparg isn't equivalent to its
        # form in binary files(pyc format), the stack effect is a
        # constant which does not depend on its oparg.
        #
        # The second argument of dis.stack_effect cannot be
        # more than 2**31 - 1. If stack effect of an instruction is
        # independent of its oparg, we pass 0 as the second argument
        # of dis.stack_effect.
        # (As a result we can calculate stack_effect for
        #  any LOAD_CONST instructions, even for large integers)

        for arg in 2**31, 2**32, 2**63, 2**64, -1:
            self.assertEqual(Instr("LOAD_CONST", arg).stack_effect(), 1)

    def test_code_object_containing_mutable_data(self):
        from _pydevd_frame_eval.vendored.bytecode import Bytecode, Instr
        from types import CodeType

        def f():
            def g():
                return "value"

            return g

        f_code = Bytecode.from_code(f.__code__)
        instr_load_code = None
        mu