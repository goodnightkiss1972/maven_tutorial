package utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

public class DeUTests {
       
    @Test
    @DisplayName("6000 jets d'un de a 6 faces")
        void LanceDe6faces() {
        De de1 = new De(6);
        Integer i = 0;
        while (i < 6000) {
            de1.lanceDe();
            assertThat(de1.getValeurDe()).isBetween(1, 6);
        }
    }
}
