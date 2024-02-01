package jp.ac.ait.k21101;

/**
 * 行動後の戻り値
 */
public class AttackResult {

    public static final int BATTLE_END = 1;
    public static final int CONTINUE = 0;

    /**
     * 攻撃によって与えたダメージ
     */
    public int damage = 0;

    /**
     * アクション後の戦闘状態
     * 初期値は継続とする
     */
    public int state = CONTINUE;


    // UPDATE: ↓↓↓第6回課題にて追加したもの↓↓↓
    /**
     * 攻撃を外した場合のフラグ
     */
    public boolean miss = false;

    /**
     * 攻撃がクリティカルヒットかどうか
     */
    public boolean isCritical = false;
    // UPDATE: ↑↑↑第6回課題にて追加したもの↑↑↑
}

