
# ShipsSimulation

An agent-based ship combat simulation


## Run Locally

Clone the project

```bash
  git clone https://github.com/Ernest-K/ShipsSimulation.git
```


## Usage/Examples
This project is made with gradle. You can easily run code on your machine using gradle wrapper.

To run the code with default parameters type in project directory:
```powershell
./gradlew run
```
or if you want specify arguments:
```powershell
./gradlew run --args="[boardWidth] [boardHeight] [configFileName.json]"
```
In the [resources](src/main/resources) folder there are some sample configurations files. 
You can modify existing configuration files or create your own.

Ships available for selection:
```text 
SLOOP
BRIGANTINE
GALLEON
```
