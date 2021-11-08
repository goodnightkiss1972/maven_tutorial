package catane;

import utils.De;

public class Jeu {

    // le jeu possede deux des a 6 faces que les joueurs vont utiliser
    De D1 = new De(6);
    De D2 = new De(6);

    public Integer tirage;

    public Integer getTirage() {
        tirage = D1.getValeurDe() + D2.getValeurDe();
        return tirage;
    }
    public void lanceLesDes() {
        D1.lanceDe();
        D2.lanceDe();
    }

}
