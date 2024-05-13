
package anhembimorumbi.com.br.enums;

import javax.swing.ImageIcon;

import anhembimorumbi.com.br.util.Constantes;
import anhembimorumbi.com.br.util.Utils;

public enum OpcaoJogada {
    
    PEDRA, PAPEL, TESOURA;

    public static OpcaoJogada getRandomChoice() {
        return values() [(int) (Math.random() * values().length)];
    }

    public ImageIcon getIcon() {
        switch (this) {
            case PEDRA:
                return Utils.renderizandoIcone(Constantes.PEDRA_PNG);
            case PAPEL:
                return Utils.renderizandoIcone(Constantes.PAPEL_PNG);
            case TESOURA:
                return Utils.renderizandoIcone(Constantes.TESOURA_PNG);
            default:
                return null;
        }
    }

}
