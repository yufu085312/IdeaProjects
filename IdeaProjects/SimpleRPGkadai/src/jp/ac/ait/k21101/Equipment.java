package jp.ac.ait.k21101;

/**
 * 装備クラス
 * (課題の時点ではWeaponクラスの親の役割のみ)
 */
public class Equipment {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Equipment(String name) {
        this.name = name;
    }

    public Equipment() {
        this("装備");
    }
}

