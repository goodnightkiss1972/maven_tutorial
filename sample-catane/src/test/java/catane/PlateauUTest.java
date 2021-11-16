package catane;

import org.junit.jupiter.api.Test;

import enums.Terrain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlateauUTest {

    @Test
    public void creerPlateauSansRien() {
        assertThatThrownBy(() -> new Plateau(null, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerPlateauSansVerticale() {
        assertThatThrownBy(() -> new Plateau(3, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerPlateauSansHorizontale() {
        assertThatThrownBy(() -> new Plateau(null, 3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerPlateauPairParHorizontale() {
        assertThatThrownBy(() -> new Plateau(2, 5)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerPlateauPairParVerticale() {
        assertThatThrownBy(() -> new Plateau(5, 2)).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    public void creerPlateauCorrect() {
        Plateau p1 = new Plateau(5, 3);
        assertThat(p1.getTuiles().size()).isEqualTo(5*3);
        assertThat(p1.getTuiles().get(7).getTerrain()).isEqualTo(Terrain.DESERT);
    }
}
