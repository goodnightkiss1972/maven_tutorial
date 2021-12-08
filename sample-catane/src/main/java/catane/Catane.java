package catane;

import enums.Couleur;
import enums.TypeJoueur;
import utils.ConsoleJ;
import utils.De6Faces;
import utils.DialogueJ;

import java.util.List;
import java.util.OptionalLong;
import java.util.ArrayList;
import java.util.Arrays;

public class Catane {

    private static ConsoleJ console = new ConsoleJ();
    private static DialogueJ dialogue = new DialogueJ();

    public static void main(String[] args) {
        // point de depart du jeu
        De6Faces d1 = new De6Faces();
        De6Faces d2 = new De6Faces();
        List<Joueur> listeJoueurs = new ArrayList<Joueur>();
        console.effaceTout();
        console.println(Couleur.MAUVE.getStylo(), "*****************");
        console.println(Couleur.JAUNE.getStylo(), "   C A T A N E   ");
        console.println(Couleur.MAUVE.getStylo(), "*****************");
        console.aLaLigne();
        Integer tailleHorizontale = dialogue.demandeEntier(Couleur.BLEU.getStylo(), "Saisissez la taille horizontale du jeu : ");
        Integer tailleVerticale = dialogue.demandeEntier(Couleur.BLEU.getStylo(), "Saisissez la taille verticale du jeu : ");
        console.aLaLigne();
        Integer nombreJoueurs = dialogue.demandeEntierPrecis(Couleur.BLEU.getStylo(), "Veuillez saisir le nombre de joueurs : ", Arrays.asList(3, 4));
        for (Integer i = 1; i <= nombreJoueurs; i++) {
            String nomJoueur = dialogue.demandeChaine(Couleur.BLEU.getStylo(), "Joueur " + i + " quel est votre prenom ? ");
            Couleur couleurJoueur = Couleur.valueOf(dialogue.demandeChainePrecise(Couleur.BLEU.getStylo(), "Joueur " + i + " choisissez une couleur ", Arrays.asList("BLEU", "BLANC", "ROUGE", "VERT")));
            TypeJoueur typeJoueur = TypeJoueur.valueOf(dialogue.demandeChainePrecise(Couleur.BLEU.getStylo(), "Joueur " + i + " etes vous humain ou ordinateur ? ", Arrays.asList("HUMAIN", "IA")));
            Joueur joueur = new Joueur(nomJoueur, couleurJoueur, typeJoueur);
            listeJoueurs.add(joueur);
            console.aLaLigne();
        }
        Jeu jeu;
        if (dialogue.demandeChainePrecise(Couleur.VERT.getStylo(), "Jeu aleatoire ? ", Arrays.asList("O", "N")).equals("N")) {
            jeu = new Jeu(d1, d2, listeJoueurs, tailleHorizontale, tailleVerticale, OptionalLong.of(Long.valueOf(dialogue.demandeEntier(Couleur.VERT.getStylo(), "Entrez le chiffre de votre choix"))));
            console.println(Couleur.VERT.getStylo(), "Jeu pseudo aleatoire avec graine.");
        }
        else {
            jeu = new Jeu(d1, d2, listeJoueurs, tailleHorizontale, tailleVerticale, null);
            console.println(Couleur.VERT.getStylo(), "Jeu aleatoire.");
        }
        jeu.lanceJeu();
    }
}
