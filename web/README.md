# Automation maintenance project
This is a practice Automation maintenance project on site https://demowebshop.tricentis.com/

## Setup Test Project

1. Download and Install Java 19 or latest version
2. Clone this repository by command:
   ```shell
    git clone https://github.com/EVN-AQA/automation-maintenance-project.git
   ```
3. Open cloned repo by IntelliJ IDE and install dependencies in pom.xml
4. To execute the tests via CLI:

For browser Chrome:
   ```shell
    mvn test -DBrowser=CHROME
   ```
For browser Firefox:
   ```shell
    mvn test -DBrowser=FIREFOX
   ```
