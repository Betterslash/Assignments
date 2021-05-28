package repository;

import lombok.Data;
import model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PersonRepository implements Repository{
    private List<Person> representation;
    private static int LAST_ID = 0;
    public PersonRepository(){
        this.representation = new ArrayList<>();
    }

    public void addPerson(Person model) {
        this.representation.add(model);
        LAST_ID += 1;
    }

    public void deletePerson(int id){
        this.representation = this.representation
                .stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }

    public static int getLastId(){
        return LAST_ID;
    }
}
