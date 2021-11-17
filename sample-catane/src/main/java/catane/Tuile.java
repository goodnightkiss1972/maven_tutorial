package catane;

import enums.Production;
import enums.Terrain;

import java.util.LinkedList;
import java.util.List;

public class Tuile {
    
    private Integer id;
    private Terrain terrain;
    private Production produit;
    private List<Integer> pointsVoisins;

    public Tuile(Integer id, Terrain terrain, Production produit) {
        if (id == null) {
            throw new IllegalArgumentException("La tuile doit avoir un identifiant !!");
        }
        this.id = id;
        this.terrain = terrain;
        this.produit = produit;
        pointsVoisins = new LinkedList<Integer>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    
    
    
}
