package service;

import exception.PersonServiceException;
import lombok.Data;
import model.Person;
import repository.PersonRepository;
import repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PersonSerivce implements Service{

    private final Repository repository;

    public PersonSerivce(){
        this.repository = new PersonRepository();
    }

    public Repository getRepository(){
        return this.repository;
    }

    public List<Person> filterPersonsByAge(){
        return this.repository.getRepresentation()
                .stream()
                .filter(e -> e.getAge() <= 18)
        .collect(Collectors.toList());
    }

    public Person addPerson(Person model) {
        try {
            this.repository.addPerson(model);
            return model;
        }catch (RuntimeException e){
            throw new PersonServiceException("Something went wrong at repository layer during adding a person!!");
        }
    }
}
