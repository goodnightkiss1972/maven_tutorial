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
    public void scenarioJeu01PlacementCorrect() {
        assertThat(jeu.placeSegmentDepart(new Segment(7, 8, null), joueurs.get(0))).isTrue();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(8), joueurs.get(0))).isTrue();
        assertThat(jeu.placeSegmentDepart(new Segment(9, 10, null), joueurs.get(1))).isTrue();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(10), joueurs.get(1))).isTrue();
        assertThat(jeu.placeSegmentDepart(new Segment(8, 14, null), joueurs.get(2))).isTrue();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(14), joueurs.get(2))).isTrue();

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

        jeu.getPlateau().dessinePlateau();
        jeu.dessineInventaire();
    }

    @Test
    public void scenarioJeu01PlacementIncorrect() {

        // on essaie de placer un point avant meme une route aux 4 coins du plateau
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(0), joueurs.get(0))).isFalse();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(5), joueurs.get(0))).isFalse();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(18), joueurs.get(0))).isFalse();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(23), joueurs.get(0))).isFalse();

        // on place le segment de depart 
        assertThat(jeu.placeSegmentDepart(new Segment(7, 8, null), joueurs.get(0))).isTrue();

        // on essaie de se rapprocher mais pas assez pres
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(1), joueurs.get(0))).isFalse();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(2), joueurs.get(0))).isFalse();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(6), joueurs.get(0))).isFalse();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(9), joueurs.get(0))).isFalse();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(13), joueurs.get(0))).isFalse();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(14), joueurs.get(0))).isFalse();

        // on place la colonie correctement
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(7), joueurs.get(0))).isTrue();

        // on place un deuxieme segment de depart 
        assertThat(jeu.placeSegmentDepart(new Segment(7, 13, null), joueurs.get(0))).isTrue();
        // impossible car construction trop proche
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(13), joueurs.get(0))).isFalse();

        // on place un troisieme segment de depart 
        assertThat(jeu.placeSegmentDepart(new Segment(6, 7, null), joueurs.get(0))).isTrue();
        // impossible car construction trop proche
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(6), joueurs.get(0))).isFalse();


        jeu.getPlateau().dessinePlateau();
    }

    @Test
    public void scenarioJeu02PlacementCorrect() {
        assertThat(jeu.placeSegmentDepart(new Segment(7, 8, null), joueurs.get(0))).isTrue();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(7), joueurs.get(0))).isTrue();
        assertThat(jeu.placeSegmentDepart(new Segment(9, 10, null), joueurs.get(1))).isTrue();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(9), joueurs.get(1))).isTrue();
        assertThat(jeu.placeSegmentDepart(new Segment(8, 14, null), joueurs.get(2))).isTrue();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(14), joueurs.get(2))).isTrue();

        assertThat(jeu.placeSegmentDepart(new Segment(19, 20, null), joueurs.get(2))).isTrue();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(19), joueurs.get(2))).isTrue();
        assertThat(jeu.placeSegmentDepart(new Segment(22, 28, null), joueurs.get(1))).isTrue();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(28), joueurs.get(1))).isTrue();
        assertThat(jeu.placeSegmentDepart(new Segment(19, 25, null), joueurs.get(0))).isTrue();
        assertThat(jeu.placePointDepart(jeu.getPlateau().getPoints().get(25), joueurs.get(0))).isTrue();

        jeu.getPlateau().production(3);
        jeu.getPlateau().production(5);
        jeu.getPlateau().production(7);

        assertThat(joueurs.get(0).getListeIdActions()).containsOnly(Action.PASSE.getIdAction(), Action.COMMERCE4.getIdAction());

        assertThat(joueurs.get(1).getListeIdActions()).containsOnly(Action.PASSE.getIdAction(), Action.ROUTE.getIdAction(), Action.COLONIE.getIdAction(), Action.COMMERCE4.getIdAction());

        assertThat(joueurs.get(1).acheteRoute(jeu.getPlateau(), new Segment(27, 28, null))).isTrue();
        assertThat(joueurs.get(1).getListeIdActions()).containsOnly(Action.PASSE.getIdAction(), Action.ROUTE.getIdAction(), Action.COLONIE.getIdAction(), Action.COMMERCE4.getIdAction());

        assertThat(joueurs.get(1).acheteRoute(jeu.getPlateau(), new Segment(26, 27, null))).isTrue();
        assertThat(joueurs.get(1).getListeIdActions()).containsOnly(Action.PASSE.getIdAction(), Action.ROUTE.getIdAction(), Action.COLONIE.getIdAction(), Action.COMMERCE4.getIdAction());

        assertThat(joueurs.get(1).acheteColonie(jeu.getPlateau(), jeu.getPlateau().getPoints().get(26))).isTrue();
        assertThat(joueurs.get(1).getListeIdActions()).containsOnly(Action.PASSE.getIdAction());

        jeu.getPlateau().production(3);
        jeu.getPlateau().production(5);
        jeu.getPlateau().production(7);

        assertThat(joueurs.get(1).acheteVille(jeu.getPlateau(), jeu.getPlateau().getPoints().get(26))).isTrue();
        assertThat(joueurs.get(1).getListeIdActions()).containsOnly(Action.PASSE.getIdAction(), Action.ROUTE.getIdAction(), Action.COLONIE.getIdAction(), Action.COMMERCE4.getIdAction());


        jeu.getPlateau().dessinePlateau();
        jeu.dessineInventaire();
    }
}
