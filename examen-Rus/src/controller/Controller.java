package controller;

import model.Person;
import service.Service;

import java.util.List;

public interface Controller {
    List<Person> getPersonsByAge();

    Person addPerson(Person model);

    Service getService();
}
