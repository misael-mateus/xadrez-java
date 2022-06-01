package pontos;

public interface IPonto {
    int getLinha();

    int getColuna();

    void setLinha(int linha);

    void setColuna(int coluna);

    void setLocalizacao(int linha, int coluna);

    int getDistanciaLinha(int linhaDestino);

    int getDistanciaColuna(int colunaDestino);
}
