package movimentos.impl;

import movimentos.IMovimento;
import pecas.interfaces.IPeca;
import pontos.IPonto;

public class MovimentoEmL implements IMovimento {


    @Override
    public boolean valida(IPeca origem, IPonto destino, int tamanhoMovimento) {
        double distanciaCavalo = 0;
        distanciaCavalo = Math.pow(origem.getDistanciaLinha(destino.getLinha()), 2);
        distanciaCavalo += Math.pow(origem.getDistanciaColuna(destino.getColuna()), 2);
        return Math.sqrt(distanciaCavalo) == Math.sqrt(5);
    }
}
