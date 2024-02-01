/**
 * カスタム配列クラスを使ったフィボナッチ数列の算出
 */
public class Fibonacci {
    public IntCollector get(int n){
        //get	public	IntCollector	int n	戻り値であるIntCollectorには、以下の様にフィボナッチ数列が0, 1,と続く様に数値一つずつ格納してください。
        //例えば、10000という数値を渡した場合には、次の配列が得られます。
        // [0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765]

        IntCollector ret = new IntCollector();
        int a = 0;
        int b = 1;
        int next = a + b;

        ret.add(0);
        if(n > 0){
            ret.add(1);
        }

        while (next <= n){
            ret.add(next);
            a = b;
            b = next;
            next = a + b;
        }

        return ret;
    }

    /*public static void main(String[] args) {
        Fibonacci app = new Fibonacci();
        IntCollector ret = app.get(10000);
        ret.print();
        ret = app.get(0);
        ret.print();
        ret = app.get(1);
        ret.print();
        ret = app.get(-1);
        //app.arrayは呼び出せない
        ret.print();
    }*/
}
