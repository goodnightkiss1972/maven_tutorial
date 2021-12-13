package catane;

import java.util.ArrayList;
import java.util.List;

import enums.Couleur;
import enums.TypePoint;

public class Point {
    
    private Integer idPoint;
    private List<Integer> idTuilesVoisines;
    private List<Integer> idPointsVoisins;
    private Joueur proprietaire;
    private TypePoint typePoint;

    public Point(Integer idPoint) {
        if (idPoint == null) {
            throw new IllegalArgumentException("La tuile doit avoir un identifiant !!");
        }
        this.idPoint = idPoint;
        setIdTuilesVoisines(new ArrayList<Integer>());
        setIdPointsVoisins(new ArrayList<Integer>());
        this.proprietaire = null;
        this.typePoint = TypePoint.LIBRE;
    }

    public Integer getIdPoint() {
        return idPoint;
    }

    public List<Integer> getIdTuilesVoisines() {
        return idTuilesVoisines;
    }

    public void setIdTuilesVoisines(List<Integer> idTuilesVoisines) {
        this.idTuilesVoisines = idTuilesVoisines;
    }

    public void addIdTuilesVoisines(Integer idTuile) {
        this.idTuilesVoisines.add(idTuile);
    }  
        
    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        if (proprietaire == null) {
            throw new IllegalArgumentException("Le proprietaire est obligatoire");
        }
        this.proprietaire = proprietaire;
    }

    public Couleur getCouleur() {
        if (getProprietaire() == null) {
            return Couleur.MAUVE;
        }
        return getProprietaire().getCouleur();
    }

    public String getStyle() {
        if (getProprietaire() != null && getTypePoint() == TypePoint.COLONIE) {
            return getProprietaire().getCouleur().getStylo();
        }
        if (getProprietaire() != null && getTypePoint() == TypePoint.VILLE) {
            return getProprietaire().getCouleur().getMarqueur();
        }
        return Couleur.MAUVE.getStylo();
    }

    public TypePoint getTypePoint() {
        return typePoint;
    }

    public void setTypePoint(TypePoint typePoint) {
        this.typePoint = typePoint;
    }

    public List<Integer> getIdPointsVoisins() {
        return idPointsVoisins;
    }

    public void setIdPointsVoisins(List<Integer> idPointsVoisins) {
        this.idPointsVoisins = idPointsVoisins;
    }

    public void addIdPointVoisin(Integer idPoint) {
        getIdPointsVoisins().add(idPoint);
    }  


    public Boolean peutBatirPourUnJoueur(Point point, Plateau plateau, Joueur joueur) {
        // on peut batir au point X si une route appartenant au joueur y arrive
        // et il ne faut pas qu'il y ait deja une construction du joueur autour de X.

        // Compte le nombre de constructions du joueur autour de X
        Integer compteConstruction = 0;
        for (Integer i = 0; i < point.getIdPointsVoisins().size(); i++) {
            if (plateau.getPoints().get(point.getIdPointsVoisins().get(i)).getProprietaire() == joueur) {
                compteConstruction++;
            }
        }
        if (compteConstruction > 0) {
            System.out.println("Impossible, une de vos construction est trop proche !");
            return false;
        }

        Integer compteRoute = 0;
        for (Integer i = 0; i < point.getIdPointsVoisins().size(); i++) {
            if (plateau.getProprietaireSegment(point.getIdPoint(), plateau.getPoints().get(point.getIdPointsVoisins().get(i)).getIdPoint()) == joueur) {
                compteRoute++;
            }
        }
        if (compteRoute == 0) {
            System.out.println("Impossible, aucune de vos routes n'arrive ici !");
            return false;
        }
        return true;
    } 


}
