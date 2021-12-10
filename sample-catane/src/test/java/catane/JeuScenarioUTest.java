package catane;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import utils.*;
import java.util.List;
import java.util.ArrayList;
import java.util.OptionalLong;

import enums.*;

public class JeuScenarioUTest {
    
    Jeu jeu;
    List<Joueur> joueurs;

    @BeforeEach
    public void declarations() {
        De6Faces d1 = new De6Faces();
        De6Faces d2 = new De6Faces();
        joueurs = new ArrayList<Joueur>();
        Joueur j0 = new Joueur("fabien", Couleur.BLEU, TypeJoueur.HUMAIN);
        Joueur j1 = new Joueur("georges", Couleur.BLANC, TypeJoueur.HUMAIN);
        Joueur j2 = new Joueur("emile", Couleur.ROUGE, TypeJoueur.HUMAIN);
        joueurs.add(j0);
        joueurs.add(j1);
        joueurs.add(j2);
        jeu = new Jeu(d1, d2, joueurs, 5, 5, OptionalLong.of(123456));
    }

    @Test
    public void scenarioJeu01() {
        assertThat(jeu.placeSegmentDepart(new Segment(7, 8, null), joueurs.get(0))).isTrue();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(8), joueurs.get(0))).isTrue();
        assertThat(jeu.placeSegmentDepart(new Segment(9, 10, null), joueurs.get(1))).isTrue();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(10), joueurs.get(1))).isTrue();
        assertThat(jeu.placeSegmentDepart(new Segment(8, 14, null), joueurs.get(2))).isTrue();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(14), joueurs.get(2))).isTrue();
        jeu.getPlateau().dessinePlateau();

        jeu.getPlateau().production(3);
        assertThat(joueurs.get(0).getInventaireBois()).isEqualTo(0);
        assertThat(joueurs.get(0).getInventaireArgile()).isEqualTo(1);
        assertThat(joueurs.get(0).getInventaireLaine()).isEqualTo(3);
        assertThat(joueurs.get(0).getInventaireBle()).isEqualTo(0);
        assertThat(joueurs.get(0).getInventaireMinerai()).isEqualTo(0);

        assertThat(joueurs.get(1).getInventaireBois()).isEqualTo(2);
        assertThat(joueurs.get(1).getInventaireArgile()).isEqualTo(0);
        assertThat(joueurs.get(1).getInventaireLaine()).isEqualTo(2);
        assertThat(joueurs.get(1).getInventaireBle()).isEqualTo(2);
        assertThat(joueurs.get(1).getInventaireMinerai()).isEqualTo(2);

        assertThat(joueurs.get(2).getInventaireBois()).isEqualTo(0);
        assertThat(joueurs.get(2).getInventaireArgile()).isEqualTo(1);
        assertThat(joueurs.get(2).getInventaireLaine()).isEqualTo(2);
        assertThat(joueurs.get(2).getInventaireBle()).isEqualTo(0);
        assertThat(joueurs.get(2).getInventaireMinerai()).isEqualTo(0);

    }

}
