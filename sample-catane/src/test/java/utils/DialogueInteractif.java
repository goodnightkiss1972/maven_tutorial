package utils;

import enums.Couleur;
import java.util.Arrays;

public class DialogueInteractif {

    private static ConsoleJ console = new ConsoleJ();
    private static DialogueJ dialogue = new DialogueJ();
    
    public static void main(String[] args) {
        
        Integer reponse = dialogue.demandeEntier(Couleur.BLEU.getStylo(), "(Question ouverte) Veuillez entrer le nombre de joueurs svp: ");
        console.println(Couleur.VERT.getStylo(), "Nous allons jouer a " + reponse + " joueurs.");
        console.aLaLigne();
        Integer reponsePrecise = dialogue.demandeEntierPrecis(Couleur.BLEU.getStylo(), "(Question fermee) Veuillez entrer le nombre de joueurs svp: ", Arrays.asList(3, 4));
        console.println(Couleur.VERT.getStylo(), "Nous allons jouer a " + reponsePrecise + " joueurs.");
        console.aLaLigne();
        String reponseChaine = dialogue.demandeChaine(Couleur.BLEU.getStylo(), "(Question ouverte) Saisissez un nom: ");
        console.println(Couleur.VERT.getStylo(), "Bienvenue " + reponseChaine + " nouveau joueur.");
        console.aLaLigne();
        String reponseChaine2 = dialogue.demandeChainePrecise(Couleur.BLEU.getStylo(), "(Question fermee) Saisissez un type de joueur: ", Arrays.asList("HUMAIN", "IA"));
        console.println(Couleur.VERT.getStylo(), "Bienvenue " + reponseChaine + " nouveau joueur de type " + reponseChaine2 + ".");
        console.aLaLigne();
    
    
    }

}
