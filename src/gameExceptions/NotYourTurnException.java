package gameExceptions;

public class NotYourTurnException extends Exception {
    @Override
    public String getMessage() {
        return "Aguarde sua vez de jogar";
    }
}
