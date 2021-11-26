package catane;

import java.util.LinkedList;
import java.util.List;

import enums.Terrain;

public class Plateau {
    
    private Integer tailleHorizontale;
    private Integer tailleVerticale;
    private List<Tuile> tuiles;
    private PointListe points;

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
        points = new PointListe();
        setPoints(points);
        setPointsVoisinsDeTuile(); // on commence par prendre les tuiles et calculer leur voisins
        setTuilesVoisinesDePoint(); // ensuite on reverse les tableaux pour avoir les tuiles voisines de chaque point
    }
    
    public Integer getTailleHorizontale() {
        return tailleHorizontale;
    }

    public Integer getTailleVerticale() {
        return tailleVerticale;
    }

    public List<Tuile> getTuiles() {
        return this.tuiles;
    }

    private void setTuiles() {
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

    public PointListe getPoints() {
        return this.points;
    }

    private void setPoints(PointListe points) {
        Integer i;
        for (i = 0; i < (tailleHorizontale + 1) * (tailleVerticale +1); i++) {
            points.add(new Point(i));
        }
        this.points = points;
    }

    private void setPointsVoisinsDeTuile() {
        Integer i;
        Integer ligne = 0;
        Integer positionSurLigne = -1;
        for (i = 0; i < this.tuiles.size(); i++) {
            positionSurLigne++;
            tuiles.get(i).setPointsVoisins(i + ligne);
            tuiles.get(i).setPointsVoisins(i + ligne + 1);
            tuiles.get(i).setPointsVoisins(i + ligne + 1 + tailleHorizontale);
            tuiles.get(i).setPointsVoisins(i + ligne + 1 + tailleHorizontale + 1);
            if (positionSurLigne == tailleHorizontale -1) { // si on arrive en bout de ligne
                ligne++;
                positionSurLigne = -1;
            }
        }
    }
    
    private void setTuilesVoisinesDePoint() {
        Integer i, j;
        for (i = 0; i < this.tuiles.size(); i++) {
            //System.out.println(i);
            for (j = 0; j < this.tuiles.get(i).getPointsVoisins().size(); j++) {
                //System.out.println("##"+ j + "##" + this.tuiles.get(i).getPointsVoisins().get(j));
                this.points.get(this.tuiles.get(i).getPointsVoisins().get(j)).addTuilesVoisines(i);
            }
        }
    }

    public void dessinePlateau() {
        // ConsoleJ console = new ConsoleJ();
        // On veut dessiner les tuiles et les points qui sont leur sommets.
        // on dessine d'abord la premiere ligne,
        // puis ensuite autant de fois que de tuiles les bords gauche, bas et droits de chaque tuile.
        // pour chaque point puis couple de points (qui representent les routes de catane),
        // on ira chercher la couleur du joueur si le point ou le couple de points appartient a un joueur
        // si le point ou le couple est libre on affichera en couleur par defaut.
        
    }

}
