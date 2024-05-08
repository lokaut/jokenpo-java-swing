package anhembimorumbi.com.br;

import static anhembimorumbi.com.br.util.Constantes.PAPEL_PNG;
import static anhembimorumbi.com.br.util.Constantes.TESOURA_PNG;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import anhembimorumbi.com.br.util.Constantes;
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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    Tela frame = new Tela();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public Tela() {
        super("A3 - Jokenpo");
        //setIconImage(Toolkit.getDefaultToolkit().getImage("/a3/resource/1.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 495, 422);
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

        jogadorImg = new JLabel("");
        jogadorImg.setBounds(47, 142, 130, 107);
        contentPane.add(jogadorImg);

        computadorImg = new JLabel("");
        computadorImg.setBounds(299, 142, 139, 116);
        contentPane.add(computadorImg);

        btnTe = new JButton("");
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
        btnPedra.setIcon(new ImageIcon("/a3/resource/tesoura.png"));
        try {
            BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\antonio.rodrigues\\Documents\\workspacejavaestudo\\A3 jogo\\a3\\resource\\pedra.png"));
            Image resizedImage = originalImage.getScaledInstance(147, 112, Image.SCALE_SMOOTH); // Redimensiona a imagem para caber no botão
            // Cria um ImageIcon com a imagem redimensionada
            ImageIcon icon2 = new ImageIcon(resizedImage);
            // Define o ícone para o botão
            btnPedra.setIcon(icon2);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        jogadorGanhou.setBounds(90, 308, 245, 54);
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

        btnRecomecar = new JButton("reiniciar");
        btnRecomecar.setBounds(150, 360, 200, 30); // Ajuste as dimensões conforme necessário
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
                try {
                    BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\antonio.rodrigues\\Documents\\workspacejavaestudo\\A3 jogo\\a3\\resource\\pedra.png"));
                    Image resizedImage = originalImage.getScaledInstance(147, 112, Image.SCALE_SMOOTH); // Redimensiona a imagem para caber no botão
                    // Cria um ImageIcon com a imagem redimensionada
                    ImageIcon icon2 = new ImageIcon(resizedImage);
                    // Define o ícone para o botão
                    jogadorImg.setIcon(icon2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                try {
                    BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\antonio.rodrigues\\Documents\\workspacejavaestudo\\A3 jogo\\a3\\resource\\papel.png"));
                    Image resizedImage = originalImage.getScaledInstance(147, 112, Image.SCALE_SMOOTH); // Redimensiona a imagem para caber no botão
                    // Cria um ImageIcon com a imagem redimensionada
                    ImageIcon icon2 = new ImageIcon(resizedImage);
                    // Define o ícone para o botão
                    jogadorImg.setIcon(icon2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case 3:
                try {
                    BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\antonio.rodrigues\\Documents\\workspacejavaestudo\\A3 jogo\\a3\\resource\\tesoura.png"));
                    Image resizedImage = originalImage.getScaledInstance(147, 112, Image.SCALE_SMOOTH); // Redimensiona a imagem para caber no botão
                    // Cria um ImageIcon com a imagem redimensionada
                    ImageIcon icon2 = new ImageIcon(resizedImage);
                    // Define o ícone para o botão
                    jogadorImg.setIcon(icon2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

        }
        int computador = (int) (Math.random() * 3 + 1);

        switch (computador) {
            case 1:
                try {
                    BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\antonio.rodrigues\\Documents\\workspacejavaestudo\\A3 jogo\\a3\\resource\\pedra.png"));
                    Image resizedImage = originalImage.getScaledInstance(147, 112, Image.SCALE_SMOOTH); // Redimensiona a imagem para caber no botão
                    // Cria um ImageIcon com a imagem redimensionada
                    ImageIcon icon2 = new ImageIcon(resizedImage);
                    // Define o ícone para o botão
                    jogadorImg.setIcon(icon2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                try {
                    BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\antonio.rodrigues\\Documents\\workspacejavaestudo\\A3 jogo\\a3\\resource\\papel.png"));
                    Image resizedImage = originalImage.getScaledInstance(147, 112, Image.SCALE_SMOOTH); // Redimensiona a imagem para caber no botão
                    // Cria um ImageIcon com a imagem redimensionada
                    ImageIcon icon2 = new ImageIcon(resizedImage);
                    // Define o ícone para o botão
                    jogadorImg.setIcon(icon2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case 3:
                try {
                    BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\antonio.rodrigues\\Documents\\workspacejavaestudo\\A3 jogo\\a3\\resource\\tesoura.png"));
                    Image resizedImage = originalImage.getScaledInstance(147, 112, Image.SCALE_SMOOTH); // Redimensiona a imagem para caber no botão
                    // Cria um ImageIcon com a imagem redimensionada
                    ImageIcon icon2 = new ImageIcon(resizedImage);
                    // Define o ícone para o botão
                    jogadorImg.setIcon(icon2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
        // Resetar as condições iniciais do jogo aqui
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
