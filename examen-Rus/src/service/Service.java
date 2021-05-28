package service;

import model.Person;
import repository.Repository;

import java.util.List;

public interface Service {

    Repository getRepository();

    List<Person> filterPersonsByAge();

    Person addPerson(Person model);
}
