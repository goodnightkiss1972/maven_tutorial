package catane;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Plateau02TuilesEtPointsVoisinsUTest {

    @Test
    public void creerPlateau5x3CorrectAvecPointsVoisinsLigne0() {
        Plateau p1 = new Plateau(5, 3, null);
        assertThat(p1.getTuiles().get(0).getPointsVoisins()).contains(0, 1, 6, 7);
        assertThat(p1.getTuiles().get(1).getPointsVoisins()).contains(1, 2, 7, 8);
        assertThat(p1.getTuiles().get(2).getPointsVoisins()).contains(2, 3, 8, 9);
        assertThat(p1.getTuiles().get(3).getPointsVoisins()).contains(3, 4, 9, 10);
        assertThat(p1.getTuiles().get(4).getPointsVoisins()).contains(4, 5, 10, 11);
    }

    @Test
    public void creerPlateau5x3CorrectAvecPointsVoisinsLigne1() {
        Plateau p1 = new Plateau(5, 3, null);
        assertThat(p1.getTuiles().get(6).getPointsVoisins()).contains(7, 8, 13, 14);
        assertThat(p1.getTuiles().get(9).getPointsVoisins()).contains(10, 11, 16, 17);
    }

    @Test
    public void creerPlateau5x3CorrectAvecPointsVoisinsLigne2() {
        Plateau p1 = new Plateau(5, 3, null);
        assertThat(p1.getTuiles().get(10).getPointsVoisins()).contains(12, 13, 18, 19);
        assertThat(p1.getTuiles().get(14).getPointsVoisins()).contains(16, 17, 22, 23);
    }

    @Test
    public void creerPlateau7x5CorrectAvecPoints() {
        Plateau p1 = new Plateau(7, 5, null);
        assertThat(p1.getPoints().size()).isEqualTo(8*6);
    }

    @Test
    public void creerPlateau7x5CorrectAvecPointsVoisinsLigne1() {
        Plateau p1 = new Plateau(7, 5, null);
        assertThat(p1.getTuiles().get(6).getPointsVoisins()).contains(6, 7, 14, 15);
        assertThat(p1.getTuiles().get(9).getPointsVoisins()).contains(10, 11, 18, 19);
        assertThat(p1.getTuiles().get(13).getPointsVoisins()).contains(14, 15, 22, 23);
    }

}
