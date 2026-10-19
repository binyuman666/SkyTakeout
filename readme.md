# Transit Routing System README

## 1. Introduction
This project is a comprehensive transit routing system designed to find the optimal routes for travelers based on the General Transit Feed Specification (GTFS) data. It combines database management, graph construction, and pathfinding algorithms to provide efficient and accurate routing solutions. The system also includes a graphical user interface (GUI) for users to interact with the routing engine.

## 2. Project Structure
The project is structured into several packages, each serving a specific purpose:
- **group_22.gtfs**: Contains classes for reading and loading GTFS data into the database.
- **group_22.DBManager**: Manages the database connection and provides utility methods for database operations.
- **group_22.routingEngine**: Implements the core routing engine, including graph construction, edge management, and the Dijkstra algorithm for pathfinding.
- **group_22.commands**: Defines commands for handling different requests, such as loading data and pinging the system.
- **group_22.GUI**: Provides a graphical user interface for users to input travel information and view routes on a map.
- **group_22.coordinates**: Contains a class for calculating distances between geographical coordinates.

## 3. Key Classes and Their Functions

### 3.1 GTFSReader (group_22.gtfs)
- **Function**: Reads GTFS data from a ZIP file, unzips it, and loads the data into the database.
- **Usage**: Create an instance of `GTFSReader` with the path to the GTFS ZIP file, and it will automatically process and load the data.

### 3.2 DBManager (group_22.DBManager)
- **Function**: Manages the database connection. It can connect to the database using environment variables or default local settings.
- **Usage**: Call the static method `getConnection()` to obtain a database connection.

### 3.3 RoutingEngine (group_22.routingEngine)
- **Function**: The core of the routing system. It loads data from the database, constructs a graph representing the transit network, and handles incoming requests for routing.
- **Usage**: Create an instance of `RoutingEngine` and call the `run()` method to start the engine.

### 3.4 Dijkstra (group_22.routingEngine)
- **Function**: Implements the Dijkstra algorithm to find the shortest path between two points in the transit network.
- **Usage**: Create an instance of `Dijkstra` with a `GTFSGraph` object, and call the `run()` method with the start and end coordinates and the departure time.

### 3.5 MapApp (group_22.GUI)
- **Function**: Provides a GUI for users to input travel information (departure and arrival points, departure time) and view the calculated routes on a map.
- **Usage**: Run the `start()` method to launch the GUI.

## 4. Setup and Installation

### 4.1 Prerequisites
- **Java Development Kit (JDK)**: Version 8 or higher.
- **MySQL Database**: Installed and running. Create a database named `DBMachine`.
- **Dependencies**: The project may depend on external libraries such as JSON processing libraries and JxBrowser. Make sure to include them in your project.

### 4.2 Configuration
- **Database Configuration**: Update the database connection settings in the `DBManager` class if necessary. You can set the `ROUTING_ENGINE_MYSQL_JDBC` environment variable to use a custom JDBC URL.
- **License Key**: If required by the GUI map component, update the license key in the `MapApp` class.

### 4.3 Compilation and Running
- **Compilation**: Compile all the Java classes in the project. You can use an IDE like IntelliJ IDEA or Eclipse, or compile from the command line using `javac`.
- **Running**: Run the `main()` method in the `RoutingEngine` class to start the routing engine. Then, run the `start()` method in the `MapApp` class to launch the GUI.

## 5. How to Use

### 5.1 Loading GTFS Data
- Send a JSON request with the `load` command and the path to the GTFS ZIP file to the routing engine. The engine will load the data into the database and construct the graph.

### 5.2 Finding Routes
- Run the `App` class to input the departure and arrival points (either by station name or coordinates) and the departure time.
- Click the "Start" button and wait for few minutes to load the GTFS graph.
- Click the "Search Route" button. The GUI will send a request to the routing engine, which will calculate the optimal route using the Dijkstra algorithm.
- The calculated route will be displayed on the map, and the total travel time will be shown on the GUI.
- Find a point and click the "Toggle Heatmap" and "Generate Heatmap" buttons to show the travel time heatmap across the city.

## 6. How to Run

### Maven
- **Commands**: Run `mvn clean compile` and `mvn exec:java` on the terminal.
- **Loading the GTFS data**: Run `{"load":"C:/Users/yourname/Desktop/MyGTFS.zip"}` on the terminal.
- **Route Command**: Run `{"routeFrom": { "lat": 52.384032, "lon": 4.882824}, "to": { "lat": 52.362224 , "lon": 4.884658}, "startingAt": "08:00"} `

## 7. Contributing
Contributions to this project are welcome. Please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them with descriptive commit messages.
4. Push your changes to your forked repository.
5. Submit a pull request to the original repository.