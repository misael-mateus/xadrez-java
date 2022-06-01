package gameExceptions;

public class FriendPositionException extends InvalidMoveException{

    @Override
    public String getMessage(){
        return super.getMessage()+" - Já existe uma peça sua nesse local";
    }
}
