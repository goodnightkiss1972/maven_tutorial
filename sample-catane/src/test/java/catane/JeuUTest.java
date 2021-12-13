package catane;

import org.junit.jupiter.api.Test;

import enums.Couleur;
import enums.TypeJoueur;
import utils.De6Faces;
import java.util.List;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JeuUTest {

    @Test
    public void creeJeuSansRien() {
        assertThatThrownBy(() -> new Jeu(null, null, null, 1, 1, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creeJeuAvecTropPeuDeJoueurs() {
        De6Faces d1 = new De6Faces();
        De6Faces d2 = new De6Faces();
        Joueur j1 = new Joueur("j1", Couleur.BLEU, TypeJoueur.HUMAIN);
        Joueur j2 = new Joueur("j2", Couleur.BLANC, TypeJoueur.HUMAIN);
        List<Joueur> joueurs = new ArrayList<Joueur>();
        joueurs.add(j1);
        joueurs.add(j2);
        assertThatThrownBy(() -> new Jeu(d1, d2, joueurs, 1, 1, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creeJeuAvecTropDeJoueurs() {
        De6Faces d1 = new De6Faces();
        De6Faces d2 = new De6Faces();
        Joueur j1 = new Joueur("j1", Couleur.BLEU, TypeJoueur.HUMAIN);
        Joueur j2 = new Joueur("j2", Couleur.BLANC, TypeJoueur.HUMAIN);
        Joueur j3 = new Joueur("j3", Couleur.BLANC, TypeJoueur.HUMAIN);
        Joueur j4 = new Joueur("j4", Couleur.BLANC, TypeJoueur.HUMAIN);
        Joueur j5 = new Joueur("j5", Couleur.BLANC, TypeJoueur.HUMAIN);
        List<Joueur> joueurs = new ArrayList<Joueur>();
        joueurs.add(j1);
        joueurs.add(j2);
        joueurs.add(j3);
        joueurs.add(j4);
        joueurs.add(j5);
        assertThatThrownBy(() -> new Jeu(d1, d2, joueurs, 1, 1, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void TestLance100FoisDeuxDes() {
        De6Faces d1 = new De6Faces();
        De6Faces d2 = new De6Faces();
        List<Joueur> joueurs = new ArrayList<Joueur>();
        Joueur j1 = new Joueur("fabien", Couleur.BLEU, TypeJoueur.HUMAIN);
        Joueur j2 = new Joueur("georges", Couleur.BLANC, TypeJoueur.HUMAIN);
        Joueur j3 = new Joueur("emile", Couleur.ROUGE, TypeJoueur.HUMAIN);
        joueurs.add(j1);
        joueurs.add(j2);
        joueurs.add(j3);
        Jeu jeu = new Jeu(d1, d2, joueurs, 5, 3, null);
        Integer i = 0;
        while (i < 100) {
            Integer tirage = jeu.getTirageDes();
            assertThat(tirage).isBetween(2, 12);
            i++;
        }
    }

    @Test
    public void jeuSimulation01() {
        De6Faces d1 = new De6Faces();
        De6Faces d2 = new De6Faces();
        List<Joueur> joueurs = new ArrayList<Joueur>();
        Joueur j1 = new Joueur("fabien", Couleur.BLEU, TypeJoueur.HUMAIN);
        Joueur j2 = new Joueur("georges", Couleur.BLANC, TypeJoueur.HUMAIN);
        Joueur j3 = new Joueur("emile", Couleur.ROUGE, TypeJoueur.HUMAIN);
        joueurs.add(j1);
        joueurs.add(j2);
        joueurs.add(j3);
        Jeu jeu = new Jeu(d1, d2, joueurs, 5, 3, null);
        j2.setPoints(10);
        assertThat(jeu.getGagnant()).isEqualTo(j2);
    }

}
