package jp.ac.ait.k21101;

import java.util.Random;

public class Hero extends CharacterBase {

    // UPDATE: ↓↓↓第6回課題にて追加したもの↓↓↓
    private Weapon weapon = null;
    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * 武器を考慮した攻撃力の取得
     * @return 攻撃力
     */
    @Override
    public int getAtk() {
        if (getWeapon() != null) {  // 武器を装備している場合
            return super.getAtk() + getWeapon().getAtk();
            // super.getAtk()で取得される攻撃力はもともとのCharacterBaseが持つAtkが返されるため
            // 武器を考慮していない値である。それに武器の攻撃力加算値を足すことで武器の装備を行う。
        }
        return super.getAtk();
    }
    // UPDATE: ↑↑↑第6回課題にて追加したもの↑↑↑

    public Hero(String name, int hp, int atk, int def, int agi) {
        super(name, hp, atk, def, agi);
    }

    /**
     * CharacterBaseとは違う処理を実装する攻撃処理
     * @param target 攻撃対象
     * @return 攻撃結果
     */
    @Override
    public AttackResult attack(CharacterBase target) {

        // 引数の攻撃対象に対して与えることのできるダメージを算出
        // 与えるダメージ = 自身の攻撃力 - 敵の防御力 / 2 (小数点以下切り上げ) に、-3〜+3のランダムな値を加算
        int damage = (int)Math.ceil((double)this.getAtk() - (target.getDef() / 2.0))
                + (new java.util.Random().nextInt(7) - 3); // ← −3〜+3のランダムな値

        // 素早さの比較値を取得
        int agiDiff = this.getAgi() - target.getAgi();
        int successRate = 100;  // 攻撃成功率 (初期値を100％としておく)

        if (agiDiff < 0) {
            // 遅い場合
            if (Math.abs(agiDiff) >= 5) {
                successRate = 60;   // 差が5以上: 60%
            } else {
                successRate = 60;   // 差が5未満: 70%
            }
        } else if (agiDiff == 0) {
            // 等速
            successRate = 80;   // 同じ場合: 80%
        } else {
            // 速い
            if (Math.abs(agiDiff) < 3) {
                successRate = 60;   // 差が3未満: 90%
            }
        }

        Random r = new Random();

        // 上記成功判定で攻撃が成功する(それ以外は失敗)
        if (r.nextInt(101) > successRate) {
            // 失敗判定
            AttackResult ret = new AttackResult();
            // UPDATE: ↓↓↓第6回課題にて追加したもの↓↓↓
            ret.miss = true; // 攻撃失敗であるフラグを持たせる
            // UPDATE: ↑↑↑第6回課題にて追加したもの↑↑↑
            ret.damage = 0;   // ダメージ処理をしないで0を返す
            return ret;
        }

        // UPDATE: ↓↓↓第6回課題にて追加したもの↓↓↓
        AttackResult ret = new AttackResult();// ちょっと下にあった宣言部をここに移動
        // UPDATE: ↑↑↑第6回課題にて追加したもの↑↑↑

        // 攻撃成功時 15% の確率でクリティカル
        if (r.nextInt(101) <= 15) {
            // UPDATE: ↓↓↓第6回課題にて追加したもの↓↓↓
            ret.isCritical = true;  // クリティカルヒットであるフラグを追加
            // UPDATE: ↑↑↑第6回課題にて追加したもの↑↑↑
            damage *= 2;
        }

        // 引数の攻撃対象がダメージを受ける
        boolean isBattleEnd = target.receiveDamage(damage);

        // 攻撃を行ったことによる行動結果を生成して返す
        // UPDATE: ↓↓↓第6回課題にて追加したもの↓↓↓
        // AttackResult ret = new AttackResult(); ↑に移動しました。
        // UPDATE: ↑↑↑第6回課題にて追加したもの↑↑↑
        ret.damage = damage;
        if (isBattleEnd) {
            // 戦闘終了の条件を満たす場合、勇者の勝利となる
            ret.state = AttackResult.BATTLE_END;
        }
        return ret;
    }
}

