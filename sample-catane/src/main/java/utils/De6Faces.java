package utils;

import java.util.Random;

public class De6Faces {
    
    public Integer nbrFaces;
    private Random rnd;

    public De6Faces() {
        this.nbrFaces = 6;
        rnd = new Random();
    }

    public De6Faces(long seed) {
        this.nbrFaces = 6;
        rnd = new Random(seed);
    }

    public Integer getTirage() {
        return 1 + rnd.nextInt(nbrFaces);
    }

}
