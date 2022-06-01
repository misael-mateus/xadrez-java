package tabuleiros;

import gameExceptions.*;
import pecas.interfaces.IPeca;
import pontos.IPonto;

public interface ITabuleiro {
    void montaTabuleiro();
    void validaMovimento(IPonto origem, IPonto destino) throws InvalidMoveException, NotYourTurnException;
    void movimentaPeca(IPonto origem, IPonto destino);
    IPeca getPeca(IPonto local);
}
