package jp.ac.ait.k21101;

/**
 * 武器クラス
 */
public class Weapon extends Equipment {
    /**
     * 攻撃力加算値
     */
    private int atk;

    /**
     * 名前と攻撃力加算値を指定して初期化
     * @param name 名前(Equipmentから継承)
     * @param atk 攻撃力加算値
     */
    public Weapon(String name, int atk) {
        super(name);
        // ↑名前を指定して親クラスのコンストラクタを呼び出し、
        // 親クラス側にしかないnameフィールドの初期化を行う
        this.atk = atk;
    }

    /**
     * 引数未指定の場合は、「武器」,攻撃力加算0で初期化
     */
    public Weapon() {
        this("武器", 0);
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }
}

