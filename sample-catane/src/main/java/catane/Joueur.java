package catane;

import java.util.ArrayList;
import java.util.List;

import enums.Couleur;
import enums.Production;
import enums.TypeJoueur;
import enums.TypePoint;
import enums.Action;
import utils.ConsoleJ;
import utils.DialogueJ;

public class Joueur {
    String nom;
    Couleur couleur;
    TypeJoueur typeJoueur;
    Integer points;
    Integer inventaireBois;
    Integer inventaireArgile;
    Integer inventaireLaine;
    Integer inventaireBle;
    Integer inventaireMinerai;
    List<Integer> listeIdActions = new ArrayList<>();
    List<Integer> listeProductionCommerce4 = new ArrayList<>();

    ConsoleJ console = new ConsoleJ();
    DialogueJ dialogue = new DialogueJ();

    public Joueur(String nom, Couleur couleur, TypeJoueur typeJoueur) {
        if  (nom == null || couleur == null || typeJoueur == null) {
            throw new IllegalArgumentException("Le joueur ne peut pas etre cree sans nom ou sans couleur ou sans type !!");
        }
        this.nom = nom;
        this.couleur = couleur;
        this.typeJoueur = typeJoueur;
        this.points = 0;
        this.inventaireBois = 0;
        this.inventaireArgile = 0;
        this.inventaireLaine = 0;
        this.inventaireBle = 0;
        this.inventaireMinerai = 0;
    }

    public List<Integer> getListeIdActions() {
        return rafraichitActions();
    }

    public void setListeIdActions() {
        this.listeIdActions = rafraichitActions();
    }

    public List<Integer> getListeProductionCommerce4() {
        return rafraichitProductionCommerce4();
    }

    public void setListeProductionCommerce4(List<Integer> listeProductionCommerce4) {
        this.listeProductionCommerce4 = rafraichitProductionCommerce4();
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        if (points < 0) {
            throw new IllegalArgumentException("Il est interdit de mettre des points negatifs !!");
        }
        this.points = points;
    }

    public void ajoutePoints(Integer ptsAjoutes) {
        points = points + ptsAjoutes;
    }

    public void retirePoints(Integer ptsRetires) {
        points = points - ptsRetires;
        if (points < 0) { 
            points = 0; 
        }
    }

    public Integer getInventaireBois() {
        return inventaireBois;
    }

    public void setInventaireBois(Integer inventaireBois) {
        if (inventaireBois < 0) {
            this.inventaireBois = 0;
        }
        else {
            this.inventaireBois = inventaireBois;
        }
    }

    public Integer getInventaireArgile() {
        return inventaireArgile;
    }

    public void setInventaireArgile(Integer inventaireArgile) {
        if (inventaireArgile < 0) {
            this.inventaireArgile = 0;
        }
        else {
            this.inventaireArgile = inventaireArgile;
        }
    }

    public Integer getInventaireLaine() {
        return inventaireLaine;
    }

    public void setInventaireLaine(Integer inventaireLaine) {
        if (inventaireLaine < 0) {
            this.inventaireLaine = 0;
        }
        else {
            this.inventaireLaine = inventaireLaine;
        }
    }

    public Integer getInventaireBle() {
        return inventaireBle;
    }

    public void setInventaireBle(Integer inventaireBle) {
        if (inventaireBle < 0) {
            this.inventaireBle = 0;
        }
        else {
            this.inventaireBle = inventaireBle;
        }
    }

    public Integer getInventaireMinerai() {
        return inventaireMinerai;
    }

    public void setInventaireMinerai(Integer inventaireMinerai) {
        if (inventaireMinerai < 0) {
            this.inventaireMinerai = 0;
        }
        else {
            this.inventaireMinerai = inventaireMinerai;
        }
    }

    public void changeInventaire(Integer quantite, Production ressource) {
        if (quantite == null || ressource == null) {
            throw new IllegalArgumentException("il faut une quantite et une ressource pour changer l'inventaire");
        }
        if (ressource == Production.ARGILE) {
            setInventaireArgile(getInventaireArgile() + quantite);
        }
        if (ressource == Production.BLE) {
            setInventaireBle(getInventaireBle() + quantite);
        }
        if (ressource == Production.BOIS) {
            setInventaireBois(getInventaireBois() + quantite);
        }
        if (ressource == Production.LAINE) {
            setInventaireLaine(getInventaireLaine() + quantite);
        }
        if (ressource == Production.MINERAI) {
            setInventaireMinerai(getInventaireMinerai() + quantite);
        }
    }

    public Boolean peutCommercer4Bois() {
        if (getInventaireBois() >= 4) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean peutCommercer4Argile() {
        if (getInventaireArgile() >= 4) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean peutCommercer4Laine() {
        if (getInventaireLaine() >= 4) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean peutCommercer4Ble() {
        if (getInventaireBle() >= 4) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean peutCommercer4Minerai() {
        if (getInventaireMinerai() >= 4) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean peutCommercer4() {
        if (peutCommercer4Bois() || peutCommercer4Argile() || peutCommercer4Laine() || peutCommercer4Ble() || peutCommercer4Minerai()) {
            return true;
        }
        return false;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public TypeJoueur getTypeJoueur() {
        return typeJoueur;
    }
    
    public boolean peutAcheterRoute() {
        if (getInventaireArgile() >= 1 && getInventaireBois() >= 1) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean acheteRoute(Plateau plateau, Segment segment) {
        if (peutAcheterRoute() == true && plateau.getProprietaireSegment(segment.getIdPointA(), segment.getIdPointB()) == null && plateau.isSegmentValide(segment.getIdPointA(), segment.getIdPointB())) {
            plateau.getSegments().add(0, segment);
            plateau.getSegments().get(0).setProprietaire(this);
            changeInventaire(-1, Production.ARGILE);
            changeInventaire(-1, Production.BOIS);
            return true;
        }
        return false;
    }

    public boolean peutAcheterColonie() {
        if (getInventaireArgile() >= 1 && getInventaireBois() >= 1 && getInventaireLaine() >= 1 && getInventaireMinerai() >= 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean acheteColonie(Plateau plateau, Point point) {
        if (peutAcheterColonie() == false) {
            console.println(Couleur.MAUVE.getMarqueur(), "Vous n'avez pas assez de ressources pour acheter une colonie");
            return false;
        }
        if (!(point.getProprietaire() == null)) {
            console.println(Couleur.MAUVE.getMarqueur(), "Cet emplacement est deja occupe");
            return false;
        }
        if (!(point.peutBatirPourUnJoueur(point, plateau, this))) {
            console.println(Couleur.MAUVE.getMarqueur(), "Cet emplacement n'est pas disponible");
            return false;
        }
        point.setProprietaire(this);
        point.setTypePoint(TypePoint.COLONIE);
        changeInventaire(-1, Production.ARGILE);
        changeInventaire(-1, Production.BOIS);
        changeInventaire(-1, Production.LAINE);
        changeInventaire(-1, Production.MINERAI);
        ajoutePoints(1);
        return true;
    }

    public boolean peutAcheterVille() {
        if (getInventaireBle() >= 2 && getInventaireMinerai() >= 3) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean acheteVille(Plateau plateau, Point point) {
        if (peutAcheterVille() == false) {
            console.println(Couleur.MAUVE.getMarqueur(), "Vous n'avez pas assez de ressources pour acheter une ville");
            dialogue.demandeUneTouche();
            return false;
        }
        if (point.getProprietaire() == null) {
            console.println(Couleur.MAUVE.getMarqueur(), "Vous ne possedez pas de colonie a cet emplacement");
            dialogue.demandeUneTouche();
            return false;
        }
        if (point.getProprietaire() != this) {
            console.println(Couleur.MAUVE.getMarqueur(), "Cet emplacement est deja occupe");
            dialogue.demandeUneTouche();
            return false;
        }
        if (!(point.peutBatirPourUnJoueur(point, plateau, this))) {
            console.println(Couleur.MAUVE.getMarqueur(), "Cet emplacement n'est pas disponible");
            dialogue.demandeUneTouche();
            return false;
        }
        if (point.getTypePoint() == TypePoint.VILLE) {
            console.println(Couleur.MAUVE.getMarqueur(), "Une ville vous appartenant existe deja a cet emplacement");
            dialogue.demandeUneTouche();
            return false;

        }
        point.setProprietaire(this);
        point.setTypePoint(TypePoint.VILLE);
        changeInventaire(-2, Production.BLE);
        changeInventaire(-3, Production.MINERAI);
        ajoutePoints(1);
        return true;
    }

    public String getNom() {
        return nom;
    }

    public void joue(Jeu jeu) {
        Boolean action;
        do {
            console.effaceTout();
            jeu.getPlateau().dessinePlateau();
            jeu.dessineInventaire();
            console.println(getCouleur().getStylo(), getNom() + " choisissez une action :");
            afficheActions(getListeIdActions());
            action = lanceAction(dialogue.demandeEntierPrecis(getCouleur().getStylo(), "Votre choix : ", getListeIdActions()), jeu);
        } while (action == false);
    }

    public List<Integer> rafraichitActions() {
        List<Integer> listeIdActions = new ArrayList<Integer>();
        listeIdActions.add(Action.PASSE.getIdAction()); // on peut toujours passer son tour
        if (peutAcheterRoute()) {
            listeIdActions.add(Action.ROUTE.getIdAction());
        }
        if (peutAcheterColonie()) {
            listeIdActions.add(Action.COLONIE.getIdAction());
        }
        if (peutAcheterVille()) {
            listeIdActions.add(Action.VILLE.getIdAction());
        }
        if (peutCommercer4()) {
            listeIdActions.add(Action.COMMERCE4.getIdAction());
        }
        return listeIdActions;
    }

    public void afficheActions(List<Integer> listeIdActions) {
        for (Integer i = 0; i < listeIdActions.size(); i++) {
            console.println(getCouleur().getStylo(), Action.getActionParId(listeIdActions.get(i)).getIdAction() + " " + Action.getActionParId(listeIdActions.get(i)).getLibelleAction());
        }
    }

    public Boolean lanceAction(Integer actionChoisie, Jeu jeu) {
        if (actionChoisie == Action.PASSE.getIdAction()) {
            return true; // on passe son tour donc on arrete le do/while de joue()
        }
        if (actionChoisie == Action.ROUTE.getIdAction()) {
            lanceAchatRoute(jeu);
        }
        if (actionChoisie == Action.COLONIE.getIdAction()) {
            lanceAchatColonie(jeu);
        }
        if (actionChoisie == Action.VILLE.getIdAction()) {
            lanceAchatVille(jeu);
        }
        if (actionChoisie == Action.COMMERCE4.getIdAction()) {
            lanceCommerce4(jeu);
        }
        return false; // a part si on a passe son tour (0) on peut choisir une nouvelle action
    }

    public void choisiSegmentDepart(Jeu jeu) {
        Integer idPointA, idPointB;
        do {
        console.println(getCouleur().getMarqueur(), getNom() + " choisissez une route gratuitement...");
        idPointA = dialogue.demandeEntier(getCouleur().getStylo(), "Point de depart : ");
        idPointB = dialogue.demandeEntier(getCouleur().getStylo(), "Point d'arrivee : ");
        } while (jeu.placeSegmentDepart(new Segment(idPointA, idPointB, null), this) == false);
    }

    public void choisiColonieDepart(Jeu jeu) {
        Integer idPoint;
        console.println(getCouleur().getMarqueur(), getNom() + " choisissez une colonie gratuitement...");
        idPoint = dialogue.demandeEntier(getCouleur().getStylo(), "Colonie : ");
        jeu.placePointDepart(jeu.getPlateau().getPoints().get(idPoint), this);
    }

    public void lanceAchatRoute(Jeu jeu) {
        Integer idPointA, idPointB, idPointPassage;
        console.println(getCouleur().getMarqueur(), "Achat d'une route");
        if (!peutAcheterRoute()) {
            console.println(Couleur.MAUVE.getMarqueur(), "Erreur, vous ne pouvez pas acheter de route");
            return;
        }

        idPointA = dialogue.demandeEntier(getCouleur().getStylo(), "Entrez le point de DEPART : ");
        idPointB = dialogue.demandeEntier(getCouleur().getStylo(), "Entrez le point d'ARRIVEE : ");
        if (idPointA > idPointB) {
            idPointPassage = idPointB;
            idPointB = idPointA;
            idPointA = idPointPassage;
        }
        if (!jeu.getPlateau().isSegmentValide(idPointA, idPointB)) {
            console.println(Couleur.MAUVE.getMarqueur(), "Erreur, cette route n'est pas valide");
            return;
        }

        if (jeu.getPlateau().getProprietaireSegment(idPointA, idPointB) == null) {
            acheteRoute(jeu.getPlateau(), new Segment(idPointA, idPointB, null));
            return;
        }
        else
        {
            console.println(Couleur.MAUVE.getMarqueur(), "Erreur, cette route est déjà occupée");
            return;
        }
    }

    public void lanceAchatColonie(Jeu jeu) {
        Integer idPoint;
        console.println(getCouleur().getMarqueur(), "Achat d'une colonie");
        if (!peutAcheterColonie()) {
            console.println(Couleur.MAUVE.getMarqueur(), "Erreur, vous ne pouvez pas acheter de colonie");
            return;
        }

        idPoint = dialogue.demandeEntier(getCouleur().getStylo(), "Entrez l'emplacement de la colonie : ");
        if (idPoint < 0 || idPoint >= jeu.getPlateau().getPoints().size()) {
            console.println(Couleur.MAUVE.getMarqueur(), "Erreur, ce croisement n'est pas valide");
            return;
        }

        if (jeu.getPlateau().getPoints().get(idPoint).getProprietaire() == null) {
            acheteColonie(jeu.getPlateau(), jeu.getPlateau().getPoints().get(idPoint));
            return;
        }
        else
        {
            console.println(Couleur.MAUVE.getMarqueur(), "Erreur, cette colonie est déjà occupée");
            return;
        }
    }

    public void lanceAchatVille(Jeu jeu) {
        console.println(getCouleur().getMarqueur(), "Achat d'une ville");
        Integer idPoint = dialogue.demandeEntier(getCouleur().getStylo(), "Entrez l'emplacement de la ville : ");
        acheteVille(jeu.getPlateau(), jeu.getPlateau().getPoints().get(idPoint));
    }

    public List<Integer> rafraichitProductionCommerce4() {
        List<Integer> liste = new ArrayList<Integer>();
        if (peutCommercer4Bois()) {
            liste.add(Production.BOIS.getIdProduction());
        }
        if (peutCommercer4Argile()) {
            liste.add(Production.ARGILE.getIdProduction());
        }
        if (peutCommercer4Laine()) {
            liste.add(Production.LAINE.getIdProduction());
        }
        if (peutCommercer4Ble()) {
            liste.add(Production.BLE.getIdProduction());
        }
        if (peutCommercer4Minerai()) {
            liste.add(Production.MINERAI.getIdProduction());
        }
        liste.add(Production.RIEN.getIdProduction()); // on peut toujours ne rien echanger :-)
        return liste;
    }

    public void afficheProduction(List<Integer> listeIdProductions) {
        for (Integer i = 0; i < listeIdProductions.size(); i++) {
            console.println(getCouleur().getStylo(), "  " + Production.getProductionParId(listeIdProductions.get(i)).getIdProduction() + " " + Production.getProductionParId(listeIdProductions.get(i)).getLibelleProduction());
        }
    }

    public void lanceCommerce4(Jeu jeu) {
        afficheProduction(getListeProductionCommerce4());
        Integer productionProposee = dialogue.demandeEntierPrecis(getCouleur().getStylo(), "Saisissez la ressource a echanger : ", getListeProductionCommerce4());

        List<Integer> listeIdEnumProduction = new ArrayList<>();
        listeIdEnumProduction.add(0);
        listeIdEnumProduction.add(1);
        listeIdEnumProduction.add(2);
        listeIdEnumProduction.add(3);
        listeIdEnumProduction.add(4);
        listeIdEnumProduction.add(99);
        afficheProduction(listeIdEnumProduction);
        Integer productionSouhaitee = dialogue.demandeEntierPrecis(getCouleur().getStylo(), "Saisissez la ressource souhaitee en echange : ", listeIdEnumProduction);

        if (productionProposee == productionSouhaitee || productionProposee == 99 || productionSouhaitee == 99) {
            console.println(Couleur.MAUVE.getMarqueur(), "Abandon de l'echange...");
            dialogue.demandeUneTouche();
            return;
        }
        else {
            changeInventaire(-4, Production.getProductionParId(productionProposee));
            changeInventaire(1, Production.getProductionParId(productionSouhaitee));
        }

    }

}
