package catane;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import enums.Couleur;
import enums.Production;
import enums.TypeJoueur;
import enums.TypePoint;

public class Joueur04GestionColonie {

    @Test
    public void verifieSiUneColoniePeutEtreAchetee() {
        Joueur j1 = new Joueur("fabien", Couleur.BLANC, TypeJoueur.HUMAIN);
        j1.setInventaireArgile(1);
        j1.setInventaireBois(1);
        j1.setInventaireLaine(1);
        j1.setInventaireMinerai(1);
        assertThat(j1.peutAcheterColonie()).isTrue();
        j1.changeInventaire(-1, Production.BOIS);
        assertThat(j1.peutAcheterColonie()).isFalse();
    }

    @Test
    public void acheteUneColoniesOK() {
        Joueur j2 = new Joueur("eric", Couleur.BLEU, TypeJoueur.HUMAIN);
        Plateau plateau = new Plateau(7, 5, null);
        j2.changeInventaire(1, Production.ARGILE);
        j2.changeInventaire(2, Production.BOIS);
        j2.changeInventaire(1, Production.LAINE);
        j2.changeInventaire(3, Production.MINERAI);
        assertThat(j2.acheteColonie(plateau, plateau.getPoints().get(5))).isTrue();
        assertThat(j2.getInventaireArgile()).isEqualTo(0);
        assertThat(j2.getInventaireBois()).isEqualTo(1);
        assertThat(j2.getInventaireLaine()).isEqualTo(0);
        assertThat(j2.getInventaireMinerai()).isEqualTo(2);
        assertThat(plateau.getPoints().get(5).getProprietaire()).isEqualTo(j2);
        assertThat(plateau.getPoints().get(5).getTypePoint()).isEqualTo(TypePoint.COLONIE);
        assertThat(j2.getPoints()).isEqualTo(1);
    }

    @Test
    public void nePeutPasAcheterColonieOccupee() {
        Joueur j3 = new Joueur("franck", Couleur.ROUGE, TypeJoueur.HUMAIN);
        Joueur j4 = new Joueur("michel", Couleur.BLEU, TypeJoueur.IA);
        Plateau plateau = new Plateau(7, 5, null);
        j3.changeInventaire(1, Production.ARGILE);
        j3.changeInventaire(2, Production.BOIS);
        j3.changeInventaire(1, Production.LAINE);
        j3.changeInventaire(3, Production.MINERAI);
        j4.changeInventaire(1, Production.ARGILE);
        j4.changeInventaire(1, Production.BOIS);
        j4.changeInventaire(1, Production.LAINE);
        j4.changeInventaire(1, Production.MINERAI);
        // j3 achete la colonie au point 5
        assertThat(j3.acheteColonie(plateau, plateau.getPoints().get(5))).isTrue();
        // j4 essaie d'acheter une colonie deja achetee par j3
        assertThat(j4.acheteColonie(plateau, plateau.getPoints().get(5))).isFalse();
    }
}
