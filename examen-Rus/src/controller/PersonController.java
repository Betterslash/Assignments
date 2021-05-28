package controller;

import model.Person;
import service.PersonSerivce;
import service.Service;

import java.util.List;

public class PersonController implements Controller{

    private final Service personSerivce;

    public PersonController(){
        this.personSerivce = new PersonSerivce();
    }

    public List<Person> getPersonsByAge(){
        return this.personSerivce.filterPersonsByAge();
    }

    public Person addPerson(Person model){
        return this.personSerivce.addPerson(model);
    }

    @Override
    public Service getService() {
        return this.personSerivce;
    }
}
