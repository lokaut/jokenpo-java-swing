package anhembimorumbi.com.br;

import static anhembimorumbi.com.br.util.Constantes.PAPEL_PNG;
import static anhembimorumbi.com.br.util.Constantes.PEDRA_PNG;
import static anhembimorumbi.com.br.util.Constantes.TESOURA_PNG;
import static anhembimorumbi.com.br.util.Utils.renderizandoIcone;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import anhembimorumbi.com.br.util.Utils;

public class Tela extends JFrame {

    private JPanel contentPane;

    JButton btnPedra;
    JButton btnPapel;
    JButton btnTe;
    int jogador = 0;
    private JLabel jogadorImg;

    private JLabel computadorImg;

    private JLabel empate;

    private JLabel jogadorGanhou;

    private JLabel computadorGanhou;

    private JButton btnRecomecar;

    public Tela() {
        super("A3 - Jokenpo");
        //setIconImage(Toolkit.getDefaultToolkit().getImage("/a3/resource/1.png"));
      setBounds(400, 150, 495, 422);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel tituloGame = new JLabel("JO KEN PÔ");
        tituloGame.setForeground(new Color(255, 255, 255));
        tituloGame.setHorizontalAlignment(SwingConstants.CENTER);
        tituloGame.setFont(new Font("Tahoma", Font.BOLD, 32));
        tituloGame.setBounds(70, 40, 348, 56);
        contentPane.add(tituloGame);

        JLabel subTitulo = new JLabel("ULTRA");
        subTitulo.setFont(new Font("Rage", Font.BOLD, 20));
        subTitulo.setForeground(new Color(255, 255, 255));
        subTitulo.setBounds(281, 60, 130, 107);
        contentPane.add(subTitulo);

        //entender isso aq
        jogadorImg = new JLabel("");
        jogadorImg.setBounds(47, 142, 130, 107);
        contentPane.add(jogadorImg);

        //entender isso aq
        computadorImg = new JLabel("");
        computadorImg.setBounds(299, 142, 139, 116);
        contentPane.add(computadorImg);

        btnTe = new JButton(renderizandoIcone(TESOURA_PNG));
        btnTe.setBackground(new Color(0, 0, 0));
        btnTe.setIcon(Utils.renderizandoIcone(TESOURA_PNG));
        btnTe.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jogador = 3;
                btnPedra.setVisible(false);
                btnPapel.setVisible(false);
                btnTe.setVisible(false);
                jogo();

            }
        });

        btnTe.setBounds(315, 260, 139, 112);
        contentPane.add(btnTe);

        btnPapel = new JButton("");
        btnPapel.setBackground(new Color(0, 0, 0));
        btnPapel.setIcon(Utils.renderizandoIcone(PAPEL_PNG));
        btnPapel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jogador = 2;
                btnPedra.setVisible(false);
                btnPapel.setVisible(false);
                btnTe.setVisible(false);
                jogo();

            }
        });
        btnPapel.setBounds(169, 260, 147, 112);
        contentPane.add(btnPapel); // esse cara que rederiza

        btnPedra = new JButton("");
        btnPedra.setBackground(new Color(0, 0, 0));
        btnPedra.setIcon(Utils.renderizandoIcone(PEDRA_PNG));
        btnPedra.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jogador = 1;
                btnPedra.setVisible(false);
                btnPapel.setVisible(false);
                btnTe.setVisible(false);
                jogo();

            }
        });

        btnPedra.setBounds(22, 260, 147, 112);
        contentPane.add(btnPedra); // esse cara que rederiza7

        // label vitorias

        empate = new JLabel("EMPATE");
        empate.setBounds(145, 308, 171, 54);
        empate.setFont(new Font("Tahoma", Font.BOLD, 30));
        empate.setForeground(new Color(255, 255, 255));
        empate.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(empate);
        empate.setVisible(false);

        jogadorGanhou = new JLabel("Você ganhou");
        jogadorGanhou.setBounds(120, 308, 245, 54);
        jogadorGanhou.setFont(new Font("Tahoma", Font.BOLD, 30));
        jogadorGanhou.setForeground(new Color(255, 255, 255));
        jogadorGanhou.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(jogadorGanhou);
        jogadorGanhou.setVisible(false);

        computadorGanhou = new JLabel("Você Perdeu");
        computadorGanhou.setBounds(90, 308, 245, 54);
        computadorGanhou.setFont(new Font("Tahoma", Font.BOLD, 30));
        computadorGanhou.setForeground(new Color(255, 255, 255));
        computadorGanhou.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(computadorGanhou);
        computadorGanhou.setVisible(false);

        btnRecomecar = new JButton("Reiniciar");
        btnRecomecar.setBounds(150, 360, 200, 30); // Ajuste as dimensões conforme necessário
        btnRecomecar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnRecomecar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recomecarJogo();
            }
        });
        contentPane.add(btnRecomecar);
        btnRecomecar.setVisible(false); // Começa invisível

    }

    private void jogo() {

        switch (jogador) {
            case 1:
                ImageIcon iconePedra= Utils.renderizandoIcone(PEDRA_PNG);
                jogadorImg.setIcon(iconePedra);
                break;

            case 2:
                ImageIcon iconePapel = Utils.renderizandoIcone(PAPEL_PNG);
                jogadorImg.setIcon(iconePapel);
                break;

            case 3:
                ImageIcon iconeTesoura = Utils.renderizandoIcone(TESOURA_PNG);
                jogadorImg.setIcon(iconeTesoura);
                break;

        }
        int computador = (int) (Math.random() * 3 + 1);

        switch (computador) {
            case 1:
                ImageIcon iconePedra= Utils.renderizandoIcone(PEDRA_PNG);
                computadorImg.setIcon(iconePedra);
                break;

            case 2:
                ImageIcon iconePapel = Utils.renderizandoIcone(PAPEL_PNG);
                computadorImg.setIcon(iconePapel);
                break;

            case 3:
                ImageIcon iconeTesoura = Utils.renderizandoIcone(TESOURA_PNG);
                computadorImg.setIcon(iconeTesoura);
                break;
        }

        if (jogador == computador) {
            empate.setVisible(true);
        } else if ((jogador == 1 && computador == 3) || (jogador == 2 && computador == 1) || (jogador == 3 && computador == 2)) {
            jogadorGanhou.setVisible(true);
        } else {
            computadorGanhou.setVisible(true);
        }

        btnRecomecar.setVisible(true); // Mostrar o botão recomeçar após o resultado

    }

    private void recomecarJogo() {
        btnPedra.setVisible(true);
        btnPapel.setVisible(true);
        btnTe.setVisible(true);
        empate.setVisible(false);
        jogadorGanhou.setVisible(false);
        computadorGanhou.setVisible(false);
        jogadorImg.setIcon(null);
        computadorImg.setIcon(null);
        btnRecomecar.setVisible(false); // Esconder o botão de recomeçar até a próxima finalização
    }

}
