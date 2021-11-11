package catane;

import utils.De6Faces;

public class Jeu {

    // le jeu possede deux des a 6 faces que les joueurs vont utiliser
    De6Faces D1 = new De6Faces();
    De6Faces D2 = new De6Faces();

    public Integer valeurDes;

    public Integer getValeurDes() {
        valeurDes = D1.getValeurTirage() + D2.getValeurTirage();
        return valeurDes;
    }
    public void lanceLesDes() {
        D1.lance();
        D2.lance();
    }

}
