public class Calculator {
    public static void main(String[] args){
        //メインメソッドでは
        // 任意の3点の座標(Point)を作成し
        Point p1 = new Point();
        p1.x = 1.0; p1.y = 1.0;
        Point p2 = new Point();
        p2.x = 2.0; p2.y = 2.0;
        Point p3 = new Point();
        p3.x = -2.0; p3.y = -2.0;

        // TrianglesCentroidクラスのインスタンスへ
        TrianglesCentroid tc = new TrianglesCentroid();
        // データを渡し、
        tc.point1 = p1;
        tc.point2= p2;
        tc.point3 = p3;
        // 計算した結果を取得
        Point ans = tc.calc();
        // 、画面にその座標を表示する処理
        System.out.println(ans.getPrintString());

    }
}
