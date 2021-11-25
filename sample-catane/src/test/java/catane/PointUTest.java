package catane;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import enums.Couleur;
import enums.TypeJoueur;

public class PointUTest {

    @Test
    public void creerPointSansRien() {
        assertThatThrownBy(() -> new Point(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerPointSimple() {
        Point p1 = new Point(0);
        assertThat(p1.getTuilesVoisines().size()).isEqualTo(0);
        p1.addTuilesVoisines(0);
        p1.addTuilesVoisines(1);
        assertThat(p1.getTuilesVoisines().size()).isEqualTo(2);
    }

    @Test
    public void creerPointAvecProprietaireNul() {
        Point p2 = new Point(5);
        assertThatThrownBy(() -> p2.setProprietaire(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerPointAvecProprietaire() {
        Point p2 = new Point(5);
        Joueur j2 = new Joueur("fabien", Couleur.BLANC, TypeJoueur.HUMAIN);
        p2.setProprietaire(j2);
        assertThat(p2.getProprietaire().getTypeJoueur()).isEqualTo(TypeJoueur.HUMAIN);
    }

    @Test
    public void couleurDePoint() {
        Joueur j1 = new Joueur("fabien", Couleur.BLANC, TypeJoueur.HUMAIN);
        Plateau p = new Plateau(5, 3);
        p.getPoints().get(1).setProprietaire(j1);
        assertThat(p.getPoints().get(1).getCouleur()).isEqualTo(j1.getCouleur());
    }
}
