package catane;

import org.junit.jupiter.api.Test;

import enums.Couleur;
import enums.TypeJoueur;

import static org.assertj.core.api.Assertions.assertThat;

public class Joueur03GestionInventaire {

    Joueur joueur = new Joueur("Fabrice", Couleur.VERT, TypeJoueur.HUMAIN);

    @Test
    public void ajouteEtRetireBois() {
        joueur.setInventaireBois(4);
        joueur.setInventaireBois(joueur.getInventaireBois() - 2);
        assertThat(joueur.getInventaireBois()).isEqualTo(2);
        joueur.setInventaireBois(joueur.getInventaireBois() - 2);
        assertThat(joueur.getInventaireBois()).isEqualTo(0);
        joueur.setInventaireBois(joueur.getInventaireBois() - 2);
        assertThat(joueur.getInventaireBois()).isEqualTo(0);
    }

    @Test
    public void ajouteEtRetireArgile() {
        joueur.setInventaireArgile(0);
        joueur.setInventaireArgile(joueur.getInventaireArgile() - 2);
        assertThat(joueur.getInventaireArgile()).isEqualTo(0);
        joueur.setInventaireArgile(joueur.getInventaireArgile() + 3);
        assertThat(joueur.getInventaireArgile()).isEqualTo(3);
        joueur.setInventaireArgile(joueur.getInventaireArgile() + 4);
        assertThat(joueur.getInventaireArgile()).isEqualTo(7);
    }

    //joueur.setInventaire(0);
    //joueur.setInventaire(joueur.getInventaire() - 2);
    //assertThat(joueur.getInventaire()).isEqualTo(2);
    //joueur.setInventaire(joueur.getInventaire() - 2);
    //assertThat(joueur.getInventaire()).isEqualTo(0);
    //joueur.setInventaire(joueur.getInventaire() - 2);
    //assertThat(joueur.getInventaire()).isEqualTo(0);

}
