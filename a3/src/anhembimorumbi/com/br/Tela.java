package anhembimorumbi.com.br;

import javax.swing.*;

import anhembimorumbi.com.br.enums.OpcaoJogada;

import java.awt.*;
import java.awt.event.*;

public class Tela extends JFrame {
    
    private JPanel contentPane;
    
    private JButton btnPedra, btnPapel, btnTe;
    
    private JLabel jogadorImg, computadorImg;
    
    private JLabel statusLabel;
    
    private JButton btnRecomecar;
    
    private LogicaJogo gameLogic;

    public Tela() {
        gameLogic = new LogicaJogo();
        setTitle("A3 - Jokenpo");
        setBounds(400, 150, 495, 422);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLACK);
        setContentPane(contentPane);
        setupLabels();
        setupButtons();
    }

    private void setupLabels() {
        // Define e configura o JLabel para a imagem do jogador
        jogadorImg = new JLabel();
        jogadorImg.setBounds(47, 142, 130, 107);
        jogadorImg.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(jogadorImg);

        // Define e configura o JLabel para a imagem do computador
        computadorImg = new JLabel();
        computadorImg.setBounds(299, 142, 139, 116);
        computadorImg.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(computadorImg);

        // Define e configura o JLabel para o status do jogo
        statusLabel = new JLabel("Escolha uma opção");
        statusLabel.setBounds(70, 260, 348, 56);
        statusLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        statusLabel.setForeground(new Color(255, 255, 255));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(statusLabel);

        // Define e configura o botão para recomeçar o jogo
        btnRecomecar = new JButton("Recomeçar");
        btnRecomecar.setBounds(150, 340, 200, 30);
        btnRecomecar.addActionListener(e -> recomecarJogo());
        contentPane.add(btnRecomecar);
        btnRecomecar.setVisible(false); // Começa invisível
    }

    private void setupButtons() {
        // Setup buttons and their action listeners
        btnPedra = createButton("Pedra", 22, 260, OpcaoJogada.PEDRA);
        btnPapel = createButton("Papel", 169, 260, OpcaoJogada.PAPEL);
        btnTe = createButton("Tesoura", 315, 260, OpcaoJogada.TESOURA);
    }

    private JButton createButton(String label, int x, int y, OpcaoJogada opcaoJogada) {
        JButton button = new JButton(label);
        button.setBounds(x, y, 147, 112);
        button.addActionListener(e -> opcaoEscolhida(opcaoJogada));
        contentPane.add(button);
        return button;
    }

    private void opcaoEscolhida(OpcaoJogada opcaoJogada) {
        gameLogic.playGame(opcaoJogada);
        btnPedra.setEnabled(false);
        btnPapel.setEnabled(false);
        btnTe.setEnabled(false);
        updateUI();
    }

    private void updateUI() {
        jogadorImg.setIcon(gameLogic.getPlayerChoice().getIcon());
        computadorImg.setIcon(gameLogic.getComputerChoice().getIcon());
        switch (gameLogic.getResultado()) {
            case EMPATE:
                statusLabel.setText("Empate");
                break;
            case JOGADOR_GANHOU:
                statusLabel.setText("Você ganhou");
                break;
            case COMPUTADOR_GANHOU:
                statusLabel.setText("Você perdeu");
                break;
        }

        // Torna o botão de recomeçar visível após o resultado ser exibido
        btnRecomecar.setVisible(true);
    }

    private void recomecarJogo() {
        btnPedra.setEnabled(true);
        btnPapel.setEnabled(true);
        btnTe.setEnabled(true);
        jogadorImg.setIcon(null);
        computadorImg.setIcon(null);
        jogadorImg.setVisible(false); // Torna a label do jogador invisível
        computadorImg.setVisible(false); // Torna a label do computador invisível
        statusLabel.setIcon(null);
        btnRecomecar.setVisible(false); // Esconder o botão de recomeçar até a próxima finalização
        // Adicione o código para reiniciar o jogo aqui
    }
}


