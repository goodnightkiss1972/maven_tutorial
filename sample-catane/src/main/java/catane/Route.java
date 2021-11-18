package catane;

import java.util.List;

public class Route {
    
    private Integer idRoute;
    private List<Point> points;

    public Route(Integer idRoute, List<Point> points) {
        if (idRoute == null || points == null) {
            throw new IllegalArgumentException("La route doit avoir un identifiant et deux points !!");
        }
        this.idRoute = idRoute;
        this.points = points;
    }

    public Integer getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Integer idRoute) {
        this.idRoute = idRoute;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

}
