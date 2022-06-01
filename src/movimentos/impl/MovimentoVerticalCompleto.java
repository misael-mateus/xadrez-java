package movimentos.impl;

import movimentos.IMovimento;
import pecas.interfaces.IPeca;
import pontos.IPonto;


public class MovimentoVerticalCompleto implements IMovimento {
    @Override
    public boolean valida(IPeca origem, IPonto destino, int tamanhoMovimento) {
        if (origem.getColuna()!=destino.getColuna()) return false;
        return true;
    }

}
