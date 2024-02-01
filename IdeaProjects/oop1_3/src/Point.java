public class Point {
    double x = 0.0;
    double y = 0.0;
    //x,yの座標を文字列”(x,y)"の形式にフォーマットします
    String getPrintString() {
        return String.format("(%.2f,%.2f)", this.x, this.y);
    }

}
