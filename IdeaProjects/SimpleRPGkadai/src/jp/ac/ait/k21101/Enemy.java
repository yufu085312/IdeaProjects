package jp.ac.ait.k21101;

public class Enemy extends CharacterBase{
    public Enemy(String name, int hp, int atk, int def, int agi) {
        super(name, hp, atk, def, agi);
    }
    public AttackResult attack(CharacterBase target) {
        // 引数の攻撃対象に対して与えることのできるダメージを算出
        // 与えるダメージ = 自身の攻撃力 - 敵の防御力 / 2 (小数点以下切り上げ) に、-3〜+3のランダムな値を加算
        int damage = (int)Math.ceil((double)this.getAtk() - (target.getDef() / 2.0))
                + (new java.util.Random().nextInt(7) - 3); // ← −3〜+3のランダムな値

        // 引数の攻撃対象がダメージを受ける
        boolean isBattleEnd = target.receiveDamage(damage);

        // 攻撃を行ったことによる行動結果を生成して返す
        AttackResult ret = new AttackResult();
        ret.damage = damage;
        if (isBattleEnd) {
            // 戦闘終了の条件を満たす場合、勇者の勝利となる
            ret.state = AttackResult.BATTLE_END;
        }

        return ret;
    }
}

