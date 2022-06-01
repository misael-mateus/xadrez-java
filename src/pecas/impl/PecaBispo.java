package pecas.impl;

import movimentos.IMovimento;
import movimentos.impl.MovimentoDiagonalCompleto;

public class PecaBispo extends PecaAbstract {

    public PecaBispo() {
        this.pecaString = new String[]{ "♗","♝"};
        movimentos=new IMovimento[]{
                new MovimentoDiagonalCompleto()
        };
    }
}