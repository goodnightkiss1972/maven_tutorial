package catane;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TuileCarreUTest {

    @Test
    public void creerTuileSansId() {
        assertThatThrownBy(() -> new TuileCarree(null, null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new TuileCarree(null, Terrain.DESERT)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerTuileMauvaisId() {
        assertThatThrownBy(() -> new TuileCarree(0, Terrain.FORET)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new TuileCarree(-10, Terrain.CHAMP)).isInstanceOf(IllegalArgumentException.class);
    }

}
