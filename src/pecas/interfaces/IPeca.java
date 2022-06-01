package pecas.interfaces;

import enums.enumCorPeca;
import pontos.IPonto;

public interface IPeca extends IPonto {
    boolean validaMovimento(IPonto destino);
    void setCor(enumCorPeca cor);
    enumCorPeca getCor();
}