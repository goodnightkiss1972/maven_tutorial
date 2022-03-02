package enums;

import org.junit.jupiter.api.Test;

import utils.AnsiColors;
//import enums.Couleur;

public class CouleurUTest {
    
    @Test
    public void testStylo() {
        System.out.println(Couleur.BLEU.getStylo() + "Ceci doit s'ecrire en BLEU" + AnsiColors.ANSI_RESET);
        System.out.println(Couleur.BLANC.getStylo() + "Ceci doit s'ecrire en BLANC" + AnsiColors.ANSI_RESET);
        System.out.println(Couleur.ROUGE.getStylo() + "Ceci doit s'ecrire en ROUGE" + AnsiColors.ANSI_RESET);
        System.out.println(Couleur.VERT.getStylo() + "Ceci doit s'ecrire en VERT" + AnsiColors.ANSI_RESET);
    }

    @Test
    public void testMarqueur() {
        System.out.println(Couleur.BLEU.getMarqueur() + "Ceci doit s'ecrire sur fond BLEU" + AnsiColors.ANSI_RESET);
        System.out.println(Couleur.BLANC.getMarqueur() + "Ceci doit s'ecrire sur fond BLANC" + AnsiColors.ANSI_RESET);
        System.out.println(Couleur.ROUGE.getMarqueur() + "Ceci doit s'ecrire sur fond ROUGE" + AnsiColors.ANSI_RESET);
        System.out.println(Couleur.VERT.getMarqueur() + "Ceci doit s'ecrire sur fond VERT" + AnsiColors.ANSI_RESET);
    }

}
