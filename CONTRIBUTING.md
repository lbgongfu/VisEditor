We are glad that you would like to contribute to the Vis Project. Here are some guidelines that you should follow when making your contributions.

Start by forking this repository, then learn [how to run Vis Projects from source code](https://github.com/kotcrab/VisEditor/wiki/Building-Vis-From-Source).

#### Git commits messages
* Use sentence case ("Added feature" not "added feature")
* Don't use dots, exclamation or question marks at the end of commit message

#### Code Formatter
We require you to use code formatter when making pull requests. Code formatter for IntelliJ IDEA can be found in root directory of this repository. If you are using Eclipse then
you must use [libGDX Eclipse formatter](https://github.com/kotcrab/libgdx/blob/master/eclipse-formatter.xml). 

Remember to don't use formatter on existing code, it may change other irrelevant source code and if you decide to make pull request later it will be harder to review. It applies especially do Eclipse formatter which isn't fully compatible with the IntelliJ IDEA formatter, used mainly in this repository.

To install formatter in Eclipse simply import xml file from settings window.

To install formatter in IntelliJ IDEA copy xml to config directory, restart IDE, then select formatter from settings.  
Mac OS X: `~/Library/Preferences/.IdeaIC14/codestyles/`  
Linux: `~/.IdeaIC14/config/codeStyles/`  
Windows: `<User home>\.IdeaIC14\config\codeStyles\`

`.IdeaIC14` directory may be named different depending on your IDEA version

#### Code Style
Please follow [libGDX code style](https://github.com/libgdx/libgdx/blob/master/CONTRIBUTING.md#code-style).

Thanks!
