package movimentos.impl;

import enums.enumCorPeca;
import pecas.interfaces.IPeca;
import pontos.IPonto;

public class MovimentoDiagonalPeao extends MovimentoDiagonalSimples {

    @Override
    public boolean valida(IPeca origem, IPonto destino, int tamanhoMovimento) {
        int distancia=destino.getLinha()-origem.getLinha();
        if (origem.getCor().equals(enumCorPeca.BRANCA)){
            if (distancia>0) return false;
        }else{
            if (distancia<0) return false;
        }
        return super.valida(origem, destino, tamanhoMovimento);
    }
}
