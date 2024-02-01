import com.sun.source.tree.UsesTree;

/**
 * 配列をより便利に扱うためのカスタム配列クラス
 */

//プライベートのメソットはOK　パブリックはだめ　アクセス修飾子はだめ
public class IntCollector {
    //メソットの名前＝処理についての名前　　countOf＝カウントする

    //フィールド
    //array	private	int[]	内部でデータを保持する配列
    private int[] array;

    //コンストラクタ
    //なし	public	フィールドarrayを要素数0の整数型配列で初期化
    public  IntCollector() {
        this.array = new int[0];//intコレクタ
    }

    //int[] values	public	指定された引数の配列とarrayが同じ配列になるように要素数及び各要素をコピーします(同じ大きさの要素数で配列を初期化、値をすべてコピーする：この動作をしないと、値の中身が参照でしか渡せないため、配列の初期化から値自体を代入する作業が必要になります。)
    public IntCollector(int[] value){//value...初期化するための値
        this.setArray(value);//同じプロジェクト内でプログラムをコピーしたらその関数を呼び出すようにするといい
    }

    //メソット
    //getArray	public	int[]	なし	フィールドarrayを返します

    public int[] getArray() {
        return array;
    }

    //setArray	public	なし	int[] values	指定された引数の配列とarrayが同じ配列になるように要素数及び各要素をコピーします(同じ大きさの要素数で配列を初期化、値をすべてコピーする)
    public void setArray(int[] array) {
        //渡された引数の配列の要素数と同じ配列を作る 参照渡しにならないように
        this.array = new int[array.length];
        //作り直した配列に、引数の配列要素を1つづつコピーする
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];//ディープコピー intコレクタを持つarrayに影響はない
        }
    }

    //add	public	なし	int value	配列の要素数を1つ増やし、配列データの末尾に1件追加
    public void add(int value){
        //元々のarrayの要素数はどう変化しますか？
        //=>要素数は、+1される(配列の要素をどうやって増やすのか
        //=>そのまま this.array=new int[array.length+1]とするとどうなるか)
        //退避が必要
        int[] backup = this.array;
        //バックアップがあるので元のは消えてOk
        this.array = new int[this.array.length + 1];

        //元々あった配列の値は、新しい配列に追加する必要ができた
        for (int i = 0; i < backup.length; i++) {
            this.array[i] = backup[i];
        }

        //渡されたvalueは配列のどの位置に追加しますか？
        this.array[this.array.length - 1] = value;
    }

    //countOf	public	int	int value	指定された値で要素を検索し、その要素数を返す
    public int countOf(int value){
        //valueで渡された値が、arrayの中にいくつ存在しているかをカウントして渡す
        int count = 0;
        for (int a: this.array) {
            if (a == value){
                count += 1;
            }
        }
        return count;
    }
    //indexOf	public	int	int value	配列の要素を検索して、指定された要素と同じ値のインデックスを返す(もし、指定された要素がなければ、-1が返される)
    public int indexOf(int value){
        //for文でくるくる回して、valueと同じ値が見つかったらそのインデックスの値(i)をreturn;
        for (int i = 0; i < array.length; i++) {
            // TODO: 何か書け
            if(value == this.array[i]){
                return i;
            }
        }
        //for文が最後まで行っても見つからなかったら-1をreturn;
        return -1;
    }

    //remove	public	なし	int index	指定されたインデックスの要素を削除し、配列自体の要素も切り詰める（指定されたインデックスが配列のインデックス外だった場合はなにもしない。）
    public void remove(int index){
        //配列のインデックスと、引数のインデックスを比べて、範囲外だったらそこでreturn;
        if(this.array.length <= index || index < 0){
            return;
        }
        //元の配列をバックアップ
        int[] backup = this.array;
        //配列を要素数0で初期化
        this.array = new int[0];
        //新しいarrayに、指定されたインデックスのところだけを無視して要素を追加
        for (int i = 0; i < backup.length; i++) {
            if (index == i){
                continue;
            }
            this.add(backup[i]);
        }
    }
    //print	public	なし	なし	フィールドarrayに生成されている要素を、下記「結果の表示例」を参考に標準出力に画面表示します
    public void print() {
        System.out.print("[");
        for (int i = 0; i < this.array.length; i++) {
            System.out.print(array[i]);
            //末尾,がないようにif文で指定
            if (this.array.length - 1 == i){continue;}
            System.out.print(",");
        }
        System.out.println("]");
    }

    //動作確認コード
    /*public static void main(String[] args) {
        IntCollector a1 = new IntCollector();

        System.out.println("<getArray()の確認>");
        System.out.println(a1.getArray().length);
        a1.add(10);
        System.out.println(a1.getArray().length);
        a1.add(20);
        System.out.println(a1.getArray().length);
        a1.add(-1);
        System.out.println(a1.getArray().length);
        a1.add(30);
        System.out.println(a1.getArray().length);
        a1.add(40);
        System.out.println("<add()の確認>");
        //valueの中身　[10,20,30,40]
        for (int a: a1.getArray()) {
            System.out.print(a + ",");
        }
        System.out.println();
        System.out.println();

        int[] v2 = {10,20,30,40,50,50,50,40,30,20,10};

        System.out.printf("v2 = ");
        for (int a:v2) {
            System.out.print(a + ",");
        }
        System.out.println();

        IntCollector a2 = new IntCollector(v2);
        System.out.println("<countOf()の確認>");
        //配列の要素数
        System.out.println("a2 10の数はいくつ?: "+ a2.countOf(10));

        System.out.println("<indexOf()の確認>");
        System.out.println("a2 値が20のインデックスは?: "+ a2.indexOf(20));//左から見ていき、あったら返すので、後ろに同じ値があってもそれは返さなくていい
        System.out.println("a2 値がの3インデックスは?: "+ a2.indexOf(3));

        System.out.println("<remove()の確認>");
        a2.remove(5);
        System.out.print("v2 = ");
        for (int a: a2.getArray()) {
            System.out.print(a + ",");
        }
        System.out.println();

        System.out.println("<print()の確認>");
        a2.print();

        IntCollector a3 = new IntCollector();
        a3.print();
    }*/
}
