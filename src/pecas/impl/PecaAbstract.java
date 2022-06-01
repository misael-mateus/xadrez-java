package pecas.impl;

import enums.enumCorPeca;
import movimentos.IMovimento;
import pecas.interfaces.IPeca;
import pontos.IPonto;
import pontos.impl.Ponto;


public abstract class PecaAbstract extends Ponto implements IPeca {
    IMovimento[] movimentos;
    enumCorPeca cor;
    String[] pecaString;


    public void setCor(enumCorPeca cor) {
        this.cor = cor;
    }

    public enumCorPeca getCor() {
        return this.cor;
    }

    public boolean validaMovimento(IPonto destino) {
        int distanciaLinha = this.getDistanciaLinha(destino.getLinha());
        int distanciaColuna = this.getDistanciaColuna(destino.getColuna());
        if (distanciaZerada(distanciaLinha, distanciaColuna)) return false;
        for (IMovimento move : this.movimentos) {
            if (move.valida(this, destino, (distanciaColuna > 0) ? distanciaColuna : distanciaLinha)) return true;
        }
        return false;
    }

    private boolean distanciaZerada(int distanciaLinha, int distanciaColuna) {
        if (distanciaColuna == 0 && distanciaLinha == 0) return true;
        return false;
    }

    @Override
    public String toString() {
        if (this.cor.equals(enumCorPeca.PRETA))
            return this.pecaString[0];
        return this.pecaString[1];
    }
}
