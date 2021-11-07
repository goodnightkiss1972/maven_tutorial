package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DeUTests {
       
    @Test
        void LanceDe6faces6000Fois() {
        De de1 = new De(6);
        Integer i = 0;
        while (i < 6000) {
            de1.lanceDe();
            assertThat(de1.getValeurDe()).isBetween(1, 6);
            i++;
        }
    }
}
