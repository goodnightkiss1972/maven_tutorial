package catane;

import java.util.LinkedList;
import java.util.List;

import enums.Couleur;
import enums.Terrain;
import utils.ConsoleJ;

public class Plateau {
    
    private Integer tailleHorizontale;
    private Integer tailleVerticale;
    private List<Tuile> tuiles;
    private PointListe points;
    private ConsoleJ console = new ConsoleJ();
    private Couleur couleurFond = Couleur.MAUVE;


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
        Integer i, j, espaces = 4;
        String style;
        for (i = 0; i < points.size(); i++) {
            if (i % (tailleHorizontale + 1) == 0 && i != 0) {
                for (j = 0; j < espaces; j++) {
                    console.aLaLigne();
                }
            }
            if (points.getListe().get(i).getProprietaire() == null) {
                style = Couleur.MAUVE.getStylo();
            }
            else {
                style = points.getListe().get(i).getProprietaire().getCouleur().getStylo();
            }
            console.printNombreEntier99(style, points.getListe().get(i).getIdPoint());
            for (j = 0; j < espaces; j++) {
                console.print(null, "  ");
            }
        }
        console.aLaLigne();
    }

    public void dessinePlateau2() {
        Integer ligne = 0, departPoint = 0, departTuile = 0;
        while (ligne < (tailleVerticale * 2)) {
            if (ligne % 2 == 0) {
                dessineLignePlateau(departPoint);
                departPoint = departPoint + tailleHorizontale + 1;
            }
            else {
                dessineColonnePlateau(departTuile);
                departTuile = departTuile + tailleHorizontale;
            }
            ligne++;
        }
        dessineLignePlateau(departPoint);
    }

    private void dessineLignePlateau(Integer departPoint) {
        Integer i;
        for (i = departPoint; i <= this.tailleHorizontale + departPoint; i++) {
            if (i == departPoint) {
                dessinePoint(i);
            }
            else {
                dessineSegmentHorizontal(i, i + 1);
                dessinePoint(i);
            }
        }
        console.aLaLigne();
    }

    private void dessineColonnePlateau(Integer departTuile) {
        Integer i;
        for (i = departTuile; i <= this.tailleHorizontale + departTuile; i++) {
            dessineSegmentVertical(i, i + this.tailleVerticale);
            console.print(couleurFond.getStylo(), "         ");
        }
        console.aLaLigne();

        for (i = departTuile; i <= this.tailleHorizontale + departTuile; i++) {
            dessineSegmentVertical(i, i + this.tailleVerticale);
            if (i != this.tailleHorizontale + departTuile) {
                console.print(couleurFond.getStylo(), "    " + console.nombreEntier99(couleurFond.getStylo(), i) + "   ");
            }
        }
        console.aLaLigne();

        for (i = departTuile; i <= this.tailleHorizontale + departTuile; i++) {
            dessineSegmentVertical(i, i + this.tailleVerticale);
            console.print(couleurFond.getStylo(), "         ");
        }
        console.aLaLigne();
    }

    private void dessinePoint(Integer idPoint) {
        console.printNombreEntier99(couleurFond.getStylo(), idPoint);
    }

    private void dessineSegmentHorizontal(Integer depart, Integer arrivee) {
        console.print(couleurFond.getStylo(), " ------ ");
    }

    private void dessineSegmentVertical(Integer depart, Integer arrivee) {
        console.print(couleurFond.getStylo(), "|");
    }
}
