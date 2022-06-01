package movimentos.impl;

import movimentos.IMovimento;
import pecas.interfaces.IPeca;
import pontos.IPonto;

public class MovimentoDiagonalCompleto implements IMovimento {


    @Override
    public boolean valida(IPeca origem, IPonto destino, int tamanhoMovimento) {
        int diagonalUmOrigem=origem.getLinha()-origem.getColuna();
        int diagonalDoisOrigem=origem.getLinha()+origem.getColuna();
        int diagonalUmDestino=destino.getLinha()-destino.getColuna();
        int diagonalDoisDestino=destino.getLinha()+destino.getColuna();
        if (diagonalUmOrigem==diagonalUmDestino) return true;
        if (diagonalDoisOrigem==diagonalDoisDestino) return true;
        return false;
    }
}
