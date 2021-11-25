package catane;

public class Segment {
    
    private Integer idPointA;
    private Integer idPointB;

    public Segment(Integer idPointA, Integer idPointB) {
        if (idPointA == null || idPointB == null) {
            throw new IllegalArgumentException("Un segment doit avoir deux points !");
        }
        this.idPointA = idPointA;
        this.idPointB = idPointB;
    }

    public Integer getIdPointA() {
        return idPointA;
    }

    public Integer getIdPointB() {
        return idPointB;
    }
}
