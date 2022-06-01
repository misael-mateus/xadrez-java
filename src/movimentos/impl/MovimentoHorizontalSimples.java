package movimentos.impl;

import pecas.interfaces.IPeca;
import pontos.IPonto;

public class MovimentoHorizontalSimples extends MovimentoHorizontalCompleto {

    @Override
    public boolean valida(IPeca origem, IPonto destino, int tamanhoMovimento) {
        if (Math.abs(tamanhoMovimento) > 1) return false;
        return super.valida(origem, destino, tamanhoMovimento);
    }
}
