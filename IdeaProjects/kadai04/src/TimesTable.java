/**
 * 可変長な九九表クラスの作成
 * */
public class TimesTable {
    //フィールド
    //width private int 九九表の幅(→方向の数)
    private int width;
    //height private int 九九表の高さ(↓方向の数)
    private  int height;
    //array private int[][] 九九表(コンストラクタにて配列の要素数及び内容を初期化します)
    private int[][] array;

    //コンストラクタ
    //なし　private このクラスは、初期化に高さデータと幅データが必要なため引数なしコンストラクタは外部から呼ばれないようにします
    private TimesTable() {}//外から呼ばれないからprivateで置いておく

    //int width, int height public 引数をそれぞれのフィールドに代入するとともに、フィールドarrayに値を設定します。値の設定内容については以下の解説を参考にしてください。
    public TimesTable(int width, int height){
        //引数をそれぞれのフィールドに代入する
        this.width = width;
        this.height = height;
        //フィールドarrayの初期化について
        //フィールドarrayは、int[height][width]で初期化します。この時、配列の要素数が負の値になる場合は例外が発生しますが、それをチェックする必要はありません。例外発生は例外としてプログラムを落としてください。
        this.array = new int[height][width];

        //生成した配列の値には、(heightのindex + 1) × (widthのindex + 1) を代入します。
        for (int h = 0; h < height; h++) {
            //一次元目のheightに関係
            for (int w = 0; w < width; w++) {
                //二次元目のwidthに関係
                this.array[h][w] = (h + 1) * (w + 1);//九九のデータの表
            }
        }
        //例えば、new TimesTable(4, 3)で初期化を行った場合、以下の配列リテラルで表される配列データが生成されます。
    }
    //メソット
    //getWidth	public	int	なし	フィールドwidthを返します
    public int getWidth() {
        return width;
    }
    //getHeight	public	int	なし	フィールドheightを返します
    public int getHeight() {
        return height;
    }
    //getArray	public	int[][]	なし	フィールドarrayを返します
    public int[][] getArray() {
        return array;
    }
    //print	public	なし	なし	フィールドarrayに生成されている九九表を、下記「結果の表示例」を参考に標準出力に画面表示します
    public void print() {
        // TODO: ここは各自で実装し
        //  てみよう！
        //for文を二重にしている箇所があるのでそれを参考にして、文字列の改行タイミングをよく考えよう
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.printf("|%d|", this.array[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
     TimesTable tt1 = new TimesTable(4, 3);
     System.out.println("4×3");
     tt1.print();
     TimesTable tt2 = new TimesTable(3, 4);
     System.out.println("3×4");
     tt2.print();
     TimesTable tt3 = new TimesTable(9, 9);
     System.out.println("9×9");
     tt3.print();
     TimesTable tt4 = new TimesTable(90, 90);
     System.out.println("90×90");
     tt4.print();
     }
}
