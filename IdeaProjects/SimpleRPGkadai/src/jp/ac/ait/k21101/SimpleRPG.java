package jp.ac.ait.k21101;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

/**
 * SimpleRPG (Entry point)
 */
public class SimpleRPG {

    // Scannerを共通化
    static final Scanner scanner = new Scanner(System.in);

    Hero hero;
    Enemy enemy;

    /**
     * 勇者の名前を入力
     *
     * @return 勇者
     */
    Hero createHero() {

        Random random = new Random();

        // 勇者の名前は、画面から入力
        System.out.println("勇者の名前を入力してください。");
        String name = scanner.nextLine();

        // パラメータをランダムに設定
        int hp = random.nextInt(41) + 80;  // 80〜120
        int atk = random.nextInt(8) + 8;  // 8〜15
        int def = random.nextInt(8) + 8;  // 8〜15
        int agi = random.nextInt(8) + 8;  // 8〜15

        //String asss = scanner.nextLine();
        //if(. ("1")){
        //return new sss(name,hp,atk,def,agi);
        //}
        //return new sss2(name,hp,atk,def,agi)

        System.out.println("1:市民　2:剣士");
        String jobdec = scanner.nextLine();
        if (jobdec == "1") {
            return new SwordFighter1(name, hp, atk, def, agi);
        } else {
            return new SwordFighter2(name, hp, atk, def, agi);
        }

        // 勇者を生成して返す
        //return new Hero(name, hp, atk, def, agi);

    }


    /**
     * 敵を生み出して返す
     */
    Enemy createEnemy() {

        // 敵の名前の配列より、ランダムの1つが選ばれて生成されます
        final String[] ENEMY_NAMES = {"猪", "鹿", "野良犬", "鷹", "熊"};

        Random random = new Random();

        // 上で設定した敵の名前の配列からランダムな要素を取り出し
        String name = ENEMY_NAMES[random.nextInt(ENEMY_NAMES.length)];

        // パラメータをランダムに設定
        int hp = random.nextInt(151) + 50;  // 50〜200
        int atk = random.nextInt(11) + 10;  // 10〜20
        int def = random.nextInt(11) + 5;  // 5〜15
        int agi = random.nextInt(11) + 10;  // 10〜20

        // 敵を生成して返す
        return new Enemy(name, hp, atk, def, agi);
    }

    /**
     * 勇者の行動選択
     *
     * @return 戦闘続行可能の場合 true を返す 不可能の場合 false
     */
    boolean heroAction() {
        // 勇者の行動決定メッセージ

        // 職業の取得 (変数heroはHeroのインスタンス)
        IHeroJob job = (IHeroJob) hero;

        System.out.print("行動を選択(1: 攻撃, 2: "   + job.getSpecialAttackName()  + " それ以外: 逃亡) : ");
        String hero_action = scanner.nextLine();

        if (hero_action.equals("1")) {
            // 敵に攻撃
            AttackResult ar = hero.attack(enemy);
            // UPDATE: ↓↓↓第6回課題にて追加したもの↓↓↓
            // System.out.println(hero.getName() + "の攻撃: " + enemy.getName() + "に" + ar.damage + "のダメージ");
            if (ar.miss) {
                // 攻撃失敗
                System.out.println(hero.getName() + "の攻撃: 失敗！" + enemy.getName() + "にダメージは与えられなかった(敵HP:" + enemy.getHp() + ")");
            } else { // 条件分岐が冗長なので、ここはelse句を使わなくても良い気がします。
                // 攻撃成功
                if (ar.isCritical) {
                    // クリティカルヒット
                    System.out.println(hero.getName() + "の攻撃: クリティカル！" + enemy.getName() + "に" + ar.damage + "のダメージ(敵HP:" + enemy.getHp() + ")");
                } else {
                    // 通常ヒット
                    System.out.println(hero.getName() + "の攻撃: " + enemy.getName() + "に" + ar.damage + "のダメージ(敵HP:" + enemy.getHp() + ")");
                }
            }
            // UPDATE: ↑↑↑第6回課題にて追加したもの↑↑↑

            // 戦闘継続以外の状態を判定
            if (ar.state != AttackResult.CONTINUE) {
                // ゲームクリアによりプログラムを終了
                System.out.println(enemy.getName() + "を倒しました。");
                return false;
            }
        } else if (hero_action.equals("2")) {
            // このとき、上記4をすっ飛ばして実装を行うと、職業クラスのインスタンスではなくHeroクラスのインスタンスが渡されてしまう。
            // 必ずIHeroJobを実装した勇者の職業クラスを使ってHeroのインスタンスを生成したものを渡してください。
            // きちんとできているかをチェックするには、 if (hero instanceof IHeroJob) {} が使えます。

            // 特殊行動を行う場合は、jobからメソッドを呼び出しましょう。
            AttackResult res = job.specialAttack(enemy);
            System.out.println(hero.getName() + "の攻撃: " + enemy.getName() + "に" + res.damage + "のダメージ(敵HP:" + enemy.getHp() + ")");

            // 戦闘継続以外の状態を判定
            if (res.state != AttackResult.CONTINUE) {
                // ゲームクリアによりプログラムを終了
                System.out.println(enemy.getName() + "を倒しました。");
                return false;
            }

        } else {
            // 逃亡によりプログラムを終了
            System.out.println(hero.getName() + "は" + enemy.getName() + "から逃げ出しました。");
            System.out.println("ゲームオーバー");
            return false;
        }
        return true;
    }

    /**
     * 敵の行動選択（攻撃行動のみ）
     *
     * @return 戦闘続行可能の場合 true を返す 不可能の場合 false
     */
    boolean enemyAction() {
        AttackResult ar = enemy.attack(hero);
        // UPDATE: ↓↓↓第6回課題にて追加したもの↓↓↓
        System.out.println(enemy.getName() + "の攻撃: " + hero.getName() + "は" + ar.damage + "のダメージ(勇者HP:" + hero.getHp() + ")");
        // UPDATE: ↑↑↑第6回課題にて追加したもの↑↑↑

        if (ar.state != AttackResult.CONTINUE) {
            // ゲームオーバーによりプログラム終了
            System.out.println(hero.getName() + "は倒されました。");
            System.out.println("ゲームオーバー");
            return false;
        }
        // 敵の行動終わり
        return true;
    }

    void battleLoop() {
        while (true) {
            // 勇者の素早さと敵の素早さを比較
            if (hero.getAgi() >= enemy.getAgi()) {
                // 勇者のほうが素早い
                if (!heroAction()) return;
                if (!enemyAction()) return;
            } else {
                // 敵のほうが素早い
                if (!enemyAction()) return;
                if (!heroAction()) return;
            }
            // ターンの区切り線
            System.out.println("---------------------------------------------");
        }
    }


    public static void main(String[] args) {

        SimpleRPG app = new SimpleRPG();

        // ゲームスタートのフレーバーテキスト
        System.out.println("SimpleRPG");
        System.out.println("---------------------------------------------");

        // 1. 勇者の登場
        app.hero = app.createHero();

        //System.out.println(((IHeroJob)app.hero).getJobName());
        //System.out.println(((IHeroJob)app.hero).getSpecialAttackName());

        // UPDATE: ↓↓↓第6回課題にて追加したもの↓↓↓
        //TODO: このあたりで武器を作って装備させてください
        Weapon weapon = new Weapon("ヒノキの棒", 5);
        // 何度か実行してみて、勇者が弱すぎたり、強すぎたりする場合に攻撃力加算値を調整してください。
        app.hero.setWeapon(weapon);
        // UPDATE: ↑↑↑第6回課題にて追加したもの↑↑↑

        // 2. 敵の登場
        app.enemy = app.createEnemy();

        // 3. ステータスの表示
        System.out.println("---------------------------------------------");
        System.out.println("勇者: " + app.hero.getName() + " HP:" + app.hero.getHp() + " ATK:" + app.hero.getAtk() + " DEF:" + app.hero.getDef() + " AGI:" + app.hero.getAgi());
        System.out.println("敵　: " + app.enemy.getName() + " HP:" + app.enemy.getHp() + " ATK:" + app.enemy.getAtk() + " DEF:" + app.enemy.getDef() + " AGI:" + app.enemy.getAgi());
        System.out.println("---------------------------------------------");

        // 4. 戦闘開始
        app.battleLoop();

    }
}

