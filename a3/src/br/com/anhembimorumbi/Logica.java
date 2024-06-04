package br.com.anhembimorumbi;

import static br.com.anhembimorumbi.util.Constantes.PAPEL;
import static br.com.anhembimorumbi.util.Constantes.PEDRA;
import static br.com.anhembimorumbi.util.Constantes.TESOURA;

import javax.swing.JLabel;

import br.com.anhembimorumbi.util.Constantes;
import br.com.anhembimorumbi.util.Utils;

/**
 * Classe responsável pela lógica do jogo Jokenpo.
 * Implementa a interface Jogadas e gerencia as escolhas do jogador e do computador,
 * além de determinar o resultado do jogo.
 */
public class Logica implements Jogadas {

    private int opcaoJogador;
    private int opcaoComputador;
    private JLabel jogadorImg;
    private JLabel computadorImg;

    /**
     * Construtor da classe Logica.
     *
     * @param jogadorImg JLabel que representa a imagem da escolha do jogador.
     * @param computadorImg JLabel que representa a imagem da escolha do computador.
     */
    public Logica(JLabel jogadorImg, JLabel computadorImg) {
        this.jogadorImg = jogadorImg;
        this.computadorImg = computadorImg;
    }

    /**
     * Define a escolha do jogador.
     *
     * @param opcaoJogador inteiro que representa a escolha do jogador (PEDRA, PAPEL ou TESOURA).
     */
    public void setOpcaoJogador(int opcaoJogador) {
        this.opcaoJogador = opcaoJogador;
    }
    
    /**
     * Atualiza a imagem da escolha do jogador de acordo com a opção selecionada.
     */
    @Override
    public void atualizarEscolhaJogador() {
        switch (this.opcaoJogador) {
            case PEDRA:
                jogadorImg.setIcon(Utils.renderizandoIcone(Constantes.PEDRA_PNG));
                break;
            case PAPEL:
                jogadorImg.setIcon(Utils.renderizandoIcone(Constantes.PAPEL_PNG));
                break;
            case TESOURA:
                jogadorImg.setIcon(Utils.renderizandoIcone(Constantes.TESOURA_PNG));
                break;
        }
    }

    /**
     * Gera uma escolha aleatória para o computador e atualiza a imagem correspondente.
     */
    @Override
    public void atualizarEscolhaComputador() {
        this.opcaoComputador = (int) (Math.random() * 3 + 1);
        switch (this.opcaoComputador) {
            case PEDRA:
                computadorImg.setIcon(Utils.renderizandoIcone(Constantes.PEDRA_PNG));
                break;
            case PAPEL:
                computadorImg.setIcon(Utils.renderizandoIcone(Constantes.PAPEL_PNG));
                break;
            case TESOURA:
                computadorImg.setIcon(Utils.renderizandoIcone(Constantes.TESOURA_PNG));
                break;
        }
    }

    /**
     * Determina o resultado do jogo com base nas escolhas do jogador e do computador.
     *
     * @return uma String que representa o resultado do jogo: "Empate", "Jogador" ou "Computador".
     */
    public String determinarResultado() {
        if (opcaoJogador == opcaoComputador) {
            return "Empate";
        } else if (opcaoJogador == PEDRA && opcaoComputador == TESOURA || 
                   opcaoJogador == PAPEL && opcaoComputador == PEDRA || 
                   opcaoJogador == TESOURA && opcaoComputador == PAPEL) {
            return "Jogador";
        } else {
            return "Computador";
        }
    }
}
