package catane;

import enums.Couleur;
import enums.TypeJoueur;

public class Joueur {
    String nom;
    Couleur couleur;
    TypeJoueur typeJoueur;
    Integer points;
    Integer inventaireBois;
    Integer inventaireArgile;
    Integer inventaireLaine;
    Integer inventaireBle;
    Integer inventaireMinerai;

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        if (points < 0) {
            throw new IllegalArgumentException("Il est interdit de mettre des points negatifs !!");
        }
        this.points = points;
    }

    public void ajoutePoints(Integer ptsAjoutes) {
        points = points + ptsAjoutes;
    }

    public void retirePoints(Integer ptsRetires) {
        points = points - ptsRetires;
        if (points < 0) { 
            points = 0; 
        }
    }

    public Integer getInventaireBois() {
        return inventaireBois;
    }

    public void setInventaireBois(Integer inventaireBois) {
        if (inventaireBois < 0) {
            this.inventaireBois = 0;
        }
        else {
            this.inventaireBois = inventaireBois;
        }
    }

    public Integer getInventaireArgile() {
        return inventaireArgile;
    }

    public void setInventaireArgile(Integer inventaireArgile) {
        if (inventaireArgile < 0) {
            this.inventaireArgile = 0;
        }
        else {
            this.inventaireArgile = inventaireArgile;
        }
    }

    public Integer getInventaireLaine() {
        return inventaireLaine;
    }

    public void setInventaireLaine(Integer inventaireLaine) {
        if (inventaireLaine < 0) {
            this.inventaireLaine = 0;
        }
        else {
            this.inventaireLaine = inventaireLaine;
        }
    }

    public Integer getInventaireBle() {
        return inventaireBle;
    }

    public void setInventaireBle(Integer inventaireBle) {
        if (inventaireBle < 0) {
            this.inventaireBle = 0;
        }
        else {
            this.inventaireBle = inventaireBle;
        }
    }

    public Integer getInventaireMinerai() {
        return inventaireMinerai;
    }

    public void setInventaireMinerai(Integer inventaireMinerai) {
        if (inventaireMinerai < 0) {
            this.inventaireMinerai = 0;
        }
        else {
            this.inventaireMinerai = inventaireMinerai;
        }
    }

    public Joueur(String nom, Couleur couleur, TypeJoueur typeJoueur) {
        if  (nom == null || couleur == null || typeJoueur == null) {
            throw new IllegalArgumentException("Le joueur ne peut pas etre cree sans nom ou sans couleur ou sans type !!");
        }
        this.nom = nom;
        this.couleur = couleur;
        this.typeJoueur = typeJoueur;
        this.points = 0;
        this.inventaireBois = 0;
        this.inventaireArgile = 0;
        this.inventaireLaine = 0;
        this.inventaireBle = 0;
        this.inventaireMinerai = 0;
    }

    
}
