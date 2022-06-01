package pecas.impl;

import movimentos.IMovimento;
import movimentos.impl.MovimentoEmL;

public class PecaCavalo extends PecaAbstract {

    public PecaCavalo() {
        this.pecaString = new String[]{"♘", "♞"};
        this.movimentos = new IMovimento[]{
                new MovimentoEmL()
        };
    }


}