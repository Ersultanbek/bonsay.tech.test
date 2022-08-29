# Getting Started

 To launch a project you will need installed `gradle` or you can use `gradlew.sh gradlew.bat`, which is located in project directory
### Complete following steps to launch a project
 * Install dependencies: type command `./gradlew clean install` 
 * Build jar file: type command `./gradlew build` 
 * Navigate to build dir: `cd build/libs` 
 * Launch jar file: type command `java -jar covidstat-1.0.0.jar OPTIONS` 

``
Posible OPTIONS: 
* `--[no]help [-h]` (a boolean; default: "false") Prints usage info.
* `--ab [-a]` (a string; default: "") Any country ISO abbreviation (example: FR) (takes precedence over "country" parameter), Example: FR
* `--country [-c]` (a string; default: "") Any country name (case sensitive) Example: France
``

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://github.com/M-Media-Group/Covid-19-API)
* [Covid-19-Api](https://github.com/M-Media-Group/Covid-19-API)


