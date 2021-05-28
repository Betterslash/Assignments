package exception;

public class PersonServiceException extends RuntimeException{

    public PersonServiceException(String message){
        super(message);
    }

}
