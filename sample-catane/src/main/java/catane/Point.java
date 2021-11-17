package catane;

import java.util.LinkedList;
import java.util.List;

public class Point {
    
    private Integer idPoint;
    private List<Integer> tuilesVoisines;
    
    public Point(Integer idPoint) {
        if (idPoint == null) {
            throw new IllegalArgumentException("La tuile doit avoir un identifiant !!");
        }
        this.idPoint = idPoint;
        tuilesVoisines = new LinkedList<Integer>();
    }

    public Integer getIdPoint() {
        return idPoint;
    }

    public List<Integer> getTuilesVoisines() {
        return tuilesVoisines;
    }

    public void addTuilesVoisines(Integer idTuile) {
        this.tuilesVoisines.add(idTuile);
    }  
    
}
