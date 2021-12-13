package catane;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Plateau03PointsEtTuilesVoisinesUTest {

    @Test
    public void creerPlateau5x3CorrectAvecTuilesVoisinesLigne0() {
        Plateau p1 = new Plateau(5, 3, null);
        assertThat(p1.getPoints().get(0).getIdTuilesVoisines()).contains(0);
        assertThat(p1.getPoints().get(1).getIdTuilesVoisines()).contains(0, 1);
        assertThat(p1.getPoints().get(2).getIdTuilesVoisines()).contains(1, 2);
        assertThat(p1.getPoints().get(3).getIdTuilesVoisines()).contains(2, 3);
        assertThat(p1.getPoints().get(4).getIdTuilesVoisines()).contains(3, 4);
        assertThat(p1.getPoints().get(5).getIdTuilesVoisines()).contains(4);
    }

    @Test
    public void creerPlateau5x3CorrectAvecTuilesVoisinesLigne1() {
        Plateau p1 = new Plateau(5, 3, null);
        assertThat(p1.getPoints().get(6).getIdTuilesVoisines()).contains(0, 5);
        assertThat(p1.getPoints().get(7).getIdTuilesVoisines()).contains(0, 1, 5, 6);
        assertThat(p1.getPoints().get(8).getIdTuilesVoisines()).contains(1, 2, 6, 7);
        assertThat(p1.getPoints().get(9).getIdTuilesVoisines()).contains(2, 3, 7, 8);
        assertThat(p1.getPoints().get(10).getIdTuilesVoisines()).contains(3, 4, 8, 9);
        assertThat(p1.getPoints().get(11).getIdTuilesVoisines()).contains(4, 9);
    }

    @Test
    public void creerPlateau5x3CorrectAvecTuilesVoisinesLigne2() {
        Plateau p1 = new Plateau(5, 3, null);
        assertThat(p1.getPoints().get(12).getIdTuilesVoisines()).contains(5, 10);
        assertThat(p1.getPoints().get(13).getIdTuilesVoisines()).contains(5, 6, 10, 11);
        assertThat(p1.getPoints().get(17).getIdTuilesVoisines()).contains(9, 14);
    }

    @Test
    public void creerPlateau5x3CorrectAvecTuilesVoisinesLigne3() {
        Plateau p1 = new Plateau(5, 3, null);
        assertThat(p1.getPoints().get(18).getIdTuilesVoisines()).contains(10);
        assertThat(p1.getPoints().get(20).getIdTuilesVoisines()).contains(11, 12);
        assertThat(p1.getPoints().get(23).getIdTuilesVoisines()).contains(14);
    }

    @Test
    public void creerPlateau5x3CorrectAvecPointsVoisins() {
        Plateau p2 = new Plateau(5, 3, null);
        assertThat(p2.getPoints().get(0).getIdPointsVoisins()).contains(1, 6);

        assertThat(p2.getPoints().get(1).getIdPointsVoisins()).contains(0, 2, 7);

        assertThat(p2.getPoints().get(5).getIdPointsVoisins()).contains(4, 11);

        assertThat(p2.getPoints().get(6).getIdPointsVoisins()).contains(0, 7, 12);

        assertThat(p2.getPoints().get(7).getIdPointsVoisins()).contains(1, 6, 8, 13);

        assertThat(p2.getPoints().get(11).getIdPointsVoisins()).contains(5, 10, 17);

        assertThat(p2.getPoints().get(12).getIdPointsVoisins()).contains(6, 13, 18);

        assertThat(p2.getPoints().get(20).getIdPointsVoisins()).contains(19, 14, 21);

        assertThat(p2.getPoints().get(23).getIdPointsVoisins()).contains(17, 22);

        p2.dessinePlateau();

    }

}
