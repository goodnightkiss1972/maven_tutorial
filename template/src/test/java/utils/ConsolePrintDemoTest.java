package utils;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import enums.Couleur;

public class ConsolePrintDemoTest {

    @Test
    public void printPourUnJoueur() {
        ConsoleJ console = new ConsoleJ();
        console.print(Couleur.ROUGE.getStylo(), "Ceci est une ecriture au stylo en rouge");
        console.println(Couleur.BLEU.getMarqueur(), "et a la suite une ecriture au marqueur en bleu");
        console.println(Couleur.BLEU.getStylo(), "Ceci est une ecriture au stylo en bleu");
        console.println(Couleur.BLANC.getMarqueur(), "et a la ligne une ecriture au marqueur en blanc");
        console.print(null, "Une ligne en couleur par défaut");
        console.aLaLigne();
        console.print(null, "Une ligne en dessous");
        console.aLaLigne();
    }
    
    @Test
    public void printDeNombres() {
        ConsoleJ console = new ConsoleJ();
        console.printNombreEntier99(Couleur.VERT.getMarqueur(), 5);
        console.print(Couleur.BLEU.getMarqueur(), "A gauche on doit voir 5 et un espace");
        console.aLaLigne();
        console.printNombreEntier99(Couleur.ROUGE.getMarqueur(), 15);
        console.print(Couleur.BLEU.getMarqueur(), "A gauche on doit voir 15");
        console.aLaLigne();
        assertThatThrownBy(() -> console.printNombreEntier99(null, 100)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> console.printNombreEntier99(null, -1)).isInstanceOf(IllegalArgumentException.class);
    }
}
