package anhembimorumbi.com.br;

import static anhembimorumbi.com.br.enums.OpcaoJogada.PAPEL;
import static anhembimorumbi.com.br.enums.OpcaoJogada.PEDRA;
import static anhembimorumbi.com.br.enums.OpcaoJogada.TESOURA;
import static anhembimorumbi.com.br.enums.Resultado.COMPUTADOR_GANHOU;
import static anhembimorumbi.com.br.enums.Resultado.EMPATE;
import static anhembimorumbi.com.br.enums.Resultado.JOGADOR_GANHOU;

import anhembimorumbi.com.br.enums.OpcaoJogada;
import anhembimorumbi.com.br.enums.Resultado;

public class LogicaJogo {

    private OpcaoJogada opcaoJogador;

    private OpcaoJogada opcaoComputador;

    public Resultado resultado;

    public void playGame(OpcaoJogada opcaoEscolhida) {
        this.opcaoJogador = opcaoEscolhida;
        this.opcaoComputador = OpcaoJogada.getRandomChoice();
        getCalcularResultado();
    }

    public OpcaoJogada getPlayerChoice() {
        return opcaoJogador;
    }

    public OpcaoJogada getComputerChoice() {
        return opcaoComputador;
    }
    
    public Resultado getResultado() {
        return resultado;
    }

    private void getCalcularResultado() {
        if (opcaoJogador == opcaoComputador) {
            resultado = EMPATE;
        } else if ((opcaoJogador == PEDRA && opcaoComputador == TESOURA) || (opcaoJogador == PAPEL && opcaoComputador == PEDRA) || (opcaoJogador == TESOURA && opcaoComputador == PAPEL)) {
            resultado = JOGADOR_GANHOU;
        } else {
            resultado = COMPUTADOR_GANHOU;
        }
    }



}
