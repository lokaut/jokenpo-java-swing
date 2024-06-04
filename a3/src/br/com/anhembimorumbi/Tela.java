package br.com.anhembimorumbi;

import static br.com.anhembimorumbi.util.Constantes.FONT_MENSSAGENS;
import static br.com.anhembimorumbi.util.Constantes.PAPEL;
import static br.com.anhembimorumbi.util.Constantes.PAPEL_PNG;
import static br.com.anhembimorumbi.util.Constantes.PEDRA;
import static br.com.anhembimorumbi.util.Constantes.PEDRA_PNG;
import static br.com.anhembimorumbi.util.Constantes.TESOURA;
import static br.com.anhembimorumbi.util.Constantes.TESOURA_PNG;
import static br.com.anhembimorumbi.util.Utils.renderizandoIcone;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.anhembimorumbi.util.Utils;

public class Tela extends JFrame {

    private JPanel contentPane;

    private JButton btnPedra;
    
    private JButton btnPapel;
    
    private JButton btnTesoura;
    
    private JButton btnRecomecar;

    private JLabel jogadorImg;
    
    private JLabel computadorImg;
    
    private JLabel empate;
    
    private JLabel jogadorGanhou;
    
    private JLabel computadorGanhou;

    private Logica logica;

    public Tela() {
        super("A3 - Jokenpo");
        setBounds(400, 150, 495, 522);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBackground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        configurandoTitulos();
        configurandoBotoes();
        configurarLabels();

        botaoRecomecar();
    }

    private void botaoRecomecar() {
        btnRecomecar = new JButton("Reiniciar");
        btnRecomecar.setBounds(150, 390, 200, 30);
        btnRecomecar.setForeground(new Color(255, 255, 255));
        btnRecomecar.setBackground(new Color(0, 0, 0));
        btnRecomecar.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnRecomecar.setVisible(false);
        btnRecomecar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recomecarJogo();
            }
        });
        contentPane.add(btnRecomecar);
    }

    private void configurarLabels() {
        JLabel playerLabel = new JLabel("Jogador");
        playerLabel.setBounds(80, 258, 245, 54);
        playerLabel.setForeground(new Color(255, 255, 255));
        playerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        JLabel cpu = new JLabel("CPU");
        cpu.setBounds(350, 258, 245, 54);
        cpu.setForeground(new Color(255, 255, 255));
        cpu.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        empate = new JLabel("Empate");
        empate.setBounds(120, 308, 245, 54);
        empate.setFont(FONT_MENSSAGENS);
        empate.setForeground(new Color(255, 255, 255));
        empate.setHorizontalAlignment(SwingConstants.CENTER);

        empate.setVisible(false);

        jogadorGanhou = new JLabel("Você Ganhou");
        jogadorGanhou.setBounds(120, 308, 245, 54);
        jogadorGanhou.setFont(FONT_MENSSAGENS);
        jogadorGanhou.setForeground(new Color(255, 255, 255));
        jogadorGanhou.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(jogadorGanhou);
        jogadorGanhou.setVisible(false);

        computadorGanhou = new JLabel("Você Perdeu");
        computadorGanhou.setBounds(120, 308, 245, 54);
        computadorGanhou.setFont(FONT_MENSSAGENS);
        computadorGanhou.setForeground(new Color(255, 255, 255));
        computadorGanhou.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(computadorGanhou);
        computadorGanhou.setVisible(false);
        
        contentPane.add(empate);
        contentPane.add(cpu);
        contentPane.add(playerLabel);
    }

    private void configurandoBotoes() {
        jogadorImg = new JLabel();
        jogadorImg.setBounds(47, 142, 130, 107);
        contentPane.add(jogadorImg);

        computadorImg = new JLabel();
        computadorImg.setBounds(299, 142, 139, 116);
        contentPane.add(computadorImg);

        logica = new Logica(jogadorImg, computadorImg);
        
        btnTesoura = new JButton(renderizandoIcone(TESOURA_PNG));
        btnTesoura.setBackground(new Color(0, 0, 0));
        btnTesoura.setIcon(Utils.renderizandoIcone(TESOURA_PNG));
        btnTesoura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logica.setOpcaoJogador(TESOURA);
                executarJogo();
            }
        });
        btnTesoura.setBounds(315, 260, 139, 112);
        contentPane.add(btnTesoura);

        btnPapel = new JButton(renderizandoIcone(PAPEL_PNG));
        btnPapel.setBackground(new Color(0, 0, 0));
        btnPapel.setIcon(Utils.renderizandoIcone(PAPEL_PNG));
        btnPapel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logica.setOpcaoJogador(PAPEL);
                executarJogo();
            }
        });
        btnPapel.setBounds(169, 260, 147, 112);
        contentPane.add(btnPapel);

        btnPedra = new JButton(renderizandoIcone(PEDRA_PNG));
        btnPedra.setBackground(new Color(0, 0, 0));
        btnPedra.setIcon(Utils.renderizandoIcone(PEDRA_PNG));
        btnPedra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logica.setOpcaoJogador(PEDRA);
                executarJogo();
            }
        });
        btnPedra.setBounds(22, 260, 147, 112);
        contentPane.add(btnPedra);
    }

    private void configurandoTitulos() {
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
    }

    private void executarJogo() {
        esconderBotoes();
        logica.atualizarEscolhaComputador();
        logica.atualizarEscolhaJogador();
        mostrarResultado();
    }

    private void esconderBotoes() {
        btnPedra.setVisible(false);
        btnPapel.setVisible(false);
        btnTesoura.setVisible(false);
    }

    private void mostrarResultado() {
        String resultado = logica.determinarResultado();
        switch (resultado) {
            case "Empate":
                empate.setVisible(true);
                break;
            case "Jogador":
                jogadorGanhou.setVisible(true);
                break;
            case "Computador":
                computadorGanhou.setVisible(true);
                break;
        }
        btnRecomecar.setVisible(true);
    }

    private void recomecarJogo() {
        btnPedra.setVisible(true);
        btnPapel.setVisible(true);
        btnTesoura.setVisible(true);
        btnRecomecar.setVisible(false);
        empate.setVisible(false);
        jogadorGanhou.setVisible(false);
        computadorGanhou.setVisible(false);
        jogadorImg.setIcon(null);
        computadorImg.setIcon(null);
    }
}
