package exception;

public class PersonParserException extends RuntimeException{
    public PersonParserException(String message){
        super(message);
    }
}
