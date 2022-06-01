package gameExceptions;

public class InvalidMoveException extends Exception {

    @Override
    public String getMessage() {
        return "Movimento inválido";
    }
}
