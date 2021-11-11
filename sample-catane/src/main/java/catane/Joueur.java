package catane;

import enums.Couleur;
import enums.TypeJoueur;

public class Joueur {
    String nom;
    Couleur couleur;
    TypeJoueur typeJoueur;

    public Joueur(String nom, Couleur couleur, TypeJoueur typeJoueur) {
        if  (nom == null || couleur == null || typeJoueur == null) {
            throw new IllegalArgumentException("Le joueur ne peut pas etre cree sans nom ou sans couleur ou sans type !!");
        }
        this.nom = nom;
        this.couleur = couleur;
        this.typeJoueur = typeJoueur;
    }
}
