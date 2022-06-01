package pecas.impl;

import movimentos.IMovimento;
import movimentos.impl.MovimentoHorizontalCompleto;
import movimentos.impl.MovimentoVerticalCompleto;

public class PecaTorre extends PecaAbstract {

    public PecaTorre() {
        this.pecaString = new String[]{"♖", "♜"};
        this.movimentos = new IMovimento[]{
                new MovimentoHorizontalCompleto(),
                new MovimentoVerticalCompleto()
        };
    }
}