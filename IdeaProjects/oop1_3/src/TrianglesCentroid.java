public class TrianglesCentroid {
    Point point1 = new Point();
    Point point2 = new Point();
    Point point3 = new Point();
    Point calc() {
        Point ret = new Point();
        double dx = (this.point1.x + this.point2.x + this.point3.x) / 3.0;
        double dy = (this.point1.y + this.point2.y + this.point3.y) / 3.0;
        ret.x = dx;
        ret.y = dy;
        return ret;
    }
}
