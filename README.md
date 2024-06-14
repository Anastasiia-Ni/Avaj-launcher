# avaj-launcher 
Thinking in Java

## About the project: 
The Frankfurt Airport Weather Simulator is a Java-based application designed to address the challenges of landing track bottlenecks caused by frequent weather changes. 
Utilizing core design patterns such as Observer, Singleton, and Factory, the simulator aims to provide a flexible solution that anticipates future expansion and changes. 
The project is developed under strict adherence to Java's best practices and clean code principles.


### Requirements
- Java LTS Version: Ensure usage of language features up to the latest Java LTS version.
- Environment: The application must run in a diverse OS environment without dependency on external libraries, build tools, or code generators.
- Java Commands: Must have javac and java available in the terminal.
- No Default Package: All classes should be organized in appropriately named packages, avoiding the default package.
- Source Management: Do not commit .class files.
- Use the following commands to compile the project in the root folder:
  
```
find * -name "*.java" > sources.txt
javac @sources.txt
```
### Program Execution
The simulator accepts a single command-line argument, the scenario file name, which dictates the number of simulation runs and specifies aircraft details for the simulation. 
Upon execution, the program generates a simulation.txt file detailing the outcomes.

### Scenario File Structure
Initial Line: A positive integer indicating the number of simulation runs.
Subsequent Lines: Aircraft details formatted as TYPE NAME LONGITUDE LATITUDE HEIGHT.
Example:
```
25
Baloon B1 2 3 20
Baloon B2 1 8 66
JetPlane J1 23 44 32
Helicopter H1 654 33 20
Helicopter H2 22 33 44
Helicopter H3 98 68 99
Baloon B3 102 22 34
JetPlane J2 11 99 768
Helicopter H4 223 23 54
```

### Weather Simulation
Each three-dimensional point experiences its unique weather condition, which could be one of the following:
- RAIN
- FOG
- SUN
- SNOW
The weather generation algorithm considers the coordinates of the point.

### Aircraft Specifications
Different aircraft types react differently to weather changes:

- JetPlane: Adjusts latitude and height based on weather conditions.
- Helicopter: Modifies longitude and height in response to weather.
- Baloon: Adjusts longitude and height, with specific responses to each weather type.

### Simulation Rules
- Coordinates must be positive numbers 
- Height ranging from 0 to 100.
- Aircrafts receive a unique ID upon creation; duplicate IDs are not allowed.
- Aircraft landing, registering, and unregistering events are logged with specific messages.
- Each time an aircraft registers or unregisters to/from the weather tower, a message will be logged in a file.

## Installation:
``` 
git clone git@github.com:Anastasiia-Ni/Avaj-launcher.git
cd Avaj-launcher
```
Compilng:
```
$find * -name "*.java" > sources.txt
$javac @sources.txt
```
or
```
make
```
## Usage:
