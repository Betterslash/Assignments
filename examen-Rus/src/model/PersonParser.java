package model;

import exception.PersonParserException;
import repository.PersonRepository;

public class PersonParser {

    public static Person parse(String name, String age){
        try{
            return new Person(PersonRepository.getLastId(), name, Long.parseLong(age));
        }catch (RuntimeException e){
            throw new PersonParserException("Couldn't parse the person!!");
        }
    }
}
