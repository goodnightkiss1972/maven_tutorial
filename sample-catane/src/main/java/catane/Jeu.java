package catane;

import utils.De6Faces;
import utils.ConsoleJ;

import java.util.List;
import java.util.OptionalLong;

import enums.Production;

public class Jeu {

    private static ConsoleJ console = new ConsoleJ();

    // le jeu possede deux des a 6 faces que les joueurs vont utiliser
    private De6Faces d1;
    private De6Faces d2;
    private List<Joueur> joueurs;
    private Plateau plateau;
    private static final Integer victoire = 10;

    public Jeu(De6Faces d1, De6Faces d2, List<Joueur> joueurs, Integer tailleHorizontale, Integer tailleVerticale, OptionalLong seedPlateau) {
        if (d1 == null || d2 == null || joueurs == null) {
            throw new IllegalArgumentException("il faut 2 des et 3 ou 4 joueurs !");
        }
        if (joueurs.size() < 3 || joueurs.size() > 4) {
            throw new IllegalArgumentException("le jeu se joue a 3 ou 4 joueurs maximum");
        }
        this.d1 = d1;
        this.d2 = d2;
        this.joueurs = joueurs;
        plateau = new Plateau(tailleHorizontale, tailleVerticale, seedPlateau);
    }

    public Integer getTirageDes() {
        return d1.getTirage() + d2.getTirage();
    }

    public Joueur getGagnant() {
        for (Integer i = 0; i < joueurs.size(); i++) {
            if (joueurs.get(i).getPoints() == victoire) {
                return joueurs.get(i);
            }
        }
        return null;
    }

    public Joueur lanceJeu() {
        Integer joueurEnCours = 0;
        do {
            console.effaceTout();
            plateau.dessinePlateau();
            console.aLaLigne();
            plateau.production(getTirageDes());
            dessineInventaire();
            joueurs.get(joueurEnCours).joue(this);
            joueurEnCours++;
            if (joueurEnCours == joueurs.size()) {
                joueurEnCours = 0;
            }
        } while (getGagnant() == null);
        return this.getGagnant();
    }

    public void initialiseJeu() {
        for (Integer i = 0; i < joueurs.size(); i++) {
            console.effaceTout();
            getPlateau().dessinePlateau();
            joueurs.get(i).choisiSegmentDepart(this);
            console.effaceTout();
            getPlateau().dessinePlateau();
            joueurs.get(i).choisiColonieDepart(this);
        }
        for (Integer i = joueurs.size() -1; i >= 0; i--) {
            console.effaceTout();
            getPlateau().dessinePlateau();
            joueurs.get(i).choisiSegmentDepart(this);
            console.effaceTout();
            getPlateau().dessinePlateau();
            joueurs.get(i).choisiColonieDepart(this);
        }
    }

    public void dessineInventaire() {
        for (Integer i = 0; i < joueurs.size(); i++) {
            Joueur j = joueurs.get(i);
            console.print(j.getCouleur().getMarqueur(), j.getNom());
            console.print(j.getCouleur().getStylo(), " " + j.getPoints() + " pts");
            console.print(j.getCouleur().getStylo(), " / Bois = " + j.getInventaireBois());
            console.print(j.getCouleur().getStylo(), " / Argile = " + j.getInventaireArgile());
            console.print(j.getCouleur().getStylo(), " / Laine = " + j.getInventaireLaine());
            console.print(j.getCouleur().getStylo(), " / Ble = " + j.getInventaireBle());
            console.print(j.getCouleur().getStylo(), " / Minerai = " + j.getInventaireMinerai());
            console.aLaLigne();
        }
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public Boolean placeSegmentDepart(Segment segment, Joueur joueur) {
        joueur.changeInventaire(1, Production.ARGILE);
        joueur.changeInventaire(1, Production.BOIS);
        if (joueur.acheteRoute(plateau, segment)) {
            return true;
        }
        else {
            joueur.changeInventaire(-1, Production.ARGILE);
            joueur.changeInventaire(-1, Production.BOIS);
            return false;
        }
    }

    public Boolean placePointDepart(Point point, Joueur joueur) {
        joueur.changeInventaire(1, Production.ARGILE);
        joueur.changeInventaire(1, Production.BOIS);
        joueur.changeInventaire(1, Production.LAINE);
        joueur.changeInventaire(1, Production.MINERAI);
        if (joueur.acheteColonie(plateau, point)) {
            return true;
        }
        else {
            joueur.changeInventaire(-1, Production.ARGILE);
            joueur.changeInventaire(-1, Production.BOIS);
            joueur.changeInventaire(-1, Production.LAINE);
            joueur.changeInventaire(-1, Production.MINERAI);
            return false;
        }
    }


}
