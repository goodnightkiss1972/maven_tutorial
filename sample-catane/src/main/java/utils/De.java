package utils;

import java.util.Random;

public class De {
    
    public Integer nbrFaces;
    private Integer valeurDe;

    public De(Integer nbrFaces) {
        this.nbrFaces = nbrFaces;
        this.lanceDe();
    }

    public Integer getValeurDe() {
        return this.valeurDe;
    }

    public void lanceDe() {
        Random r = new Random();
        valeurDe = 1 + r.nextInt(nbrFaces);
    }

}
