package catane;

import org.junit.jupiter.api.Test;

import enums.Couleur;
import enums.TypeJoueur;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class Joueur02GestionDesPoints {

    Joueur joueur = new Joueur("Fabrice", Couleur.BLANC, TypeJoueur.IA);

    @Test
    public void ajouteEtRetireDesPoints() {
        joueur.ajoutePoints(3);
        assertThat(joueur.getPoints()).isEqualTo(3);
        
        joueur.retirePoints(2);
        assertThat(joueur.getPoints()).isEqualTo(1);
        
        joueur.setPoints(0);
        assertThat(joueur.getPoints()).isEqualTo(0);

        // pas le droit de forcer un nombre de points negatifs
        assertThatThrownBy(() -> joueur.setPoints(-1)).isInstanceOf(IllegalArgumentException.class);

        // par contre on peut retirer plus de points que le joueur n'en a, pas grave on met zero
        assertThat(joueur.getPoints()).isEqualTo(0);
        joueur.retirePoints(1);
        assertThat(joueur.getPoints()).isEqualTo(0);

    }

}
