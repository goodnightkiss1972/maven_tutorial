package catane;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalLong;
import java.util.Random;

import enums.Couleur;
import enums.Terrain;
import enums.Production;
import utils.ConsoleJ;

public class Plateau {
    
    private Integer tailleHorizontale;
    private Integer tailleVerticale;
    private OptionalLong optionSeed;
    private List<Tuile> tuiles;
    private List<Point> points;
    private List<Segment> segments; // va contenir uniquement les segments occupés par les joueurs (les routes)

    private ConsoleJ console = new ConsoleJ();
    private Couleur couleurFond = Couleur.MAUVE;


    public Plateau(Integer tailleHorizontale, Integer tailleVerticale, OptionalLong optionSeed) {
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
        this.optionSeed = optionSeed;
        setTuiles();
        setPoints();
        setPointsVoisinsDeTuile(); // on commence par prendre les tuiles et calculer leur voisins
        setPointsVoisinsDePoint();
        setTuilesVoisinesDePoint(); // ensuite on reverse les tableaux pour avoir les tuiles voisines de chaque point
        segments = new ArrayList<Segment>();
        setJetons();
        setTerrains();
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

    public List<Point> getPoints() {
        return this.points;
    }

    private void setPoints() {
        List<Point> points = new ArrayList<Point>();
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
                this.points.get(this.tuiles.get(i).getPointsVoisins().get(j)).addIdTuilesVoisines(i);
            }
        }
    }

    private void setPointsVoisinsDePoint() {
        Integer i;
        for (i = 0; i < getPoints().size(); i++) {
            if (i - 1 >= 0) {
                getPoints().get(i).addIdPointVoisin(i - 1);
            }
            if (i + 1 < getPoints().size()) {
                getPoints().get(i).addIdPointVoisin(i + 1);
            }
            if (i - (getTailleHorizontale() + 1) >= 0) {
                getPoints().get(i).addIdPointVoisin(i - (getTailleHorizontale() + 1));
            }
            if (i + (getTailleHorizontale() + 1) < getPoints().size()) {
                getPoints().get(i).addIdPointVoisin(i + (getTailleHorizontale() + 1));
            }
        }
    }

    public void dessinePlateau() {
        Integer ligne = 0, departPoint = 0, departTuile = 0, departSegment = 0;
        while (ligne < (tailleVerticale * 2)) {
            if (ligne % 2 == 0) {
                dessineLignePlateau(departPoint);
                departPoint = departPoint + tailleHorizontale + 1;
            }
            else {
                dessineColonnePlateau(departTuile, departSegment);
                departTuile = departTuile + tailleHorizontale;
                departSegment = departSegment + tailleHorizontale + 1;
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
                dessineSegmentHorizontal(i - 1, i);
                dessinePoint(i);
            }
        }
        console.aLaLigne();
    }

    private void dessineColonnePlateau(Integer departTuile, Integer departSegment) {
        Integer i;
        for (i = departSegment; i <= this.tailleHorizontale + departSegment; i++) {
            dessineSegmentVertical(i, i + this.tailleHorizontale + 1);
            console.print(couleurFond.getStylo(), "         ");
        }
        console.aLaLigne();

        for (i = departTuile; i <= this.tailleHorizontale + departTuile; i++) {
            if (i != this.tailleHorizontale + departTuile) {
                console.print(couleurFond.getStylo(), "|");
                console.print(couleurFond.getStylo(), "    ");
                console.printNombreEntier99(couleurFond.getStylo(), tuiles.get(i).getJeton());
                console.print(couleurFond.getStylo(), "   ");
            }
        }
        console.print(couleurFond.getStylo(), "|");
        console.aLaLigne();
        for (i = departTuile; i <= this.tailleHorizontale + departTuile; i++) {
            if (i != this.tailleHorizontale + departTuile) {
                console.print(couleurFond.getStylo(), "|");
                console.print(couleurFond.getStylo(), tuiles.get(i).getTerrain().getLabelTerrain());
            }
        }
        console.print(couleurFond.getStylo(), "|");
        console.aLaLigne();

        for (i = departSegment; i <= this.tailleHorizontale + departSegment; i++) {
            dessineSegmentVertical(i, i + this.tailleHorizontale + 1);
            console.print(couleurFond.getStylo(), "         ");
        }
        console.aLaLigne();
    }

    private void dessinePoint(Integer idPoint) {
        console.printNombreEntier99(getPoints().get(idPoint).getStyle(), idPoint);
    }

    public void dessineSegmentHorizontal(Integer depart, Integer arrivee) {
        if (this.getProprietaireSegment(depart, arrivee) == null) {
            console.print(couleurFond.getStylo(), " ------ ");
        }
        else {
            console.print(couleurFond.getStylo(), " ");
            console.print(this.getProprietaireSegment(depart, arrivee).getCouleur().getMarqueur(), "------");
            console.print(couleurFond.getStylo(), " ");
        }
    }

    private void dessineSegmentVertical(Integer depart, Integer arrivee) {
        //System.out.print(depart + "#" + arrivee);
        if (this.getProprietaireSegment(depart, arrivee) == null) {
            console.print(couleurFond.getStylo(), "|");
        }
        else {
            console.print(this.getProprietaireSegment(depart, arrivee).getCouleur().getMarqueur(), "|");
        }
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public Joueur getProprietaireSegment(Integer idPointA, Integer idPointB) {
        Integer ptsA, ptsB;
        if (idPointA == null || idPointB == null) {
            return null;
        }
        if (idPointA < 0 || idPointB < 0) {
            return null;
        }
        if (getSegments().size() == 0) {
            return null;
        }
        if (idPointA < idPointB) {
            ptsA = idPointA;
            ptsB = idPointB;
        }
        else {
            ptsA = idPointB;
            ptsB = idPointA;
        }
        for (Integer i = 0; i < getSegments().size(); i++) {
            if (getSegments().get(i).getIdPointA() == ptsA && getSegments().get(i).getIdPointB() == ptsB) {
                return getSegments().get(i).getProprietaire();
            }
        }
        return null;
    }   

    public Boolean isSegmentValide(Integer idPointA, Integer idPointB) {
        // cas ou le segment est manifestement invalide
        if (idPointA < 0 || idPointA > (points.size() -1)) {
            return false;
        }
        if (idPointB < 0 || idPointB > (points.size() -1)) {
            return false;
        }
        if (idPointA == idPointB) {
            return false;
        }
        if (idPointA > idPointB) {
            return false;
        }

        ArrayList<Integer> bordGauche = new ArrayList<Integer>();
        ArrayList<Integer> bordDroit = new ArrayList<Integer>();
        ArrayList<Integer> bordBas = new ArrayList<Integer>();

        for (int i = 0; i < tailleVerticale + 1; i++) {
            bordGauche.add(i*(tailleHorizontale + 1));
        }
        for (int i = 0 ; i < bordGauche.size(); i++) {
            bordDroit.add(bordGauche.get(i) + tailleHorizontale);
        }
        for (int i = tailleVerticale * (tailleHorizontale + 1) ; i < ((tailleVerticale + 1) * (tailleHorizontale +1)) ; i++) {
            bordBas.add(i);
        }

        if (bordDroit.contains(idPointA) && idPointB == idPointA + 1) {
            return false;
        }
        if (bordBas.contains(idPointA) && idPointB == idPointA + tailleHorizontale + 1) {
            return false;
        }

        // les cas valides si on est pas invalide au préalable
        if (idPointB == idPointA + 1) {
            return true;
        }
        if (idPointB == idPointA + tailleHorizontale + 1) {
            return true;
        }
        
        // dans tout les autres cas on rejette
        return false;
    }

    private void setJetons() {
        Random rnd;
        if (optionSeed == null) {
            rnd = new Random();
        }
        else {
            long localSeed = optionSeed.getAsLong();
            rnd = new Random(localSeed);
        }
        for (int i = 0; i < tailleHorizontale * tailleVerticale; i++) {
            tuiles.get(i).setJeton(2 + rnd.nextInt(11));
        }
    }

    private void setTerrains() {
        Random rnd;
        if (optionSeed == null) {
            rnd = new Random();
        }
        else {
            long localSeed = optionSeed.getAsLong();
            rnd = new Random(localSeed);
        }
        for (int i = 0; i < (((tailleHorizontale * tailleVerticale) - 1) / 2); i++) {
            tuiles.get(i).setTerrain(Terrain.getTerrainParId(rnd.nextInt(5)));
        }
        for (int i = ((tailleHorizontale * tailleVerticale) + 1) / 2; i < (tailleHorizontale * tailleVerticale); i++) {
            tuiles.get(i).setTerrain(Terrain.getTerrainParId(rnd.nextInt(5)));
        }
    }

    public void production(Integer tirage) {
        // pour chaque tuile dont le jeton est egal au tirage
        // faire la liste des croisements voisins occupes par des joueurs
        // et crediter ces joueurs de la production de chaque tuile voisine de ces croisements
        console.println(Couleur.MAUVE.getMarqueur(), "Les DES ont fait : " + tirage);
        List<Tuile> tuilesTirees = getTuilesDeTirage(tirage);
        if (tuilesTirees.size() == 0) {
            console.println(Couleur.MAUVE.getStylo(), "Aucun gain de ressource...");
            return;
        }
        else {
            console.println(Couleur.MAUVE.getStylo(), "Des joueurs gagnent des ressources...");
            for (Integer tuile = 0; tuile < tuilesTirees.size(); tuile++) {
                for (Integer pointsVoisins = 0; pointsVoisins < 4; pointsVoisins++) {
                    //System.out.println(points.get(tuilesTirees.get(tuile).getPointsVoisins().get(pointsVoisins)).getIdPoint());
                    credite(points.get(tuilesTirees.get(tuile).getPointsVoisins().get(pointsVoisins)).getIdPoint());
                }
            }
        }
    }
    
    private List<Tuile> getTuilesDeTirage(Integer tirage) {
        List<Tuile> resultat = new ArrayList<Tuile>();
        for (Integer i = 0; i < tuiles.size(); i++) {
            if (tuiles.get(i).getJeton() == tirage) {
                resultat.add(tuiles.get(i));
            }
        }
        return resultat;
    }

    private void credite(Integer idPoint) {
        if (points.get(idPoint).getProprietaire() == null) {
            return;
        }
        else {
            Joueur j = points.get(idPoint).getProprietaire();
            for (Integer tuilesVoisines = 0; tuilesVoisines < points.get(idPoint).getIdTuilesVoisines().size(); tuilesVoisines++) {
                //System.out.println("##" + points.get(idPoint).getTuilesVoisines().get(tuilesVoisines));
                if (tuiles.get(points.get(idPoint).getIdTuilesVoisines().get(tuilesVoisines)).getTerrain().getIdTerrain() == 0) {
                    j.changeInventaire(1, Production.BOIS);
                }
                if (tuiles.get(points.get(idPoint).getIdTuilesVoisines().get(tuilesVoisines)).getTerrain().getIdTerrain() == 1) {
                    j.changeInventaire(1, Production.ARGILE);
                }
                if (tuiles.get(points.get(idPoint).getIdTuilesVoisines().get(tuilesVoisines)).getTerrain().getIdTerrain() == 2) {
                    j.changeInventaire(1, Production.LAINE);
                }
                if (tuiles.get(points.get(idPoint).getIdTuilesVoisines().get(tuilesVoisines)).getTerrain().getIdTerrain() == 3) {
                    j.changeInventaire(1, Production.BLE);
                }
                if (tuiles.get(points.get(idPoint).getIdTuilesVoisines().get(tuilesVoisines)).getTerrain().getIdTerrain() == 4) {
                    j.changeInventaire(1, Production.MINERAI);
                }
            }
        }
    }

}
