package jp.ac.ait.k21101;

/**
 * 答え合わせをした場合のHIT,BlOWの数を保持して返信するためのクラス
 */
public class Response {

    /**
     * HITの数
     */
    private  int hit;
    /**
     * BLOWの数
     */
    private  int blow;

    /**
     * HITとBLOWの数を指定して初期化
     * ＠param hit
     * ＠param blow
     */

    public  Response(int hit, int blow) {
        this.hit = hit;
        this.blow = blow;
    }
    /**
     * HITとBLOWを0として初期化
     */
    public Response() {
        this(0,0);
    }

    public int getHit() {
        return hit;
    }

    public int getBlow() {
        return blow;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public void setBlow(int blow) {
        this.blow = blow;
    }
}
