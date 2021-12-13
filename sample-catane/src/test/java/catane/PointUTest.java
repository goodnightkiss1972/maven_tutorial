package catane;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import enums.Couleur;
import enums.TypeJoueur;
import enums.TypePoint;

public class PointUTest {

    @Test
    public void creerPointSansRien() {
        assertThatThrownBy(() -> new Point(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerPointSimple() {
        Point p1 = new Point(0);
        assertThat(p1.getIdTuilesVoisines().size()).isEqualTo(0);
        p1.addIdTuilesVoisines(0);
        p1.addIdTuilesVoisines(1);
        assertThat(p1.getIdTuilesVoisines().size()).isEqualTo(2);
    }

    @Test
    public void creerPointAvecProprietaireNul() {
        Point p2 = new Point(5);
        assertThatThrownBy(() -> p2.setProprietaire(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerPointAvecProprietaireEtType() {
        Point p2 = new Point(5);
        Joueur j2 = new Joueur("fabien", Couleur.BLANC, TypeJoueur.HUMAIN);
        p2.setProprietaire(j2);
        p2.setTypePoint(TypePoint.COLONIE);
        assertThat(p2.getProprietaire().getTypeJoueur()).isEqualTo(TypeJoueur.HUMAIN);
        assertThat(p2.getTypePoint()).isEqualTo(TypePoint.COLONIE);
    }

    @Test
    public void couleurDePoint() {
        Joueur j1 = new Joueur("fabien", Couleur.BLANC, TypeJoueur.HUMAIN);
        Plateau p = new Plateau(5, 3, null);
        p.getPoints().get(1).setProprietaire(j1);
        p.getPoints().get(1).setTypePoint(TypePoint.COLONIE);
        assertThat(p.getPoints().get(1).getStyle()).isEqualTo(j1.getCouleur().getStylo());
        p.getPoints().get(1).setTypePoint(TypePoint.VILLE);
        assertThat(p.getPoints().get(1).getStyle()).isEqualTo(j1.getCouleur().getMarqueur());
    }
}
