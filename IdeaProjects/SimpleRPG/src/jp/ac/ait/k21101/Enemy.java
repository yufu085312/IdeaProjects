package jp.ac.ait.k21101;

public class Enemy extends CharacterBase {



    /**
     * 各ステータスを指定して初期化
     * @param name
     * @param hp
     * @param atk
     * @param def
     * @param agi
     */
    public Enemy(String name, int hp, int atk, int def, int agi) {
        super(name, hp, atk, def, agi);
    }


}
