package catane;

public class Joueur {
    String nom;
    Couleur couleur;

    public Joueur(String nom, Couleur couleur) {
        if  (nom == null || couleur == null) {
            throw new IllegalArgumentException("Le joueur ne peut pas etre cree sans nom ou sans couleur !!");
        }
        this.nom = nom;
        this.couleur = couleur;
    }
}
