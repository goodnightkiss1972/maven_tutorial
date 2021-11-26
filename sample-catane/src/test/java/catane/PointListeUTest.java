package catane;

import org.junit.jupiter.api.Test;

import enums.Couleur;
import enums.TypeJoueur;

import static org.assertj.core.api.Assertions.assertThat;

public class PointListeUTest {

    @Test
    public void manipulerPointListe() {
        PointListe points = new PointListe();
        Integer i;
        for (i = 0; i < 10; i++) {
            points.add(new Point(i));
        }
        assertThat(points.size()).isEqualTo(10);
        assertThat(points.get(5).getIdPoint()).isEqualTo(5);
    }

    @Test
    public void listePointsPourUnJoueur() {
        PointListe points = new PointListe();
        Integer i;
        for (i = 0; i < 10; i++) {
            points.add(new Point(i));
        }
        Joueur j1 = new Joueur("paul", Couleur.BLANC, TypeJoueur.HUMAIN);
        Joueur j2 = new Joueur("fred", Couleur.BLEU, TypeJoueur.HUMAIN);
        assertThat(points.getListeUnJoueur(j1).size()).isEqualTo(0);
        points.get(2).setProprietaire(j1);
        assertThat(points.getListeUnJoueur(j1).size()).isEqualTo(1);
        assertThat(points.getListeUnJoueur(j1).get(0).getIdPoint()).isEqualTo(2);
        points.get(1).setProprietaire(j1);
        assertThat(points.getListeUnJoueur(j1).size()).isEqualTo(2);
        assertThat(points.getListeUnJoueur(j1).get(0).getIdPoint()).isEqualTo(1);
        assertThat(points.getListeUnJoueur(j1).get(1).getIdPoint()).isEqualTo(2);
        points.get(1).setProprietaire(j2);
        assertThat(points.getListeUnJoueur(j1).size()).isEqualTo(1);
        assertThat(points.getListeUnJoueur(j2).size()).isEqualTo(1);
        assertThat(points.getListeUnJoueur(j1).get(0).getIdPoint()).isEqualTo(2);
        assertThat(points.getListeUnJoueur(j2).get(0).getIdPoint()).isEqualTo(1);
    }

}
