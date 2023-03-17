# Solution

```bash
This a program that calculates the cost of a vehicle driving from one point on 
407ETR, to another point.
```
## Usage
```bash
Run the Main class to start the program.
Enter the name of the starting interchange and the ending interchange when prompted.
The program will calculate the distance between the two interchanges using the data from the interchanges.json file and display the total cost of the toll.
```

## To Run
```bash
Please run the following commands in order:
$ mvn clean compile
$ mvn package
$ java -jar target/calculator-java-1.0-SNAPSHOT.jar "Salem Road" "Bramalea Road"
Distance: 48.679
Cost: $12.16975
```

## To Run tests

```bash
To run the tests please run the commands in order
$ mvn test
```
