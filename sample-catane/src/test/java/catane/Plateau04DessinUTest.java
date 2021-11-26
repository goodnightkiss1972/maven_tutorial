package catane;

import org.junit.jupiter.api.Test;

import enums.Couleur;
import enums.Production;
import enums.TypeJoueur;
import enums.TypePoint;
import utils.ConsoleJ;

public class Plateau04DessinUTest {
    
    @Test
    public void dessineLigne1Plateau() {
        ConsoleJ console = new ConsoleJ();
        Plateau plateau = new Plateau(5, 3);
        Integer i;
        for (i = 0; i < plateau.getTailleHorizontale() + 1; i++) {
            console.printNombreEntier99(plateau.getPoints().get(i).getCouleur().getStylo(), i);
        }
        console.println(Couleur.BLEU.getMarqueur(), "Les chiffres de 0 a 5 en mauve.");
        Joueur j1 = new Joueur("robert", Couleur.BLANC, TypeJoueur.HUMAIN);
        plateau.getPoints().get(1).setProprietaire(j1);
        for (i = 0; i < plateau.getTailleHorizontale() + 1; i++) {
            console.printNombreEntier99(plateau.getPoints().get(i).getCouleur().getStylo(), i);
        }
        console.println(Couleur.BLEU.getMarqueur(), "le chiffre 1 apparait en blanc.");
    }

    @Test
    public void dessinePlateauPoints() {
        Plateau plateau = new Plateau(5, 3);
        Joueur j1 = new Joueur("blanc", Couleur.BLANC, TypeJoueur.HUMAIN);
        j1.changeInventaire(1, Production.ARGILE);
        j1.changeInventaire(1, Production.BOIS);
        j1.changeInventaire(1, Production.LAINE);
        j1.changeInventaire(1, Production.MINERAI);
        j1.acheteColonie(plateau.getPoints().get(2));
        Joueur j2 = new Joueur("blanc", Couleur.ROUGE, TypeJoueur.HUMAIN);
        j2.changeInventaire(1, Production.ARGILE);
        j2.changeInventaire(1, Production.BOIS);
        j2.changeInventaire(1, Production.LAINE);
        j2.changeInventaire(1, Production.MINERAI);
        j2.acheteColonie(plateau.getPoints().get(9));
        plateau.dessinePlateau();
    }

    @Test
    public void dessinePlateauPoints2() {
        Plateau plateau = new Plateau(5, 3);
        Joueur j1 = new Joueur("blanc", Couleur.BLANC, TypeJoueur.HUMAIN);
        j1.changeInventaire(1, Production.ARGILE);
        j1.changeInventaire(1, Production.BOIS);
        j1.changeInventaire(1, Production.LAINE);
        j1.changeInventaire(1, Production.MINERAI);
        j1.acheteColonie(plateau.getPoints().get(2));
        Joueur j2 = new Joueur("rouge", Couleur.ROUGE, TypeJoueur.HUMAIN);
        j2.changeInventaire(1, Production.ARGILE);
        j2.changeInventaire(1, Production.BOIS);
        j2.changeInventaire(1, Production.LAINE);
        j2.changeInventaire(1, Production.MINERAI);
        j2.acheteColonie(plateau.getPoints().get(9));
        Joueur j3 = new Joueur("bleu", Couleur.BLEU, TypeJoueur.HUMAIN);
        plateau.getPoints().get(13).setProprietaire(j3);
        plateau.getPoints().get(13).setTypePoint(TypePoint.VILLE);
        plateau.getPoints().get(0).setProprietaire(j3);
        plateau.getPoints().get(0).setTypePoint(TypePoint.COLONIE);
        plateau.getPoints().get(23).setProprietaire(j2);
        plateau.getPoints().get(23).setTypePoint(TypePoint.VILLE);
        plateau.dessinePlateau2();
    }
}
