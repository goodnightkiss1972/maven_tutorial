package catane;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Segment01Utest {

    @Test
    public void creerSegmentSansRien() {
        assertThatThrownBy(() -> new Segment(null, null, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerSegmentValide1() {
        Plateau plateau = new Plateau(5, 3, null);
        assertThat(plateau.isSegmentValide(0, 1)).isTrue();
    }

    @Test
    public void creerSegmentValideDansPlateau() {
        Plateau plateau = new Plateau(5, 3, null);
        assertThat(plateau.isSegmentValide(0, 1)).isTrue();
        assertThat(plateau.isSegmentValide(1, 2)).isTrue();
        assertThat(plateau.isSegmentValide(1, 7)).isTrue();
        assertThat(plateau.isSegmentValide(4, 5)).isTrue();
        assertThat(plateau.isSegmentValide(0, 6)).isTrue();
        assertThat(plateau.isSegmentValide(5, 11)).isTrue();
        assertThat(plateau.isSegmentValide(11, 17)).isTrue();
        assertThat(plateau.isSegmentValide(12, 18)).isTrue();
        assertThat(plateau.isSegmentValide(13, 14)).isTrue();
        assertThat(plateau.isSegmentValide(16, 22)).isTrue();
        assertThat(plateau.isSegmentValide(22, 23)).isTrue();
    }

    @Test
    public void creerSegmentInvalideDansPlateau() {
        Plateau plateau = new Plateau(5, 3, null);
        assertThat(plateau.isSegmentValide(0, -1)).isFalse();
        assertThat(plateau.isSegmentValide(0, -6)).isFalse();
        assertThat(plateau.isSegmentValide(1, 5)).isFalse();
        assertThat(plateau.isSegmentValide(3, -6)).isFalse();
        assertThat(plateau.isSegmentValide(0, 2)).isFalse();
        assertThat(plateau.isSegmentValide(0, 23)).isFalse();
        assertThat(plateau.isSegmentValide(5, 6)).isFalse();
        assertThat(plateau.isSegmentValide(17, 18)).isFalse();
        assertThat(plateau.isSegmentValide(16, 23)).isFalse();
        assertThat(plateau.isSegmentValide(23, 24)).isFalse();
    }

}
