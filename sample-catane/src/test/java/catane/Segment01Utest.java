package catane;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Segment01Utest {

    @Test
    public void creerSegmentSansRien() {
        assertThatThrownBy(() -> new Segment(null, null)).isInstanceOf(IllegalArgumentException.class);
    }

}
