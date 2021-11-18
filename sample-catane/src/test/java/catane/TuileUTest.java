package catane;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TuileUTest {

    @Test
    void creerTuileSansId() {
        assertThatThrownBy(() -> new Tuile(null, null, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void creerTuileDeBase() {
        Tuile t1 = new Tuile(1, null, null);
        assertThat(t1.getIdTuile()).isEqualTo(1);
    }

}
