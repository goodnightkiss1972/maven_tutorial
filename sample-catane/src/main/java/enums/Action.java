package enums;

public enum Action {
    PASSE(0, "Passer votre tour"), 
    ROUTE(1, "Acheter une route"),
    COLONIE(2, "Acheter une colonie");

    private Integer idAction;
    private String libelleAction;  
      
    private Action(Integer idAction, String libelleAction) {  
        this.idAction = idAction;
        this.libelleAction = libelleAction;  
    }  
      
    public Integer getIdAction() {  
        return this.idAction ;  
    }  

    public String getLibelleAction() {
        return this.libelleAction;
    }

    public static Action getActionParId(Integer idAction) {
        for (Action action : Action.values()) {
            if (action.idAction == idAction) {
                return action;
            }
        }
        return null;
    }

}
