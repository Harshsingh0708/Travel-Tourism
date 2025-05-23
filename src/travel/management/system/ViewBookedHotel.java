<h1 data-loc-id="walkthrough.windows.install.compiler">Instalar um compilador C++ no Windows</h1>
<p data-loc-id="walkthrough.windows.text1">Se você estiver desenvolvendo C++ para Windows, recomendamos instalar o conjunto de ferramentas do compilador Microsoft Visual C++ (MSVC).</p>
<ol>
<li><p data-loc-id="walkthrough.windows.text2">Para instalar o MSVC, abra o terminal VS Code (CTRL + `) e cole o seguinte comando:
</p><pre><code style="white-space: pre-wrap;">winget install Microsoft.VisualStudio.2022.BuildTools --force --override "--wait --passive --add Microsoft.VisualStudio.Workload.VCTools --add Microsoft.VisualStudio.Component.VC.Tools.x86.x64 --add Microsoft.VisualStudio.Component.Windows10SDK.20348"</code></pre>
</li>
<blockquote>
<p><strong data-loc-id="walkthrough.windows.note1">Observação</strong>: <span data-loc-id="walkthrough.windows.note1.text">Você pode usar o conjunto de ferramentas C++ das Ferramentas de Build do Visual Studio junto com o Visual Studio Code para compilar, construir e verificar qualquer base de código C++, contanto que também tenha uma licença válida do Visual Studio (Community, Pro ou Enterprise) que esteja ativamente usando para desenvolver essa base de código C++.</span></p>
</blockquote>

</ol>
<h2 data-loc-id="walkthrough.windows.verify.compiler">Verificando a instalação do compilador</h2>
<ol>
<li><p data-loc-id="walkthrough.windows.open.command.prompt">Abra o <strong>Developer Command Prompt for VS</strong> digitando '<code>developer</code>' no menu Iniciar do Windows.</p>
</li>
<li><p data-loc-id="walkthrough.windows.check.install">Verifique sua instalação do MSVC digitando <code>cl</code> no <span>Developer Command Prompt for VS</span>. Você deverá ver uma mensagem de copyright com a versão e a descrição básica de uso.</p>
<blockquote>
<p><strong data-loc-id="walkthrough.windows.note2">Observação</strong>: <span data-loc-id="walkthrough.windows.note2.text">Para usar o MSVC a partir da linha de comando ou Código VS, você deve executar a partir de um <strong>Developer Command Prompt for VS</strong>. Um shell comum como <span>PowerShell</span>, <span>Bash</span> ou o prompt de comando do Windows não possui as variáveis ​​de ambiente de caminho necessárias definidas.</span></p>
</blockquote>
</li>
</ol>
<h2 data-loc-id="walkthrough.windows.other.compilers">Outras opções do compilador</h2>
<p data-loc-id="walkthrough.windows.text3">Se você está segmentando o Linux a partir do Windows, verifique <a href="https://code.visualstudio.com/docs/cpp/config-wsl" data-loc-id="walkthrough.windows.link.title1">Usando C++ e Subsistema Windows para Linux (WSL) no código VS</a>. Ou você pode <a href="https://code.visualstudio.com/docs/cpp/config-mingw" data-loc-id="walkthrough.windows.link.title2">instalar GCC no Windows com MinGW</a>.</p>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               <h1 data-loc-id="walkthrough.windows.install.compiler">Zainstaluj kompilator języka C++ w systemie Windows</h1>
<p data-loc-id="walkthrough.windows.text1">W przypadku programowania w języku C++ dla systemu Windows zalecamy zainstalowanie kompilatora Microsoft Visual C++ (MSVC).</p>
<ol>
<li><p data-loc-id="walkthrough.windows.text2">Aby zainstalować program MSVC, otwórz terminal VS Code (CTRL + `) i wklej następujące polecenie:
</p><pre><code style="white-space: pre-wrap;">winget install Microsoft.VisualStudio.2022.BuildTools --force --override "--wait --passive --add Microsoft.VisualStudio.Workload.VCTools --add Microsoft.VisualStudio.Component.VC.Tools.x86.x64 --add Microsoft.VisualStudio.Component.Windows10SDK.20348"</code></pre>
</li>
<blockquote>
<p><strong data-loc-id="walkthrough.windows.note1">Notatka</strong>: <span data-loc-id="walkthrough.windows.note1.text">Zestawu narzędzi języka C++ z narzędzi Visual Studio Build Tools wraz z programem Visual Studio Code można używać do kompilowania, tworzenia i weryfikowania dowolnej bazy kodu języka C++, o ile masz również ważną licencję programu Visual Studio (Community, Pro lub Enterprise), której aktywnie używasz do opracowywania tej bazy kodu języka C++.</span></p>
</blockquote>

</ol>
<h2 data-loc-id="walkthrough.windows.verify.compiler">Weryfikowanie instalacji kompilatora</h2>
<ol>
<li><p data-loc-id="walkthrough.windows.open.command.prompt">Otwórz pozycję <strong>Developer Command Prompt for VS</strong>, wpisując „<code>developer</code>” w menu Start syste