# Palindrome(not finished)
Palindrome case for interview

This project is built in Java 11 using Spring Boot and maven.

To set up locally with database, you first need to set up postgres: https://www.postgresql.org/
The credentials to your postgres user must replace the variables in DbConnection.java. 
We're only running the database locally so don't worry about leaking credentials.

You also have to run the following SQL in terminal as I have not automated setup in the program yet.

```
  CREATE TABLE if not exists person(
    id UUID not null,
    firstName VARCHAR not null,
    lastName VARCHAR not null,
    PRIMARY KEY id);
```

## TODO:
- Make postgres jdbc work, or change database provider.
- Verify that application can run on Docker Container.
