package catane;

import org.junit.jupiter.api.Test;

import enums.Couleur;
import enums.TypeJoueur;
import utils.De6Faces;
import java.util.List;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class JeuUTest {

    @Test
    public void TestLance100FoisDeuxDes() {
        De6Faces d1 = new De6Faces();
        De6Faces d2 = new De6Faces();
        List<Joueur> joueurs = new ArrayList<Joueur>();
        Joueur j1 = new Joueur("fabien", Couleur.BLEU, TypeJoueur.HUMAIN);
        joueurs.add(j1);
        Jeu jeu = new Jeu(d1, d2, joueurs, 5, 3, null);
        Integer i = 0;
        while (i < 100) {
            Integer tirage = jeu.getTirageDes();
            assertThat(tirage).isBetween(2, 12);
            i++;
        }
    }

}
