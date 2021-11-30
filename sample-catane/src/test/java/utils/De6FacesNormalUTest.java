package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class De6FacesNormalUTest {

    @Test
    void LanceDe6Faces() {
        De6Faces de6 = new De6Faces(1);
        de6.setTirage();
        assertThat(de6.getTirage()).isEqualTo(5);
        de6.setTirage();
        assertThat(de6.getTirage()).isEqualTo(2);
        de6.setTirage();
        assertThat(de6.getTirage()).isEqualTo(4);
        de6.setTirage();
        assertThat(de6.getTirage()).isEqualTo(3);
        de6.setTirage();
        assertThat(de6.getTirage()).isEqualTo(5);
        de6.setTirage();
        assertThat(de6.getTirage()).isEqualTo(3);
    }

    @Test
    void LanceDe6Faces6000Fois() {
        De6Faces de6 = new De6Faces();
        Integer i = 0;
        while (i < 6000) {
            de6.setTirage();
            assertThat(de6.getTirage()).isBetween(1, 6);
            i++;
        }
    }

}
