package no.sku.person;

import java.util.UUID;


public class Person {
    UUID id;
    String firstName;
    String lastName;

    public Person(String firstName, String lastName) {
        id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
