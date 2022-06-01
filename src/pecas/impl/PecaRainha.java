package pecas.impl;

import movimentos.IMovimento;
import movimentos.impl.MovimentoDiagonalCompleto;
import movimentos.impl.MovimentoHorizontalCompleto;
import movimentos.impl.MovimentoVerticalCompleto;

public class PecaRainha extends PecaAbstract {

    public PecaRainha() {
        this.pecaString = new String[]{"♕", "♛"};
        this.movimentos=new IMovimento[]{
                new MovimentoVerticalCompleto(),
                new MovimentoHorizontalCompleto(),
                new MovimentoDiagonalCompleto()
        };
    }
}