package catane;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.LinkedList;

public class RouteUTest {
   
    @Test
    public void creerRouteSansRien() {
        assertThatThrownBy(() -> new Route(null, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerRouteSansId() {
        Point p1 = new Point(0);
        Point p2 = new Point(1);
        List<Point> points = new LinkedList<Point>();
        points.add(p1);
        points.add(p2);
        assertThatThrownBy(() -> new Route(null, points)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerRouteSansPoint() {
        assertThatThrownBy(() -> new Route(0, null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void creerRouteCorrecte() {
        Point p1 = new Point(5);
        Point p2 = new Point(1);
        List<Point> points = new LinkedList<Point>();
        points.add(p1);
        points.add(p2);
        Route r1 = new Route(0, points);
        assertThat(r1.getPoints().get(0).getIdPoint()).isEqualTo(5);
    }

}
