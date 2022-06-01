package tabuleiros.impl;

import enums.enumCorPeca;
import gameExceptions.*;
import pecas.PecaFactory;
import pecas.impl.*;
import pecas.interfaces.IPeca;
import pontos.IPonto;
import pontos.impl.Ponto;
import tabuleiros.ITabuleiro;

public class Tabuleiro implements ITabuleiro {
    private final IPeca[][] tabuleiro;
    private static final int QTDE_COLUNAS = 8;
    private static final int QTDE_LINHAS = 8;
    private enumCorPeca vezAtual = enumCorPeca.BRANCA;

    public Tabuleiro() {
        tabuleiro = new IPeca[QTDE_LINHAS][QTDE_COLUNAS];
    }

    @Override
    public void montaTabuleiro() {
        posicionaPeoes();
        posicionaBispos();
        posicionaCavalos();
        posicionaRainhas();
        posicionaTorres();
        posicionaReis();
    }

    private void posicionaPeoes() {
        int linhaPeaoPreto = 1;
        int linhaPeaoBranco = 6;
        for (int coluna = 0; coluna < QTDE_COLUNAS; coluna++) {
            adicionaPeca(PecaFactory.criaPeca(PecaPeao.class, enumCorPeca.PRETA, new Ponto(linhaPeaoPreto, coluna)));
            adicionaPeca(PecaFactory.criaPeca(PecaPeao.class, enumCorPeca.BRANCA, new Ponto(linhaPeaoBranco, coluna)));
        }
    }

    private void posicionaReis() {
        adicionaPeca(PecaFactory.criaPeca(PecaRei.class, enumCorPeca.PRETA, new Ponto(0, 4)));
        adicionaPeca(PecaFactory.criaPeca(PecaRei.class, enumCorPeca.BRANCA, new Ponto(7, 4)));
    }

    private void posicionaRainhas() {
        adicionaPeca(PecaFactory.criaPeca(PecaRainha.class, enumCorPeca.PRETA, new Ponto(0, 3)));
        adicionaPeca(PecaFactory.criaPeca(PecaRainha.class, enumCorPeca.BRANCA, new Ponto(7, 3)));
    }

    private void posicionaBispos() {
        adicionaPeca(PecaFactory.criaPeca(PecaBispo.class, enumCorPeca.PRETA, new Ponto(0, 2)));
        adicionaPeca(PecaFactory.criaPeca(PecaBispo.class, enumCorPeca.BRANCA, new Ponto(7, 2)));
        adicionaPeca(PecaFactory.criaPeca(PecaBispo.class, enumCorPeca.PRETA, new Ponto(0, 5)));
        adicionaPeca(PecaFactory.criaPeca(PecaBispo.class, enumCorPeca.BRANCA, new Ponto(7, 5)));
    }

    private void posicionaCavalos() {
        adicionaPeca(PecaFactory.criaPeca(PecaCavalo.class, enumCorPeca.PRETA, new Ponto(0, 1)));
        adicionaPeca(PecaFactory.criaPeca(PecaCavalo.class, enumCorPeca.BRANCA, new Ponto(7, 1)));
        adicionaPeca(PecaFactory.criaPeca(PecaCavalo.class, enumCorPeca.PRETA, new Ponto(0, 6)));
        adicionaPeca(PecaFactory.criaPeca(PecaCavalo.class, enumCorPeca.BRANCA, new Ponto(7, 6)));
    }

    private void posicionaTorres() {
        adicionaPeca(PecaFactory.criaPeca(PecaTorre.class, enumCorPeca.PRETA, new Ponto(0, 0)));
        adicionaPeca(PecaFactory.criaPeca(PecaTorre.class, enumCorPeca.BRANCA, new Ponto(7, 0)));
        adicionaPeca(PecaFactory.criaPeca(PecaTorre.class, enumCorPeca.PRETA, new Ponto(0, 7)));
        adicionaPeca(PecaFactory.criaPeca(PecaTorre.class, enumCorPeca.BRANCA, new Ponto(7, 7)));
    }

    private void adicionaPeca(PecaAbstract peca) {
        this.tabuleiro[peca.getLinha()][peca.getColuna()] = peca;
    }

    @Override
    public void validaMovimento(IPonto origem, IPonto destino)
            throws
            InvalidMoveException, NotYourTurnException {
        if (getPeca(origem) == null) throw new InvalidMoveException();
        verificaRodada(origem);
        if (estaForaDoCampo(destino)) throw new MoveOutFieldException();
        temPeca(origem, destino);
        if (!movimentoValido(getPeca(origem), destino)) throw new InvalidMoveException();
    }

    private void verificaRodada(IPonto origem) throws NotYourTurnException {
        IPeca pecaOrigem = getPeca(origem);
        if (!pecaOrigem.getCor().equals(this.vezAtual)) throw new NotYourTurnException();
    }

    private boolean movimentoValido(IPeca peca, IPonto destino) {
        return peca.validaMovimento(destino);
    }

    private void temPeca(IPonto origem, IPonto destino) throws InvalidMoveException {
        if (eUmCompanheiro(getPeca(origem), getPeca(destino))) throw new FriendPositionException();
        movimentoPeao(origem, destino);
    }

    private void movimentoPeao(IPonto origem, IPonto destino) throws InvalidMoveException {
        if (getPeca(origem).toString().equals("♙")
                || getPeca(origem).toString().equals("♟")) {
            if (getPeca(destino) != null) {
                if (origem.getColuna() == destino.getColuna())
                    throw new InvalidMoveException();
            } else {
                if (origem.getColuna() != destino.getColuna()) {
                    throw new InvalidMoveException();
                }
            }

        }
    }

    private boolean eUmCompanheiro(IPeca pecaOrigem, IPeca pecaDestino) {
        if (pecaDestino == null) return false;
        if (pecaOrigem.getCor().equals(pecaDestino.getCor())) return true;
        return false;
    }

    private boolean estaForaDoCampo(IPonto destino) {
        return (destino.getColuna() < 0 || destino.getColuna() > 7) ||
                (destino.getLinha() < 0 || destino.getLinha() > 7);
    }

    @Override
    public IPeca getPeca(IPonto local) {
        return tabuleiro[local.getLinha()][local.getColuna()];
    }

    @Override
    public void movimentaPeca(IPonto origem, IPonto destino) {
        IPeca peca = getPeca(origem);
        peca.setLocalizacao(destino.getLinha(), destino.getColuna());
        this.tabuleiro[destino.getLinha()][destino.getColuna()] = peca;
        this.tabuleiro[origem.getLinha()][origem.getColuna()] = null;
        this.vezAtual = (this.vezAtual.equals(enumCorPeca.BRANCA)) ? enumCorPeca.PRETA : enumCorPeca.BRANCA;
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        for (IPeca[] peca : tabuleiro) {
            for (IPeca p : peca) {
                if (p != null)
                    txt.append(p.toString());
                else
                    txt.append("▒");
            }
            txt.append("\n");
        }
        return txt.toString();
    }


}
