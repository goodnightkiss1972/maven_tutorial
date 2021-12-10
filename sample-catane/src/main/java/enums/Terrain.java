package enums;

public enum Terrain {
    FORET(0, "  Foret  "),
    COLLINE(1, " Colline "), 
    PRE(2, "   Pre   "), 
    CHAMP(3, "  Champ  "), 
    MONTAGNE(4, "Montagne "), 
    DESERT(5, "  Desert ");

    private Integer idTerrain;
    private String labelTerrain;

    private Terrain(Integer idTerrain, String labelTerrain) {
        this.idTerrain = idTerrain;
        this.labelTerrain = labelTerrain;
    }

    public static Terrain getTerrainParId(Integer idTerrain) {
        for (Terrain terrain : Terrain.values()) {
            if (terrain.idTerrain == idTerrain) {
                return terrain;
            }
        }
        return null;
    }

    public Integer getIdTerrain() {
        return idTerrain;
    }

    public String getLabelTerrain() {
        return labelTerrain;
    }

}
