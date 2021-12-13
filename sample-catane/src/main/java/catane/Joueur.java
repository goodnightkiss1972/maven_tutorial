package catane;

import java.util.Arrays;

import enums.Couleur;
import enums.Production;
import enums.TypeJoueur;
import enums.TypePoint;
import utils.ConsoleJ;
import utils.DialogueJ;

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

    ConsoleJ console = new ConsoleJ();
    DialogueJ dialogue = new DialogueJ();

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

    public void changeInventaire(Integer quantite, Production ressource) {
        if (quantite == null || ressource == null) {
            throw new IllegalArgumentException("il faut une quantite et une ressource pour changer l'inventaire");
        }
        if (ressource == Production.ARGILE) {
            setInventaireArgile(getInventaireArgile() + quantite);
        }
        if (ressource == Production.BLE) {
            setInventaireBle(getInventaireBle() + quantite);
        }
        if (ressource == Production.BOIS) {
            setInventaireBois(getInventaireBois() + quantite);
        }
        if (ressource == Production.LAINE) {
            setInventaireLaine(getInventaireLaine() + quantite);
        }
        if (ressource == Production.MINERAI) {
            setInventaireMinerai(getInventaireMinerai() + quantite);
        }
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public TypeJoueur getTypeJoueur() {
        return typeJoueur;
    }
    
    public boolean peutAcheterRoute() {
        if (getInventaireArgile() < 1 || getInventaireBois() < 1) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public boolean acheteRoute(Plateau plateau, Segment segment) {
        if (peutAcheterRoute() == true && plateau.getProprietaireSegment(segment.getIdPointA(), segment.getIdPointB()) == null && plateau.isSegmentValide(segment.getIdPointA(), segment.getIdPointB())) {
            plateau.getSegments().add(0, segment);
            plateau.getSegments().get(0).setProprietaire(this);
            changeInventaire(-1, Production.ARGILE);
            changeInventaire(-1, Production.BOIS);
            return true;
        }
        return false;
    }

    public boolean peutAcheterColonie() {
        if (getInventaireArgile() < 1 || getInventaireBois() < 1 || getInventaireLaine() < 1 || getInventaireMinerai() < 1) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean acheteColonie(Plateau plateau, Point point) {
        if (peutAcheterColonie() == true && point.getProprietaire() == null && point.peutBatirPourUnJoueur(point, plateau, this)) {
            point.setProprietaire(this);
            point.setTypePoint(TypePoint.COLONIE);
            changeInventaire(-1, Production.ARGILE);
            changeInventaire(-1, Production.BOIS);
            changeInventaire(-1, Production.LAINE);
            changeInventaire(-1, Production.MINERAI);
            ajoutePoints(1);
            return true;
        }
        return false;
    }

    public String getNom() {
        return nom;
    }

    public void joue() {
        console.aLaLigne();
        console.println(getCouleur().getStylo(), getNom() + " choisissez une action :");
        console.println(getCouleur().getStylo(), "0 : passez votre tour");
        console.println(getCouleur().getStylo(), "1 : achetez une route");
        Boolean action;
        do {
            action = lanceAction(dialogue.demandeEntierPrecis(getCouleur().getStylo(), "Votre choix : ", Arrays.asList(0, 1)));
        } while (action == false);
    }

    private Boolean lanceAction(Integer actionChoisie) {
        if (actionChoisie == 0) {
            return true; // on passe son tour donc on arrete le do/while de joue()
        }
        if (actionChoisie == 1) {
            lanceAchatRoute();
        }
        return false; // a part si on a passe son tour (0) on peut choisir une nouvelle action
    }

    private void lanceAchatRoute() {

    }

    public void choisiSegmentDepart(Jeu jeu) {
        Integer idPointA, idPointB;
        do {
        console.println(getCouleur().getMarqueur(), getNom() + " choisissez une route gratuitement...");
        idPointA = dialogue.demandeEntier(getCouleur().getStylo(), "Point de depart : ");
        idPointB = dialogue.demandeEntier(getCouleur().getStylo(), "Point d'arrivee : ");
        } while (jeu.placeSegmentDepart(new Segment(idPointA, idPointB, null), this) == false);
    }

    public void choisiColonieDepart(Jeu jeu) {
        Integer idPoint;
        console.println(getCouleur().getMarqueur(), getNom() + " choisissez une colonie gratuitement...");
        idPoint = dialogue.demandeEntier(getCouleur().getStylo(), "Colonie : ");
        jeu.placePointDepart(jeu.getPlateau().getPoints().get(idPoint), this);
    }

}
