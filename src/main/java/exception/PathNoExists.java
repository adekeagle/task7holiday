package exception;

public class PathNoExists extends RuntimeException {

    public PathNoExists() {
    }

    public PathNoExists(String message) {
        super(message);
    }
}
