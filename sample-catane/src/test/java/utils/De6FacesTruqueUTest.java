package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class De6FacesTruqueUTest {

    @Test
    void LanceDe6Faces() {
        De6Faces de6 = mock(De6Faces.class);
        when(de6.getTirage()).thenReturn(3);
        assertThat(de6.getTirage()).isEqualTo(3);
        when(de6.getTirage()).thenReturn(5);
        assertThat(de6.getTirage()).isEqualTo(5);
    }

}