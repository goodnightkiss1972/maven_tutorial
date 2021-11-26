package catane;

import java.util.List;
import java.util.ArrayList;

public class PointListe {
    
    List<Point> liste;

    public PointListe() {
        liste = new ArrayList<Point>();
    }

    public List<Point> getListe() {
        return liste;
    }

    public List<Point> getListeUnJoueur(Joueur joueur) {
        List<Point> resultat = new ArrayList<Point>();
        Integer i;
        for (i = 0; i < this.liste.size(); i++) {
            if (this.liste.get(i).getProprietaire() == joueur) {
                resultat.add(this.liste.get(i));
            }
        }
        return resultat;
    }

    public Point get(Integer rang) {
        return liste.get(rang);
    }

    public void add(Point point){
        liste.add(point);
    }

    public Integer size() {
        return liste.size();
    }

}
