package catane;

public class Segment {
    
    private Integer idPointA;
    private Integer idPointB;
    private Joueur proprietaire;

    public Segment(Integer idPointA, Integer idPointB, Joueur proprietaire) {
        if (idPointA == null || idPointB == null) {
            throw new IllegalArgumentException("Un segment doit avoir deux points !");
        }
        this.idPointA = idPointA;
        this.idPointB = idPointB;
        this.proprietaire = proprietaire;
    }

    public Segment(Integer idPointA, Integer idPointB, Joueur proprietaire, Plateau plateau) {
        if (idPointA == null || idPointB == null) {
            throw new IllegalArgumentException("Un segment doit avoir deux points !");
        }
        this.idPointA = idPointA;
        this.idPointB = idPointB;
        this.proprietaire = proprietaire;
        if (!plateau.isSegmentValide(idPointA, idPointB)) {
            throw new IllegalArgumentException("La route entre ces deux points n'est pas constructible !");
        }
    }

    public Integer getIdPointA() {
        return idPointA;
    }

    public Integer getIdPointB() {
        return idPointB;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    
}
