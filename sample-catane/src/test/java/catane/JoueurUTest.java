package catane;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

}
