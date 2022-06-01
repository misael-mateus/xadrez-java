package gameExceptions;

public class MoveOutFieldException extends InvalidMoveException {

    @Override
    public String getMessage(){
        return super.getMessage()+" - Fora do campo";
    }
}
