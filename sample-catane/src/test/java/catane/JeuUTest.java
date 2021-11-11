package catane;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class JeuUTest {

    @Test
    public void TestLance100FoisDeuxDes() {
        Jeu jeu = new Jeu();
        Integer i = 0;
        while (i < 100) {
            jeu.lanceLesDes();
            Integer tirage = jeu.getValeurDes();
            assertThat(tirage).isBetween(2, 12);
            i++;
        }
    }

}
