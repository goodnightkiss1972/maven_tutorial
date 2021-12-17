package enums;

public enum Production {
    BOIS(0, "Bois"), 
    ARGILE(1, "Argile"), 
    LAINE(2, "Laine"), 
    BLE(3, "Ble"), 
    MINERAI(4, "Minerai"), 
    RIEN(99, "Rien");

    private Integer idProduction;
    private String libelleProduction;

    private Production(Integer idProduction, String libelleProduction) {  
        this.idProduction = idProduction;
        this.libelleProduction = libelleProduction;  
    }  
      
    public Integer getIdProduction() {  
        return this.idProduction ;  
    }  

    public String getLibelleProduction() {
        return this.libelleProduction;
    }

    public static Production getProductionParId(Integer idProduction) {
        for (Production Production : Production.values()) {
            if (Production.idProduction == idProduction) {
                return Production;
            }
        }
        return null;
    }


}
