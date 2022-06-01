package pecas.impl;

import movimentos.IMovimento;
import movimentos.impl.MovimentoDiagonalPeao;
import movimentos.impl.MovimentoVerticalPeao;

public class PecaPeao extends PecaAbstract {

    public PecaPeao() {
        this.pecaString = new String[]{"♙", "♟"};
        this.movimentos=new IMovimento[]{
                new MovimentoVerticalPeao(),
                new MovimentoDiagonalPeao()
        };
    }

}