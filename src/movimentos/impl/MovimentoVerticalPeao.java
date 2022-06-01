package movimentos.impl;

import enums.enumCorPeca;
import pecas.interfaces.IPeca;
import pontos.IPonto;

public class MovimentoVerticalPeao extends MovimentoVerticalSimples{

    @Override
    public boolean valida(IPeca origem, IPonto destino, int tamanhoMovimento) {
        if (origem.getCor().equals(enumCorPeca.BRANCA)){
            if (tamanhoMovimento>0) return false;
            if (destino.getLinha()>3) return true;
        }else{
            if (tamanhoMovimento<0) return false;
            if (destino.getLinha()<4) return true;
        }
        return super.valida(origem, destino, tamanhoMovimento);
    }

}
