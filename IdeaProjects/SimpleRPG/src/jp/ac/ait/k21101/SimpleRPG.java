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
        //勇者の名前を入力させます
        System.out.println("主人公の名前を決めてね！");
        String name = scanner.nextLine();
        // 以下の表に従ってパラメータを生成
        Hero hero = new Hero( // パラメータ	ランダム範囲
                name,
                new Random().nextInt(41) + 80,  // HP	80 〜 120
                new Random().nextInt(8) + 8,   // ATK	8 〜 15
                new Random().nextInt(8) + 8,   // DEF	8 〜 15
                new Random().nextInt(8) + 8);  // AGI	8 〜 15

        Scanner sc = new Scanner(System.in);
        System.out.println("相棒を選んでね");
        System.out.println("1:ピカチュウ　2:リザードン  3:ミュウツー ");
        String input = sc.nextLine();
        int num = Integer.parseInt(input);
        if(num==1) {
            Weapon dagger = new Weapon(
                    "ピカチュウ", 5);
            hero.setWeapon(dagger);
        } else if (num==2) {
            Weapon dagger = new Weapon(
                    "リザードン", 10);
            hero.setWeapon(dagger);
        } else if (num==3) {
            Weapon dagger = new Weapon(
                    "ミュウツー", 15);
            hero.setWeapon(dagger);
        } else {
            System.out.println("誰も選んでないよ！自分で戦おう！");
        }
        return hero;
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
        System.out.println("戦う？それとも逃げる？(1: 攻撃, それ以外: 逃亡)");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            // 攻撃だった場合
            AttackResult ret = hero.attack(enemy);
            System.out.println(enemy.getName() + "に" + ret.damage + "のダメージ");
            System.out.println(enemy.getName() + "は残り HP " + enemy.getHp());
            if (ret.state == AttackResult.BATTLE_END) {
                // 戦闘終了
                System.out.println(enemy.getName() + "を倒しました。ゲームクリア。");
                System.out.println("おめでとう！君は立派なポケモントレーナーだ！");
                return false; // 続行不能
            }
            // 戻り値は、行動により戦闘続行可否をbooleanで返します
            return true;
        } else {
            // 逃亡だった場合
            System.out.println(hero.getName() + "は逃げた！。ゲームオーバー");
            System.out.println("また挑戦しよう！");
            return false; // 続行不能
        }
    }

    boolean enemyAction() {
        // 敵の1回分の攻撃行動を行わせるメソッド（敵は攻撃の行動のみ行います）
        // 攻撃だった場合
        AttackResult ret = enemy.attack(hero);
        System.out.println(hero.getName() + "に" + ret.damage + "のダメージ");
        System.out.println(hero.getName() + "は残り HP " + hero.getHp());
        if (ret.state == AttackResult.BATTLE_END) {
            // 戦闘終了
            System.out.println(hero.getName() + "は無残にも倒れてしまった。ゲームオーバー");
            System.out.println("また挑戦しよう！");
            return false; // 続行不能
        }
        // 戻り値は、行動により戦闘続行可否をbooleanで返します
        return true;
    }

    void battleLoop() {
        //戦闘処理の無限ループを用意します
        while(true) {
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
        }
    }

    public static void main(String[] args) {
        SimpleRPG app = new SimpleRPG();

        System.out.println("ポケモンゲームスタート！！！");

        app.hero = app.createHero();

        System.out.println(app.hero);

        System.out.println("攻撃力が" + app.hero.getAtk() + "に上がった！");

        System.out.println("自分: " + app.hero.getName() + " HP:" + app.hero.getHp() + " 攻撃力:" + app.hero.getAtk() + " 防御力:" + app.hero.getDef() + " 素早さ:" + app.hero.getAgi());

        app.enemy = app.createEnemy();
        System.out.println(app.enemy.getName() + "が現れた！");
        System.out.println("相手　: " + app.enemy.getName() + " HP:" + app.enemy.getHp() + " 攻撃力:" + app.enemy.getAtk() + " 防御力:" + app.enemy.getDef() + " 素早さ:" + app.enemy.getAgi());

        app.battleLoop();
    }


}
