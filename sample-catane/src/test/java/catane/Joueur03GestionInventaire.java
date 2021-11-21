package catane;

import org.junit.jupiter.api.Test;

import enums.Couleur;
import enums.Production;
import enums.TypeJoueur;

import static org.assertj.core.api.Assertions.assertThat;

public class Joueur03GestionInventaire {

    Joueur joueur = new Joueur("Fabrice", Couleur.VERT, TypeJoueur.HUMAIN);
    Joueur j2 = new Joueur("Jeanne", Couleur.BLEU, TypeJoueur.HUMAIN);

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

    @Test
    public void manipuleInventaire() {
        j2.changeInventaire(2, Production.ARGILE);
        assertThat(j2.getInventaireArgile()).isEqualTo(2);
        j2.changeInventaire(-1, Production.ARGILE);
        assertThat(j2.getInventaireArgile()).isEqualTo(1);

        j2.changeInventaire(4, Production.BOIS);
        assertThat(j2.getInventaireBois()).isEqualTo(4);
        j2.changeInventaire(-3, Production.BOIS);
        assertThat(j2.getInventaireBois()).isEqualTo(1);

        j2.changeInventaire(-3, Production.BLE);
        assertThat(j2.getInventaireBle()).isEqualTo(0);
        j2.changeInventaire(2, Production.BLE);
        assertThat(j2.getInventaireBle()).isEqualTo(2);
    }
    //joueur.setInventaire(0);
    //joueur.setInventaire(joueur.getInventaire() - 2);
    //assertThat(joueur.getInventaire()).isEqualTo(2);
    //joueur.setInventaire(joueur.getInventaire() - 2);
    //assertThat(joueur.getInventaire()).isEqualTo(0);
    //joueur.setInventaire(joueur.getInventaire() - 2);
    //assertThat(joueur.getInventaire()).isEqualTo(0);

}
