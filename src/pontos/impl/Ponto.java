package pontos.impl;

import pontos.IPonto;

public class Ponto implements IPonto {
    private int linha;
    private int coluna;

    public Ponto(){

    }

    public Ponto(int linha, int coluna) {
        this.setColuna(coluna);
        this.setLinha(linha);
    }

    @Override
    public int getLinha() {
        return this.linha;
    }

    @Override
    public int getColuna() {
        return this.coluna;
    }

    @Override
    public void setLinha(int linha) {
        this.linha = linha;
    }

    @Override
    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    @Override
    public void setLocalizacao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    @Override
    public int getDistanciaLinha(int linhaDestino) {
        return linhaDestino-this.linha;
    }

    @Override
    public int getDistanciaColuna(int colunaDestino) {
        return colunaDestino-this.coluna;
    }
}
