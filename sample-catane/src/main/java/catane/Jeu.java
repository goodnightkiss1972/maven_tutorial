package catane;

import utils.De6Faces;
import java.util.List;
import java.util.OptionalLong;

public class Jeu {

    // le jeu possede deux des a 6 faces que les joueurs vont utiliser
    private De6Faces d1;
    private De6Faces d2;
    private List<Joueur> joueurs;
    private Plateau plateau;

    public Jeu(De6Faces d1, De6Faces d2, List<Joueur> joueurs, Integer tailleHorizontale, Integer tailleVerticale, OptionalLong seedPlateau) {
        this.d1 = d1;
        this.d2 = d2;
        this.joueurs = joueurs;
        plateau = new Plateau(tailleHorizontale, tailleVerticale, seedPlateau);
    }

    public Integer getTirageDes() {
        return d1.getTirage() + d2.getTirage();
    }

    public Joueur getGagnant() {
        return null;
    }

    public void lanceJeu() {
        Integer joueurEnCours = 0;
        while (this.getGagnant() == null) {
            plateau.dessinePlateau();
            plateau.production(getTirageDes());
            joueurs.get(joueurEnCours).joue();
            joueurEnCours++;
            if (joueurEnCours == joueurs.size()) {
                joueurEnCours = 0;
            }
        }
    }

}
