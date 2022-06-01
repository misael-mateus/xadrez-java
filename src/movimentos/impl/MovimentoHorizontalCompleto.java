package movimentos.impl;

import movimentos.IMovimento;
import pecas.interfaces.IPeca;
import pontos.IPonto;

public class MovimentoHorizontalCompleto implements IMovimento {


    @Override
    public boolean valida(IPeca origem, IPonto destino, int tamanhoMovimento) {
        if (origem.getLinha() != destino.getLinha()) return false;
        return true;
    }
}
