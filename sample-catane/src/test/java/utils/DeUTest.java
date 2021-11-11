package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DeUTest {
       
    @Test
        void LanceDe6faces6000Fois() {
        De de1 = new De(6);
        Integer i = 0;
        while (i < 6000) {
            de1.lance();
            assertThat(de1.getValeurTirage()).isBetween(1, 6);
            i++;
        }
    }
}
