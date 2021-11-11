package catane;

import org.junit.jupiter.api.Test;

import enums.Couleur;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class JoueurUTest {

    @Test
    public void creerJoueurSansRien() {
        assertThatThrownBy(() -> new Joueur(null, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerJoueurSansNom() {
        assertThatThrownBy(() -> new Joueur(null, Couleur.BLEU)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerJoueurSansCouleur() {
        assertThatThrownBy(() -> new Joueur("Fabrice", null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerJoueur() {
        Joueur fabrice = new Joueur("fabrice", Couleur.BLEU);
        assertThat(fabrice.nom).isEqualTo("fabrice");
        assertThat(fabrice.couleur).isEqualTo(Couleur.BLEU);
    }


}
