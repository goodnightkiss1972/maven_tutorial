package catane;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointUTest {

    @Test
    public void creerPointSansRien() {
        assertThatThrownBy(() -> new Point(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerPointSimple() {
        Point p1 = new Point(0);
        assertThat(p1.getTuilesVoisines().size()).isEqualTo(0);
        p1.addTuilesVoisines(0);
        p1.addTuilesVoisines(1);
        assertThat(p1.getTuilesVoisines().size()).isEqualTo(2);
    }
}
