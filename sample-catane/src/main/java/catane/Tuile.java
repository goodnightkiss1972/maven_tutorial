package catane;

import enums.Production;
import enums.Terrain;

import java.util.LinkedList;
import java.util.List;

public class Tuile {
    
    private Integer idTuile;
    private Terrain terrain;
    private Production produit;
    private Integer jeton;
    private List<Integer> pointsVoisins;

    public Tuile(Integer idTuile, Terrain terrain, Production produit) {
        if (idTuile == null) {
            throw new IllegalArgumentException("La tuile doit avoir un identifiant !!");
        }
        this.idTuile = idTuile;
        this.terrain = terrain;
        this.produit = produit;

        pointsVoisins = new LinkedList<Integer>();
    }

    public Integer getIdTuile() {
        return idTuile;
    }

    public void setIdTuile(Integer idTuile) {
        this.idTuile = idTuile;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Production getProduit() {
        return produit;
    }

    public void setProduit(Production produit) {
        this.produit = produit;
    }

    public List<Integer> getPointsVoisins() {
        return pointsVoisins;
    }

    public void setPointsVoisins(Integer idPoint) {
        this.pointsVoisins.add(idPoint);
    }

    public Integer getJeton() {
        return jeton;
    }

    public void setJeton(Integer jeton) {
        this.jeton = jeton;
    }

    
    
}
