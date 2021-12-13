package catane;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import enums.Couleur;
import enums.Production;
import enums.TypeJoueur;
import enums.TypePoint;
import utils.ConsoleJ;

public class Plateau04DessinUTest {
    
    @Test
    public void dessineUneLigne() {
        ConsoleJ console = new ConsoleJ();
        Plateau plateau = new Plateau(5, 3, null);
        Integer i;
        for (i = 0; i < plateau.getTailleHorizontale() + 1; i++) {
            console.printNombreEntier99(plateau.getPoints().get(i).getStyle(), i);
        }
        console.println(Couleur.BLEU.getMarqueur(), "Les chiffres de 0 a 5 en mauve.");
        Joueur j1 = new Joueur("robert", Couleur.BLANC, TypeJoueur.HUMAIN);
        j1.changeInventaire(1, Production.ARGILE);
        j1.changeInventaire(1, Production.BOIS);
        j1.changeInventaire(1, Production.LAINE);
        j1.changeInventaire(1, Production.MINERAI);
        j1.acheteColonie(plateau, plateau.getPoints().get(1));
        for (i = 0; i < plateau.getTailleHorizontale() + 1; i++) {
            console.printNombreEntier99(plateau.getPoints().get(i).getStyle(), i);
        }
        console.println(Couleur.BLEU.getMarqueur(), "le chiffre 1 apparait en blanc.");
    }

    @Test
    public void dessinePlateau() {
        Plateau plateau = new Plateau(5, 3, null);
        Joueur j1 = new Joueur("blanc", Couleur.BLANC, TypeJoueur.HUMAIN);
        j1.changeInventaire(1, Production.ARGILE);
        j1.changeInventaire(1, Production.BOIS);
        j1.changeInventaire(1, Production.LAINE);
        j1.changeInventaire(1, Production.MINERAI);
        j1.acheteColonie(plateau, plateau.getPoints().get(2));
        Joueur j2 = new Joueur("rouge", Couleur.ROUGE, TypeJoueur.HUMAIN);
        j2.changeInventaire(1, Production.ARGILE);
        j2.changeInventaire(1, Production.BOIS);
        j2.changeInventaire(1, Production.LAINE);
        j2.changeInventaire(1, Production.MINERAI);
        j2.acheteColonie(plateau, plateau.getPoints().get(9));
        Joueur j3 = new Joueur("bleu", Couleur.BLEU, TypeJoueur.HUMAIN);
        plateau.getPoints().get(13).setProprietaire(j3);
        plateau.getPoints().get(13).setTypePoint(TypePoint.VILLE);
        plateau.getPoints().get(0).setProprietaire(j3);
        plateau.getPoints().get(0).setTypePoint(TypePoint.COLONIE);
        plateau.getPoints().get(23).setProprietaire(j2);
        plateau.getPoints().get(23).setTypePoint(TypePoint.VILLE);
        plateau.dessinePlateau();
    }

    @Test
    public void chercheProprietaireSegment() {
        Plateau plateau = new Plateau(5, 3, null);
        Joueur j1 = new Joueur("Bleu", Couleur.BLEU, TypeJoueur.HUMAIN);
        j1.changeInventaire(1, Production.ARGILE);
        j1.changeInventaire(1, Production.BOIS);
        Segment s1 = new Segment(0, 1, j1, plateau);
        assertThat(j1.acheteRoute(plateau, s1)).isTrue();
        assertThat(plateau.getProprietaireSegment(0, 1)).isEqualTo(j1);
        j1.changeInventaire(1, Production.ARGILE);
        j1.changeInventaire(1, Production.BOIS);
        Segment s2 = new Segment(4, 5, j1, plateau);
        assertThat(j1.acheteRoute(plateau, s2)).isTrue();

        Joueur j2 = new Joueur("Blanc", Couleur.BLANC, TypeJoueur.HUMAIN);
        j2.changeInventaire(1, Production.ARGILE);
        j2.changeInventaire(1, Production.BOIS);
        Segment s3 = new Segment(7, 8, j1, plateau);
        assertThat(j2.acheteRoute(plateau, s3)).isTrue();
        assertThat(plateau.getProprietaireSegment(7, 8)).isEqualTo(j2);
        j2.changeInventaire(1, Production.ARGILE);
        j2.changeInventaire(1, Production.BOIS);
        Segment s4 = new Segment(9, 10, j1, plateau);
        assertThat(j2.acheteRoute(plateau, s4)).isTrue();

        Joueur j3 = new Joueur("Rouge", Couleur.ROUGE, TypeJoueur.HUMAIN);
        j3.changeInventaire(1, Production.ARGILE);
        j3.changeInventaire(1, Production.BOIS);
        Segment s5 = new Segment(0, 6, j1, plateau);
        assertThat(j3.acheteRoute(plateau, s5)).isTrue();
        assertThat(plateau.getProprietaireSegment(0, 6)).isEqualTo(j3);

        j3.changeInventaire(1, Production.ARGILE);
        j3.changeInventaire(1, Production.BOIS);
        Segment s6 = new Segment(16, 22, j3, plateau);
        assertThat(j3.acheteRoute(plateau, s6)).isTrue();
        j3.changeInventaire(1, Production.ARGILE);
        j3.changeInventaire(1, Production.BOIS);
        Segment s7 = new Segment(17, 23, j3, plateau);
        assertThat(j3.acheteRoute(plateau, s7)).isTrue();
        j3.changeInventaire(1, Production.ARGILE);
        j3.changeInventaire(1, Production.BOIS);
        Segment s8 = new Segment(8, 14, j3, plateau);
        assertThat(j3.acheteRoute(plateau, s8)).isTrue();
        j3.changeInventaire(1, Production.ARGILE);
        j3.changeInventaire(1, Production.BOIS);
        Segment s9 = new Segment(9, 15, j3, plateau);
        assertThat(j3.acheteRoute(plateau, s9)).isTrue();

        plateau.dessinePlateau();
    }
}
