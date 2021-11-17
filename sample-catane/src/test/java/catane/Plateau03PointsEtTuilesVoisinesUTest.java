package catane;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Plateau03PointsEtTuilesVoisinesUTest {

    @Test
    public void creerPlateau5x3CorrectAvecTuilesVoisinesLigne0() {
        Plateau p1 = new Plateau(5, 3);
        assertThat(p1.getPoints().get(0).getTuilesVoisines()).contains(0);
        assertThat(p1.getPoints().get(1).getTuilesVoisines()).contains(0, 1);
        assertThat(p1.getPoints().get(2).getTuilesVoisines()).contains(1, 2);
        assertThat(p1.getPoints().get(3).getTuilesVoisines()).contains(2, 3);
        assertThat(p1.getPoints().get(4).getTuilesVoisines()).contains(3, 4);
        assertThat(p1.getPoints().get(5).getTuilesVoisines()).contains(4);
    }

    @Test
    public void creerPlateau5x3CorrectAvecTuilesVoisinesLigne1() {
        Plateau p1 = new Plateau(5, 3);
        assertThat(p1.getPoints().get(6).getTuilesVoisines()).contains(0, 5);
        assertThat(p1.getPoints().get(7).getTuilesVoisines()).contains(0, 1, 5, 6);
        assertThat(p1.getPoints().get(8).getTuilesVoisines()).contains(1, 2, 6, 7);
        assertThat(p1.getPoints().get(9).getTuilesVoisines()).contains(2, 3, 7, 8);
        assertThat(p1.getPoints().get(10).getTuilesVoisines()).contains(3, 4, 8, 9);
        assertThat(p1.getPoints().get(11).getTuilesVoisines()).contains(4, 9);
    }

    @Test
    public void creerPlateau5x3CorrectAvecTuilesVoisinesLigne2() {
        Plateau p1 = new Plateau(5, 3);
        assertThat(p1.getPoints().get(12).getTuilesVoisines()).contains(5, 10);
        assertThat(p1.getPoints().get(13).getTuilesVoisines()).contains(5, 6, 10, 11);
        assertThat(p1.getPoints().get(17).getTuilesVoisines()).contains(9, 14);
    }

    @Test
    public void creerPlateau5x3CorrectAvecTuilesVoisinesLigne3() {
        Plateau p1 = new Plateau(5, 3);
        assertThat(p1.getPoints().get(18).getTuilesVoisines()).contains(10);
        assertThat(p1.getPoints().get(20).getTuilesVoisines()).contains(11, 12);
        assertThat(p1.getPoints().get(23).getTuilesVoisines()).contains(14);
    }

}
