<p align="center">
  <img src="./public/logo.png" />
</p>

<p align="center">
  <a href="#about">About</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#preview">Preview</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#technologies">Technologies</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#building">Building</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#contributing">Contributing</a>&nbsp;&nbsp;&nbsp;
</p>

## About
<strong>Cities API</strong> is a

## Preview
#### State Methods
```
http://localhost:8080/states

or

http://localhost:8080/states?page={pageNumber}&size={pageSize}&sort={sortType}
```

```
http://localhost:8080/states/{stateId}
```


#### Country Methods
```
http://localhost:8080/countries

or

http://localhost:8080/countries?page={pageNumber}&size={pageSize}&sort={sortType}
```

```
http://localhost:8080/countries/{countryId}
```


#### City Methods
```
http://localhost:8080/cities

or

http://localhost:8080/cities?page={pageNumber}&size={pageSize}&sort={sortType}
```


#### Distance Methods
```
http://localhost:8080/distances/by-points?from={cityId}&to={cityId}
```

```
http://localhost:8080/distances/by-cube?from={cityId}&to={cityId}
```

```
http://localhost:8080/distances/by-math?from={cityId}&to={cityId}&unit={unitType}
```

## Technologies
This project was developed using the following technologies:
- [Spring](https://spring.io/)
- [Java](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [JPA + Hibernate](https://spring.io/projects/spring-data-jpa)
- [Postgres](https://www.postgresql.org/)

## Building
You'll need [Java 11+](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html) and [Maven](https://maven.apache.org/download.cgi) installed on your computer in order to build this app.
```bash
$ git clone https://github.com/eric-souzams/cities-distance-api.git
$ cd /cities-distance-api
$ mvn spring-boot:run
```

## Contributing

This repository is currently under development. If you want to contribute please fork the repository and get your hands dirty, and make the changes as you'd like and submit the Pull request.