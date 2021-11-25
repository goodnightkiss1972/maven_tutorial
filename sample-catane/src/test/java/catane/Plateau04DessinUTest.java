package catane;

import org.junit.jupiter.api.Test;

import enums.Couleur;
import enums.TypeJoueur;
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
}
