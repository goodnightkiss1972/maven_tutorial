package catane;

import java.util.LinkedList;
import java.util.List;

import enums.Couleur;

public class Point {
    
    private Integer idPoint;
    private List<Integer> tuilesVoisines;
    private Joueur proprietaire;

    public Point(Integer idPoint) {
        if (idPoint == null) {
            throw new IllegalArgumentException("La tuile doit avoir un identifiant !!");
        }
        this.idPoint = idPoint;
        this.tuilesVoisines = new LinkedList<Integer>();
        this.proprietaire = null;
    }

    public Integer getIdPoint() {
        return idPoint;
    }

    public List<Integer> getTuilesVoisines() {
        return tuilesVoisines;
    }

    public void addTuilesVoisines(Integer idTuile) {
        this.tuilesVoisines.add(idTuile);
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

}
