g.Any:
        ...
    
    @property
    def name(self) -> typing.Any:
        ...
    
    @property
    def typ(self) -> typing.Any:
        ...
    
    @property
    def values(self) -> typing.Any:
        ...
    
    def __getattr__(self, name) -> typing.Any:
        ...
    

class SeriesGrouper(_BaseGrouper):
    '\n    Performs generic grouping operation while avoiding ndarray construction\n    overhead\n    '
    def __init__(self, *args, **kwargs) -> None:
        '\n    Performs generic grouping operation while avoiding ndarray construction\n    overhead\n    '
        ...
    
    @classmethod
    def __init_subclass__(cls) -> None:
        'This method is called when a class is subclassed.\n\nThe default implementation does nothing. It may be\noverridden to extend subclasses.\n'
        ...
    
    __pyx_vtable__: PyCapsule
    def __reduce__(self) -> typing.Union[str, typing.Tuple[typing.Any, ...]]:
        ...
    
    def __setstate__(self, state: typing.Any) -> None:
        ...
    
    @classmethod
    def __subclasshook__(cls, subclass: typing.Any) -> bool:
        'Abstract classes can override this to customize issubclass().\n\nThis is invoked early on by abc.ABCMeta.__subclasscheck__().\nIt should return True, False or NotImplemented.  If it returns\nNotImplemented, the normal algorithm is used.  Otherwise, it\noverrides the normal algorithm (and the outcome is cached).\n'
        ...
    
    @property
    def arr(self) -> typing.Any:
        ...
    
    @property
    def dummy_arr(self) -> typing.Any:
        ...
    
    @property
    def dummy_index(self) -> typing.Any:
        ...
    
    @property
    def f(self) -> typing.Any:
        ...
    
    def get_result(self) -> typing.Any:
        ...
    
    @property
    def index(self) -> typing.Any:
        ...
    
    @property
    def ityp(self) -> typing.Any:
        ...
    
    @property
    def labels(self) -> typing.Any:
        ...
    
    @property
    def name(self) -> typing.Any:
        ...
    
    @property
    def typ(self) -> typing.Any:
        ...
    
    @property
    def values(self) -> typing.Any:
        ...
    
    def __getattr__(self, name) -> typing.Any:
        ...
    

class Slider(_mod_builtins.object):
    '\n    Only handles contiguous data for now\n    '
    def __init__(self, *args, **kwargs) -> None:
        '\n    Only handles contiguous data for now\n    '
        ...
    
    @classmethod
    def __init_subclass__(cls) -> None:
        'This method is called when a class is subclassed.\n\nThe default implementation does nothing. It may be\noverridden to extend subclasses.\n'
        ...
    
    __pyx_vtable__: PyCapsule
    def __reduce__(self) -> typing.Union[str, typing.Tuple[typing.Any, ...]]:
        ...
    
    def __setstate__(self, state: typing.Any) -> None:
        ...
    
    @classmethod
    def __subclasshook__(cls, subclass: typing.Any) -> bool:
        'Abstract classes can override this to customize issubclass().\n\nThis is invoked early on by abc.ABCMeta.__subclasscheck__().\nIt should return True, False or NotImplemented.  If it returns\nNotImplemented, the normal algorithm is used.  Otherwise, it\noverrides the normal algorithm (and the outcome is cached).\n'
        ...
    
    def __getattr__(self, name) -> typing.Any:
        ...
    

class _BaseGrouper(_mod_builtins.object):
    def __init__(self, *args, **kwargs) -> None:
        ...
    
    @classmethod
    def __init_subclass__(cls) -> None:
        'This method is called when a class is subclassed.\n\nThe default implementation does nothing. It may be\noverridden to extend subclasses.\n'
        ...
    
    __pyx_vtable__: PyCapsule
    def __reduce__(self) -> typing.Union[str, typing.Tuple[typing.Any, ...]]:
        ...
    
    def __setstate__(self, state: typing.Any) -> None:
        ...
    
    @classmethod
    def __subclasshook__(cls, subclass: typing.Any) -> bool:
        'Abstract classes can override this to customize issubclass().\n\nThis is invoked early on by abc.ABCMeta.__subclasscheck__().\nIt should return True, False or NotImplemented.  If it returns\nNotImplemented, the normal algorithm is used.  Otherwise, it\noverrides the normal algorithm (and the outcome is cached).\n'
        ...
    
    def __getattr__(self, name) -> typing.Any:
        ...
    

__doc__: typing.Any
__file__: str
__name__: str
__package__: str
def __pyx_unpickle_Enum() -> typing.Any:
    ...

def __pyx_unpickle_SeriesBinGrouper() -> typing.Any:
    ..