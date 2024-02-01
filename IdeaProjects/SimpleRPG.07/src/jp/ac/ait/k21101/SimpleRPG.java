package jp.ac.ait.k21101;

import java.util.Random;
import java.util.Scanner;

public class SimpleRPG {
    // このクラスでは、画面からの入力をいろいろなメソッドで行うため、
    // フィールド化しておく
    final static Scanner scanner = new Scanner(System.in);

    Hero hero;
    Enemy enemy;
    /**
     * 勇者を生成して返すメソッド
     * @return
     */
    Hero createHero() {
        Random random = new Random();
        //勇者の名前を入力させます
        System.out.println("主人公の名前を決めてね！");
        String name = scanner.nextLine();
        // 以下の表に従ってパラメータを生成
        // パラメータ	ランダム範囲
                int hp  = random.nextInt(41) + 80;  // HP	80 〜 120
                int atk  = random.nextInt(8) + 8;   // ATK	8 〜 15
                int def = random.nextInt(8) + 8;   // DEF	8 〜 15
                int agi = random.nextInt(8) + 8;  // AGI	8 〜 15

        System.out.println("男？女？　1:男　2:女");
        String input1 = scanner.nextLine();
        if (input1 == "1") {
            return new SwordFighter1(name, hp, atk, def, agi);
        } else {
            return new SwordFighter2(name, hp, atk, def, agi);
        }
        //return new Hero(name, hp, atk, def, agi);
    }
    Enemy createEnemy() {

        final String[] ENEMY_NAMES = {"ゲッコウガ", "ガブリアス", "イーブイ", "ポッポ", "デデンネ"};

        // 上記配列から、ランダムに1つだけの名前を抽出して敵の名前とする。
        String name = ENEMY_NAMES[new Random().nextInt(ENEMY_NAMES.length)];

        Enemy enemy = new Enemy( // パラメータ	ランダム範囲
                name,
                new Random().nextInt(151) + 50,  // HP  	50 〜 200
                new Random().nextInt(11) + 10,  // ATK	10 〜 20
                new Random().nextInt(11) + 5,   // DEF	5 〜 15
                new Random().nextInt(11) + 10); // AGI	10 〜 20

        return enemy;

    }

    /**
     *  勇者の行動
     * @return falseの場合続行不能
     */
    boolean heroAction() {
        // 勇者の1回分の行動決定と行動を行わせるメソッド
        // 画面より、攻撃か逃亡かを選択させ、その行動結果を画面に表示します
        // 職業の取得 (変数heroはHeroのインスタンス)
        IHeroJob job = (IHeroJob) hero;
        System.out.println("戦う？それとも逃げる？(1: 攻撃, 2: " + job.getSpecialAttackName() + " それ以外: 逃亡)");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            // 攻撃だった場合
            AttackResult ar = hero.attack(enemy);
            if (ar.miss) {
                // 攻撃失敗
                System.out.println(hero.getName() + "の攻撃: 失敗！" + enemy.getName() + "にダメージは与えられなかった(敵HP:" + enemy.getHp() + ")");
            } else{ // 条件分岐が冗長なので、ここはelse句を使わなくても良い気がします。
                // 攻撃成功
                if (ar.isCritical) {
                    // クリティカルヒット
                    System.out.println(hero.getName() + "の攻撃: クリティカル！" + enemy.getName() + "に" + ar.damage + "のダメージ(敵HP:" + enemy.getHp() + ")");
                } else {
                    // 通常ヒット
                    System.out.println(hero.getName() + "の攻撃: " + enemy.getName() + "に" + ar.damage + "のダメージ(敵HP:" + enemy.getHp() + ")");
                }
            }

                //System.out.println(enemy.getName() + "に" + ret.damage + "のダメージ" + " 残りHP " + enemy.getHp());
            if (ar.state == AttackResult.BATTLE_END) {
                // 戦闘終了
                System.out.println(enemy.getName() + "を倒しました。ゲームクリア。");
                System.out.println("おめでとう！君は立派なポケモントレーナーだ！");
                return false; // 続行不能
            }
            // 戻り値は、行動により戦闘続行可否をbooleanで返します
        } else if (input.equals("2")) {
            // このとき、上記4をすっ飛ばして実装を行うと、職業クラスのインスタンスではなくHeroクラスのインスタンスが渡されてしまう。
            // 必ずIHeroJobを実装した勇者の職業クラスを使ってHeroのインスタンスを生成したものを渡してください。
            // きちんとできているかをチェックするには、 if (hero instanceof IHeroJob) {} が使えます。

            // 特殊行動を行う場合は、jobからメソッドを呼び出しましょう。
            AttackResult res = job.specialAttack(enemy);

            if (res.miss) {
                // 攻撃失敗
                System.out.println(hero.getName() + "の攻撃: 失敗！" + enemy.getName() + "にダメージは与えられなかった(敵HP:" + enemy.getHp() + ")");
            } else{ // 条件分岐が冗長なので、ここはelse句を使わなくても良い気がします。
                // 攻撃成功
                if (res.isCritical) {
                    // クリティカルヒット
                    System.out.println(hero.getName() + "の攻撃: クリティカル！" + enemy.getName() + "に" + res.damage + "のダメージ(敵HP:" + enemy.getHp() + ")");
                } else {
                    // 通常ヒット
                    System.out.println(hero.getName() + "の攻撃: " + enemy.getName() + "に" + res.damage + "のダメージ(敵HP:" + enemy.getHp() + ")");
                }
            }
            //System.out.println(hero.getName() + "の攻撃: " + enemy.getName() + "に" + res.damage + "のダメージ(敵HP:" + enemy.getHp() + ")");
            // 戦闘継続以外の状態を判定
            if (res.state != AttackResult.CONTINUE) {
                // 戦闘終了
                System.out.println(enemy.getName() + "を倒しました。ゲームクリア。");
                System.out.println("おめでとう！君は立派なポケモントレーナーだ！");
                return false; // 続行不能
            }
        } else {
                // 逃亡だった場合
                System.out.println(hero.getName() + "は逃げた！。ゲームオーバー");
                System.out.println("また挑戦しよう！");
                return false; // 続行不能
            }
        return true;
    }

        boolean enemyAction () {
            // 敵の1回分の攻撃行動を行わせるメソッド（敵は攻撃の行動のみ行います）
            // 攻撃だった場合
            AttackResult ar = enemy.attack(hero);
            System.out.println(enemy.getName() + "の攻撃: " + hero.getName() + "に" + ar.damage + "のダメージ" + " 残りHP " + hero.getHp());
            if (ar.state == AttackResult.BATTLE_END) {
                // 戦闘終了
                System.out.println(hero.getName() + "は無残にも倒れてしまった。ゲームオーバー");
                System.out.println("また挑戦しよう！");
                return false; // 続行不能
            }
            // 戻り値は、行動により戦闘続行可否をbooleanで返します
            return true;
        }

        void battleLoop () {
            //戦闘処理の無限ループを用意します
            while (true) {
                // 無限ループ内では、勇者と敵の素早さを比較し行動順序を入れ替え、それぞれの行動を行います
                // 行動により戦闘続行不可能になった場合は、その場で無限ループを抜け、メソッドを終了します
                if (hero.getAgi() >= enemy.getAgi()) {
                    // 勇者のほうが早い
                    if (!heroAction()) return;
                    if (!enemyAction()) return;
                } else {
                    if (!enemyAction()) return;
                    if (!heroAction()) return;
                }
                // ターンの区切り線
                System.out.println("---------------------------------------------");

            }
        }

        public static void main (String[]args){
            SimpleRPG app = new SimpleRPG();

            System.out.println("ポケモンゲームスタート！！！");

            app.hero = app.createHero();

            Scanner sc = new Scanner(System.in);
            System.out.println("相棒を選んでね");
            System.out.println("1:ピカチュウ　2:リザードン  3:ミュウツー ");
            String input2 = sc.nextLine();
            int num = Integer.parseInt(input2);
            if (num == 1) {
                Weapon dagger = new Weapon(
                        "ピカチュウ", 3);
                app.hero.setWeapon(dagger);
            } else if (num == 2) {
                Weapon dagger = new Weapon(
                        "リザードン", 5);
                app.hero.setWeapon(dagger);
            } else if (num == 3) {
                Weapon dagger = new Weapon(
                        "ミュウツー", 10);
                app.hero.setWeapon(dagger);
            } else {
                System.out.println("誰も選んでないよ！自分で戦おう！");
            }

            //System.out.println(app.hero);

            System.out.println("攻撃力が" + app.hero.getAtk() + "になった！");

            System.out.println("自分: " + app.hero.getName() + " HP:" + app.hero.getHp() + " 攻撃力:" + app.hero.getAtk() + " 防御力:" + app.hero.getDef() + " 素早さ:" + app.hero.getAgi());

            app.enemy = app.createEnemy();
            System.out.println(app.enemy.getName() + "が現れた！");
            System.out.println("相手　: " + app.enemy.getName() + " HP:" + app.enemy.getHp() + " 攻撃力:" + app.enemy.getAtk() + " 防御力:" + app.enemy.getDef() + " 素早さ:" + app.enemy.getAgi());

            app.battleLoop();
        }
    }