package exception;

public class NameException extends Exception {

    public NameException(String fullName){
       super("Client Name must be capitalized first character");
    }

}
