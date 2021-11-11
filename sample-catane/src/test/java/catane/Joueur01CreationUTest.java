package catane;

import org.junit.jupiter.api.Test;

import enums.Couleur;
import enums.TypeJoueur;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class Joueur01CreationUTest {

    @Test
    public void creerJoueurSansRien() {
        assertThatThrownBy(() -> new Joueur(null, null, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerJoueurSansNom() {
        assertThatThrownBy(() -> new Joueur(null, Couleur.BLEU, TypeJoueur.IA)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerJoueurSansCouleur() {
        assertThatThrownBy(() -> new Joueur("Fabrice", null, TypeJoueur.HUMAIN)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerJoueurSansType() {
        assertThatThrownBy(() -> new Joueur("Fabrice", Couleur.BLEU, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerJoueur() {
        Joueur fabrice = new Joueur("fabrice", Couleur.BLEU, TypeJoueur.HUMAIN);
        assertThat(fabrice.nom).isEqualTo("fabrice");
        assertThat(fabrice.couleur).isEqualTo(Couleur.BLEU);
        assertThat(fabrice.typeJoueur).isEqualTo(TypeJoueur.HUMAIN);
    }


}
