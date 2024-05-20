package anhembimorumbi.com.br;

import static anhembimorumbi.com.br.util.Constantes.PAPEL;
import static anhembimorumbi.com.br.util.Constantes.PEDRA;
import static anhembimorumbi.com.br.util.Constantes.TESOURA;

import javax.swing.JLabel;

import anhembimorumbi.com.br.util.Constantes;
import anhembimorumbi.com.br.util.Utils;

public class Logica  implements Jogadas{

    private int opcaoJogador;

    private int opcaoComputador;

    private JLabel jogadorImg;

    private JLabel computadorImg;

    public Logica(JLabel jogadorImg, JLabel computadorImg) {
        this.jogadorImg = jogadorImg;
        this.computadorImg = computadorImg;
    }

    public void setOpcaoJogador(int opcaoJogador) {
        this.opcaoJogador = opcaoJogador;
    }

    @Override
    public void atualizarEscolhaComputador() {
        this.opcaoComputador = (int) (Math.random() * 3 + 1);
        switch (opcaoComputador) {
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

    @Override
    public void atualizarEscolhaJogador() {
        switch (opcaoJogador) {
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

    public String determinarResultado() {
        if (opcaoJogador == opcaoComputador) {
            return "Empate";
        } else if (opcaoJogador == PEDRA && opcaoComputador == TESOURA || opcaoJogador == PAPEL && opcaoComputador == PEDRA || opcaoJogador == TESOURA && opcaoComputador == PAPEL) {
            return "Jogador";
        } else {
            return "Computador";
        }
    }

}
