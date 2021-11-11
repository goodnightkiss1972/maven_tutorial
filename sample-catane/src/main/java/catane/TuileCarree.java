package catane;

public class TuileCarree {
    private Integer id;
    private Terrain terrain;

    public TuileCarree(Integer id, Terrain terrain) {
        if  (id == null || terrain == null) {
            throw new IllegalArgumentException("La tuile ne peut etre cree sans un id ou un terrain !!");
        }
        if  (id <= 0) {
            throw new IllegalArgumentException("La tuile ne peut etre cree avec un id negatif ou nul !!");
        }
        this.id = id;
        this.terrain = terrain;
    }

    public Integer getId() {
        return id;
    }
    public Terrain getTerrain() {
        return terrain;
    }
}
