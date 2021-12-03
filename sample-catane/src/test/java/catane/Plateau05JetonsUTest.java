package catane;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.OptionalLong;

public class Plateau05JetonsUTest {

    @Test
    public void creerPlateau5x3AvecGraine() {
        Plateau plateau = new Plateau(5, 3, OptionalLong.of(1234));
        plateau.dessinePlateau();
        assertThat(plateau.getTuiles().get(2).getJeton()).isEqualTo(8);
    }

}
