package naim.julkar.usermanagementsystem.exception;

public class UserNameAlreadyExistsException extends RuntimeException {

    public UserNameAlreadyExistsException(String message) {
        super(message);
    }

    public UserNameAlreadyExistsException() {
        super("Username already exists");
    }
}
