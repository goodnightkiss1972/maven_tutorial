package catane;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.OptionalLong;

public class Plateau05JetonsUTest {

    @Test
    public void creerPlateau5x5AvecGraine() {
        Plateau plateau = new Plateau(5, 5, OptionalLong.of(123456));
        plateau.dessinePlateau();
        assertThat(plateau.getTuiles().get(2).getJeton()).isEqualTo(5);
    }
}
