package catane;

import java.util.LinkedList;
import java.util.List;

import enums.Terrain;

public class Plateau {
    
    private Integer tailleHorizontale;
    private Integer tailleVerticale;
    private List<Tuile> tuiles;
    private List<Point> points;

    public Plateau(Integer tailleHorizontale, Integer tailleVerticale) {
        if (tailleHorizontale == null || tailleVerticale == null) {
            throw new IllegalArgumentException("Le plateau doit être au minimum de 3x3 !");
        }
        if (tailleHorizontale % 2 == 0) {
            throw new IllegalArgumentException("Le plateau doit être de taille impaire (desert au centre) !");
        }
        if (tailleVerticale % 2 == 0) {
            throw new IllegalArgumentException("Le plateau doit être de taille impaire (desert au centre) !");
        }
        this.tailleHorizontale = tailleHorizontale;
        this.tailleVerticale = tailleVerticale;
        setTuiles();
        setPoints();
    }

    public List<Tuile> getTuiles() {
        return tuiles;
    }

    public void setTuiles() {
        List<Tuile> tuiles = new LinkedList<Tuile>();
        Integer i;
        for (i = 0; i < tailleHorizontale * tailleVerticale; i++) {
            tuiles.add(new Tuile(i, null, null));
            if (i == ((tailleHorizontale * tailleVerticale) - 1) / 2) {
                tuiles.get(i).setTerrain(Terrain.DESERT);
            }
        }
        this.tuiles = tuiles;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints() {
        List<Point> points = new LinkedList<Point>();
        Integer i;
        for (i = 0; i < (tailleHorizontale + 1) * (tailleVerticale +1); i++) {
            points.add(new Point(i));
        }
        this.points = points;
    }

    

}
