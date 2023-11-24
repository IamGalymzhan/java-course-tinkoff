package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapPersonDatabase implements PersonDatabase {
    private Map<Integer, Person> idToPerson;
    private Map<String, List<Person>> nameToPerson;
    private Map<String, List<Person>> addressToPerson;
    private Map<String, List<Person>> phoneToPerson;

    public MapPersonDatabase() {
        idToPerson = new HashMap<>();
        nameToPerson = new HashMap<>();
        addressToPerson = new HashMap<>();
        phoneToPerson = new HashMap<>();
    }

    @Override
    public void add(Person person) {
        synchronized (this) {
            idToPerson.put(person.id(), person);
            List<Person> nameList = nameToPerson.getOrDefault(person.name(), new ArrayList<>());
            nameList.add(person);
            nameToPerson.put(person.name(), nameList);
            List<Person> addressList = addressToPerson.getOrDefault(person.address(), new ArrayList<>());
            addressList.add(person);
            addressToPerson.put(person.address(), addressList);
            List<Person> phoneList = phoneToPerson.getOrDefault(person.phoneNumber(), new ArrayList<>());
            phoneList.add(person);
            phoneToPerson.put(person.phoneNumber(), phoneList);
        }
    }

    @Override
    public void delete(int id) {
        synchronized (this) {
            Person person = idToPerson.get(id);
            var nameList = nameToPerson.getOrDefault(person.name(), new ArrayList<>());
            nameList.remove(person);
            nameToPerson.put(person.name(), nameList);
            var addressList = addressToPerson.getOrDefault(person.address(), new ArrayList<>());
            addressList.remove(person);
            addressToPerson.put(person.address(), addressList);
            var phoneList = phoneToPerson.getOrDefault(person.phoneNumber(), new ArrayList<>());
            phoneList.remove(person);
            phoneToPerson.put(person.phoneNumber(), phoneList);
        }
    }

    @Override
    public List<Person> findByName(String name) {
        return nameToPerson.getOrDefault(name, List.of());
    }

    @Override
    public List<Person> findByAddress(String address) {
        return addressToPerson.getOrDefault(address, List.of());
    }

    @Override
    public List<Person> findByPhone(String phone) {
        return phoneToPerson.getOrDefault(phone, List.of());
    }
}
