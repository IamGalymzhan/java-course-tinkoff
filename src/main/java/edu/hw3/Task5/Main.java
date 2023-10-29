package edu.hw3.Task5;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private Main() {
    }

    public static Contact[] parseContacts(String[] names, String sorting) {
        Contact[] contacts = new Contact[(int) names.length];
        for (int i = 0; i < names.length; i++) {
            contacts[i] = new Contact(names[i]);
        }
        Arrays.sort(contacts, new Comparator<Contact>() {
            public int compare(Contact c1, Contact c2) {
                String fullName1 = (c1.getLastName() != null ? c1.getLastName() + " " : "") + c1.getFirstName();
                String fullName2 = (c2.getLastName() != null ? c2.getLastName() + " " : "") + c1.getLastName();
                return (sorting.equals("ASC") ? fullName1.compareTo(fullName2) : -fullName1.compareTo(fullName2));
            }
        });
        return contacts;
    }
}
