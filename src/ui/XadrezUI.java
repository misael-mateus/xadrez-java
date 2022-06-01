package ui;

import gameExceptions.*;
import pontos.IPonto;
import pontos.impl.Ponto;
import tabuleiros.ITabuleiro;
import tabuleiros.impl.Tabuleiro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashMap;

public class XadrezUI extends JFrame {

    public static void main(String[] args) {
        var frmTabuleiro = new XadrezUI();
        frmTabuleiro.setLocationRelativeTo(null);
        frmTabuleiro.setVisible(true);
    }

    HashMap<String, MyLabel> hash = new HashMap<>();
    ITabuleiro tabuleiro;

    public XadrezUI() {
        super("Xadrez UI");
        this.add(Init());
        this.pack();
    }

    private JPanel Init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        var painel = new JPanel();
        var mouse = new MyClick();
        this.tabuleiro = new Tabuleiro();
        this.tabuleiro.montaTabuleiro();
        painel.addMouseMotionListener(mouse);
        painel.addMouseListener(mouse);
        painel.setLayout(new GridLayout(10, 10));

        var letras = ".ABCDEFGH.".split("");
        Arrays.stream(letras).map(MyLabel::new).forEach(painel::add);

        for (int linha = 8; linha > 0; linha--) {
            painel.add(new MyLabel("" + linha));
            painel = percorreColunas(painel, linha);
            painel.add(new MyLabel("" + linha));
        }
        Arrays.stream(letras).map(MyLabel::new).forEach(painel::add);
        setPosicao("start");
        return painel;
    }


    private JPanel percorreColunas(JPanel painel, int linha) {
        for (char coluna = 'A'; coluna <= 'H'; coluna++) {
            var label = getLabel(coluna, linha);
            painel.add(label);
            hash.put(label.getName(), label);
        }
        return painel;
    }

    private MyLabel getLabel(char coluna, int linha) {
        var cor = verificaCorQuadrado((linha + coluna) % 2);
        var nome = "" + coluna + linha;
        var label = new MyLabel("", cor);
        label.setName(nome);
        return label;
    }

    private Color verificaCorQuadrado(int restoLinhaColuna) {
        if (restoLinhaColuna == 0)
            return Color.DARK_GRAY;
        return Color.getHSBColor(139, 35, 35);
    }

    private void showMensagem(String texto) {
        JOptionPane.showMessageDialog(null, texto, "Xadrez SI - AVISO", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setPosicao(String fen) {
        if (fen.equalsIgnoreCase("start"))
            fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
        String[] piece = new String['z'];
        String[] vetDesenhos = "♔♕♖♗♘♙♚♛♜♝♞♟".split("");
        char[] vetIdsDosDesenhos = "KQRBNPkqrbnp".toCharArray();
        for (int i = 0; i < vetDesenhos.length; i++)
            piece[vetIdsDosDesenhos[i]] = vetDesenhos[i];

        char row = '8';//56
        char col = 'A';//65

        for (char c : fen.toCharArray()) {
            if (Character.isDigit(c)) {
                col += (c - '0');
            } else if (c == '/') {
                col = 'A';
                row--;
            } else {
                var s = "" + col + row;
                var aux = hash.get(s);
                aux.setText(piece[c]);
                col++;
            }
        }
    }

    class MyClick extends MouseAdapter {

        String origem, destino;

        @Override
        public void mousePressed(MouseEvent e) {

            char x = (char) (64 + e.getX() / 50);
            int y = 9 - e.getY() / 50;

            this.origem = x + "" + y;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            char x = (char) (64 + e.getX() / 50);
            int y = 9 - e.getY() / 50;

            this.destino = x + "" + y;

            try {
                IPonto ori = new Ponto(Math.abs((origem.charAt(1) - '1') - 7), origem.charAt(0) - 'A');
                IPonto dest = new Ponto(Math.abs((destino.charAt(1) - '1') - 7), destino.charAt(0) - 'A');
                tabuleiro.validaMovimento(ori, dest);
                tabuleiro.movimentaPeca(ori, dest);
                atualizaPosicaoPecaNoTabuleiro(origem, destino);
            } catch (MoveOutFieldException outException) {
                showMensagem(outException.getMessage());
            } catch (FriendPositionException friendPositionException) {
                showMensagem(friendPositionException.getMessage());
            } catch (InvalidMoveException invalidMoveException) {
                showMensagem(invalidMoveException.getMessage());
            } catch (NotYourTurnException notYourTurnException) {
                showMensagem(notYourTurnException.getMessage());
            }
            this.origem = null;
        }

        private void atualizaPosicaoPecaNoTabuleiro(String origem, String destino) {
            var o = hash.get(origem);
            var d = hash.get(destino);
            d.setText(o.getText());
            o.setText("");
        }
    }

    static class MyLabel extends JLabel {

        public MyLabel(String text, Color cor) {
            this(text, cor, 40);
        }

        public MyLabel(String text) {
            this(text, Color.lightGray, 15);
        }

        public MyLabel(String text, Color cor, int fontSize) {
            super(text);
            this.setPreferredSize(new Dimension(50, 50));
            this.setFont(new Font("Serif", Font.BOLD, fontSize));
            this.setBackground(cor);
            this.setOpaque(true);
            this.setHorizontalAlignment(CENTER);
        }
    }
}
