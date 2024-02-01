package jp.ac.ait.k21101;

public class Weapon extends Equipment {
    //フィールド（追加）
    //private int atk - 攻撃力加算値
    private int atk;

    //コンストラクタ
    //public Weapon(String name, int atk)
    public Weapon (String name, int atk) {
        //初期値セット
        //super(name)のあとにthis.atk = atk
        super(name);
        this.atk = atk;
    }
    //public Weapon()
    //名前を「武器」、攻撃力加算値「0」で初期化
    public Weapon() {
        this("武器", 0);
    }
    //メソッド（追加）
    //public int getAtk() - 攻撃力加算値を返す
    public int getAtk() {
        return atk;
    }
    //public void setAtk(int atk) - 攻撃力加算値を設定する
    public void setAtk(int atk) {
        this.atk = atk;
    }
}
