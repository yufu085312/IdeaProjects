package jp.ac.ait.k21101;

public class Equipment {
    //フィールド
    private String name;

    //コンストラクタ
    public Equipment(String name) {
        //初期値セット
        this.name = name;
    }

    public Equipment(){
        //名前を「装備」で初期化
        this("装備");
    }

    //メソッド
    //public String getName() - 名前を返す
    public String getName() {
        return name;
    }

    //public void setName(String name) - 名前を設定する
    public void setName(String name) {
        this.name = name;
    }
}
