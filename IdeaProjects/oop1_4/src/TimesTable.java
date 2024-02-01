/**
 * 可変長な九九表を作表するクラス
 */
public class TimesTable {
    //フィールド
    //width	private	int	九九表の幅(→方向の数)
    private  int width;
    //height	private	int	九九表の高さ(↓方向の数)
    private  int height;
    //array	private	int[][]	九九表(コンストラクタにて配列の要素数及び内容を初期化します)
    private  int[][] array;

    //コンストラクタ
    //なし	private	このクラスは、初期化に高さデータと幅データが必要なため引数なしコンストラクタは外部から呼ばれないようにします
    private TimesTable() {}

    //int width, int height	public	引数をそれぞれのフィールドに代入するとともに、フィールドarrayに値を設定します。値の設定内容については以下の解説を参考にしてください。
    public TimesTable(int width, int height) {
        //引数をそれぞれのフィールドに代入する
        this.width = width;
        this.height = height;

        //フィールドarrayの初期化について
        //フィールドarrayは、int[height][width]で初期化します。この時、配列の要素数が負の値になる場合は例外が発生しますが、それをチェックする必要はありません。例外発生は例外としてプログラムを落としてください。
        this.array = new int[height][width];

        //生成した配列の値には、(heightのindex + 1) × (widthのindex + 1) を代入します。
        for (int h = 0; h < height; h++) {
            //１次元目のheightに関係
            for (int w= 0; w < width; w++) {
                //２次元目のwidthに関係
                this.array[h][w] = ( h + 1 ) * ( w + 1 );

            }
        }
    }

    //メソッド
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
    public void print () {
            //TODO：ここは各自
            for (int h = 0; h < height; h++) {
                //１次元目のheightに関係
                for (int w = 0; w < width; w++) {
                    //２次元目のwidthに関係
                    System.out.print("|" + this.array[h][w]);
                }
                System.out.println("|");
            }
            //for文を二重にしている箇所があるので参考
            //文字列の改行タイミングをよく考える
        }
        public static void main(String[] args) {
        TimesTable app = new TimesTable(4,3);
        TimesTable app2 = new TimesTable(3,4);
        TimesTable app3 = new TimesTable(0,0);
        TimesTable app4 = new TimesTable(1,1);
        TimesTable app5 = new TimesTable(9,9);
        System.out.println(4 + "×" + 3);
        app.print();
        System.out.println(3 + "×" + 4);
        app2.print();
        System.out.println(0 + "×" + 0);
        app3.print();
        System.out.println(1 + "×" + 1);
        app4.print();
        System.out.println(9 + "×" + 9);
        app5.print();
    }


}
