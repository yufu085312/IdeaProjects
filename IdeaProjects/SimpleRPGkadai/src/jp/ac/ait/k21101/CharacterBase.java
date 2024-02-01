package jp.ac.ait.k21101;

/**
 * Hero, Enemyの親となるRPGキャラクター基底クラス
 */
public abstract class CharacterBase {
    private String name;
    private int hp;
    private int atk;
    private int def;
    private int agi;

    public CharacterBase(String name, int hp, int atk, int def, int agi) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.agi = agi;
    }

    /**
     * 名前を返す
     * @return 名前
     */
    public String getName() {
        return name;
    }

    /**
     * HP
     * @return HP
     */
    public int getHp() {
        return hp;
    }

    /**
     * ATK
     * @return ATK
     */
    public int getAtk() {
        return atk;
    }

    /**
     * DEF
     * @return DEF
     */
    public int getDef() {
        return def;
    }

    /**
     * AGI
     * @return AGI
     */
    public int getAgi() {
        return agi;
    }

    /**
     * ダメージを受ける
     * @param damage 受けるダメージ
     * @return ダメージを受けた結果、戦闘続行不可能の場合trueを返します。
     */
    public boolean receiveDamage(int damage) {

        // 引数にて指定されたダメージ量をHPから減算する
        this.hp -= damage;

        // 戦闘終了判定を行う
        if (this.hp <= 0) {
            this.hp = 0; // HPが0以下にならないように0リセット
            return true; // 戦闘続行不可能
        }
        return false;
    }

    /**
     * 攻撃を行う
     * @param target 攻撃対象
     * @return 攻撃結果
     */
    public abstract AttackResult attack(CharacterBase target);

    /**
     * java.lang.Objectのメンバであるインスタンスの文字列化処理を上書き
     * @return インスタンスの文字列化
     */
    @Override
    public String toString() {
        return String.format("%s : HP %d, ATK %d, DEF %d, AGI %d",
                this.name, this.hp, this.atk, this.def, this.agi);
    }
}

