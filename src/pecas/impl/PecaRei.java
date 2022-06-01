package pecas.impl;

import movimentos.IMovimento;
import movimentos.impl.MovimentoDiagonalSimples;
import movimentos.impl.MovimentoHorizontalSimples;
import movimentos.impl.MovimentoVerticalSimples;

public class PecaRei extends PecaAbstract {

    public PecaRei() {
        this.pecaString = new String[]{"♔", "♚"};
        this.movimentos=new IMovimento[]{
                new MovimentoVerticalSimples(),
                new MovimentoHorizontalSimples(),
                new MovimentoDiagonalSimples()
        };
    }

}
