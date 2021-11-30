package utils;

import java.util.Random;

public class De6Faces {
    
    public Integer nbrFaces;
    private Integer tirage;
    private Random rnd;

    public De6Faces() {
        this.nbrFaces = 6;
        rnd = new Random();
        this.setTirage();
    }

    public De6Faces(long seed) {
        this.nbrFaces = 6;
        rnd = new Random(seed);
        this.setTirage();
    }

    public Integer getTirage() {
        return this.tirage;
    }

    public void setTirage() {
        this.tirage = 1 + rnd.nextInt(nbrFaces);
    }

}
