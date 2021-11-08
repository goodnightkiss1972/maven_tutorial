package catane;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TuileUTest {

    @Test
    public void creerTuileSansRien() {
        assertThatThrownBy(() -> new Tuile(null, null))
        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerTuileMauvaisId() {
        assertThatThrownBy(() -> new Tuile(0, Terrain.FORET))
        .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Tuile(-10, Terrain.CHAMP))
        .isInstanceOf(IllegalArgumentException.class);
    }

}
