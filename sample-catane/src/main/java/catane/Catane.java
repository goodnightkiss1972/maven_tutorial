package catane;

import enums.Couleur;
import enums.TypeJoueur;
import utils.ConsoleJ;
import utils.De6Faces;
import java.util.List;
import java.util.OptionalLong;
import java.io.Console;
import java.util.ArrayList;

public class Catane {
    
    public static void main(String[] args) {
        // point de depart du jeu
        De6Faces d1 = new De6Faces();
        De6Faces d2 = new De6Faces();
        Joueur j1 = new Joueur("eric", Couleur.BLEU, TypeJoueur.HUMAIN);
        Joueur j2 = new Joueur("fabien", Couleur.BLANC, TypeJoueur.IA);
        Joueur j3 = new Joueur("jade", Couleur.ROUGE, TypeJoueur.HUMAIN);
        List<Joueur> joueurs = new ArrayList<Joueur>();
        //joueurs.add(j1);
        //joueurs.add(j2);
        //joueurs.add(j3);
        //Jeu jeu = new Jeu(d1, d2, joueurs, 5, 3, OptionalLong.of(1234));
        ConsoleJ console = new ConsoleJ();
        console.effaceTout();
        console.println(Couleur.MAUVE.getStylo(), "Combien de joueurs vont jouer a Catane svp ?");
        console.println(Couleur.JAUNE.getStylo(), "3 ou 4 joueurs ? ( 3 / 4 )");
    }

}
