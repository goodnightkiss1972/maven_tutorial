package catane;

import org.junit.jupiter.api.Test;

import enums.Terrain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Plateau01TailleUTest {

    @Test
    public void creerPlateauSansRien() {
        assertThatThrownBy(() -> new Plateau(null, null, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerPlateauSansVerticale() {
        assertThatThrownBy(() -> new Plateau(3, null, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerPlateauSansHorizontale() {
        assertThatThrownBy(() -> new Plateau(null, 3, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerPlateauPairParHorizontale() {
        assertThatThrownBy(() -> new Plateau(2, 5, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerPlateauPairParVerticale() {
        assertThatThrownBy(() -> new Plateau(5, 2, null)).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    public void creerPlateau5x3Correct() {
        Plateau p1 = new Plateau(5, 3, null);
        assertThat(p1.getTuiles().size()).isEqualTo(5*3);
        assertThat(p1.getTuiles().get(7).getTerrain()).isEqualTo(Terrain.DESERT);
    }

    @Test
    public void creerPlateau5x3CorrectAvecPoints() {
        Plateau p1 = new Plateau(5, 3, null);
        assertThat(p1.getPoints().size()).isEqualTo(6*4);
    }

}
