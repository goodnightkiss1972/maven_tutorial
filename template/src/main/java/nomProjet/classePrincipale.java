package nomProjet;

import enums.Couleur;
import utils.ConsoleJ;
import utils.De6Faces;
import utils.DialogueJ;

public class classePrincipale {

    private static ConsoleJ console = new ConsoleJ();
    private static DialogueJ dialogue = new DialogueJ();

    public static void main(String[] args) {
        // point de depart du jeu
        De6Faces d1 = new De6Faces();
        De6Faces d2 = new De6Faces();
        console.effaceTout();
        console.println(Couleur.MAUVE.getStylo(), "***************");
        console.println(Couleur.JAUNE.getStylo(), "   S A L U T   ");
        console.println(Couleur.MAUVE.getStylo(), "***************");
        console.aLaLigne();
        Integer tailleHorizontale = dialogue.demandeEntier(Couleur.BLEU.getStylo(), "Saisissez la taille horizontale du jeu : ");
        Integer tailleVerticale = dialogue.demandeEntier(Couleur.BLEU.getStylo(), "Saisissez la taille verticale du jeu : ");
    console.aLaLigne();
    }
}