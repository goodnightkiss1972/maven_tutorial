package catane;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import enums.Couleur;
import enums.Production;
import enums.TypeJoueur;

public class Joueur04GestionColonie {

    @Test
    public void verifieSiUneColoniePeutEtreAchetee() {
        Joueur j1 = new Joueur("fabien", Couleur.BLANC, TypeJoueur.HUMAIN);
        j1.setInventaireArgile(1);
        j1.setInventaireBois(1);
        j1.setInventaireLaine(1);
        j1.setInventaireMinerai(1);
        assertThat(j1.peutAcheterColonies()).isTrue();
        j1.changeInventaire(-1, Production.BOIS);
        assertThat(j1.peutAcheterColonies()).isFalse();
    }

}
