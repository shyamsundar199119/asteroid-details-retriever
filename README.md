# Welcome to the Asteroid Details retriever Repository

The mainline for this repository is **master**.

---

This project was developed with Springboot

## Requirements

- Java 8
- Maven

On windows you will need local admin rights to install java and maven.

## Editor

- Intellij is fine
- or eclipse if that's your cup of tea

### Checkout the project

checkout out your project in `C:\Source`. And import in any of the Editor

```
% Navigate to the path src\main\java\eu\spond\asteroiddetailsretriever
% Right click the file AsteroidDetailsRetrieverApplication and click on RUN to start the server
```

## End points

Once the application is started, in the browser, you can hit the below endpoints

```
% http://localhost:8080/asteroids/getClosestTenAsteroidsBetween?fromDate=2015-09-07&toDate=2015-09-08
% http://localhost:8080/asteroids/getLargestAsteroidDetailsDuringTheYear?year=2015
```
