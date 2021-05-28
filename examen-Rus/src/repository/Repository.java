package repository;

import model.Person;

import java.util.List;

public interface Repository {
    List<Person> getRepresentation();

    void deletePerson(int id);

    void addPerson(Person model);
}
