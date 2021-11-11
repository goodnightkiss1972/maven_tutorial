package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class De6FacesUTest {

    @Test
    void LanceDe6Faces6000Fois() {
        De6Faces de6F1 = new De6Faces();
        Integer i = 0;
        while (i < 6000) {
            de6F1.lance();
            assertThat(de6F1.getValeurTirage()).isBetween(1, 6);
            i++;
        }
    }



}
