package edu.hw3.Task5;

import java.util.Objects;

public class Contact {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact(String name) {
        String[] s = name.split(" ");
        if (s.length == 2) {
            this.firstName = s[0];
            this.lastName = s[1];
        } else {
            this.firstName = s[0];
            this.lastName = null;
        }
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contact contact = (Contact) o;
        return Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
