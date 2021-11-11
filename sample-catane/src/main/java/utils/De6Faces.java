package utils;

import java.util.Random;

public class De6Faces {
    
    public Integer nbrFaces;
    private Integer valeurTirage;

    public De6Faces() {
        this.nbrFaces = 6;
        this.lance();
    }

    public Integer getValeurTirage() {
        return this.valeurTirage;
    }

    public void lance() {
        Random r = new Random();
        valeurTirage = 1 + r.nextInt(nbrFaces);
    }
}
