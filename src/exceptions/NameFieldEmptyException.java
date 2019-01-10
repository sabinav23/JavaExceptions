package exceptions;

public class NameFieldEmptyException extends Exception {
    public NameFieldEmptyException(String errorMessege){
        super(errorMessege);
    }
}
