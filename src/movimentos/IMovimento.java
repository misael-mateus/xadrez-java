package movimentos;

import pecas.interfaces.IPeca;
import pontos.IPonto;

public interface IMovimento {
    boolean valida(IPeca origem, IPonto destino, int tamanhoMovimento);
}
