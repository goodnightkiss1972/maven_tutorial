package enums;

import org.junit.jupiter.api.Test;

import catane.Joueur;
import utils.AnsiColors;

public class CouleurUTest {
    
    @Test
    public void testStylo() {
        Joueur j1 = new Joueur("Joueur1", Couleur.BLEU, TypeJoueur.HUMAIN);
        System.out.println(j1.getCouleur().getStylo() + "Ceci doit s'ecrire en BLEU" + AnsiColors.ANSI_RESET);
        Joueur j2 = new Joueur("Joueur2", Couleur.BLANC, TypeJoueur.HUMAIN);
        System.out.println(j2.getCouleur().getStylo() + "Ceci doit s'ecrire en BLANC" + AnsiColors.ANSI_RESET);
        Joueur j3 = new Joueur("Joueur3", Couleur.ROUGE, TypeJoueur.HUMAIN);
        System.out.println(j3.getCouleur().getStylo() + "Ceci doit s'ecrire en ROUGE" + AnsiColors.ANSI_RESET);
        Joueur j4 = new Joueur("Joueur4", Couleur.VERT, TypeJoueur.HUMAIN);
        System.out.println(j4.getCouleur().getStylo() + "Ceci doit s'ecrire en VERT" + AnsiColors.ANSI_RESET);
    }

    @Test
    public void testMarqueur() {
        Joueur j1 = new Joueur("Joueur1", Couleur.BLEU, TypeJoueur.HUMAIN);
        System.out.println(j1.getCouleur().getMarqueur() + "Ceci doit s'ecrire sur fond BLEU" + AnsiColors.ANSI_RESET);
        Joueur j2 = new Joueur("Joueur2", Couleur.BLANC, TypeJoueur.HUMAIN);
        System.out.println(j2.getCouleur().getMarqueur() + "Ceci doit s'ecrire sur fond BLANC" + AnsiColors.ANSI_RESET);
        Joueur j3 = new Joueur("Joueur3", Couleur.ROUGE, TypeJoueur.HUMAIN);
        System.out.println(j3.getCouleur().getMarqueur() + "Ceci doit s'ecrire sur fond ROUGE" + AnsiColors.ANSI_RESET);
        Joueur j4 = new Joueur("Joueur4", Couleur.VERT, TypeJoueur.HUMAIN);
        System.out.println(j4.getCouleur().getMarqueur() + "Ceci doit s'ecrire sur fond VERT" + AnsiColors.ANSI_RESET);
    }

}
