package jp.ac.ait.k21101;

public class Manager {
    /**
     * 回答の試行回数をカウントします。
     */
    private int count;
    /**
     * 答えを保持するフィールド
     */
    private  Answer answer;

    /**
     * ゲームの初期化を行う
     */
    public Manager() {
        //countに初期値0を代入
        this.count = 0;
        //answerにAnswerクラスをインスタンス化して代入
        this.answer = new Answer();
    }
    //メソッド
    public int getCount() {
        return count;
    }

    public Answer getAnswer() {
        return answer;
    }

    /**
     * 答えに対して試行するメソッド
     * @param in　3桁の整数値で構成された文字列
     * @return HITの数と、BLOWの数を計算してResponseクラスのインスタンスとして返す
     */
    public Response solve(String in) {
        //試行したい文字列in（3桁の整数値で構成された文字列）
        //エラーチェックなどは不要

        //1.countに1を足し、試行回数をカウントアップ
        //TODO:
        this.count += 1;

        //2.Hit, Blowを計算し、Responseのインスタンスで返します。
        int hit = 0;
        int blow = 0;

        //TODO: HITとBLOWは各自で計算しましょう
        //ここで、BLOWの数に、Hitの数は含まれない点を注意してください.

        for (int x = 0; x < in.length(); x++) {
            if (answer.get().charAt(x) == in.charAt(x)) {
                hit++;
            }

            for (int s = 0; s < in.length(); s++) {
                if (answer.get().charAt(x) == in.charAt(s)) {
                    if(x == s){
                        continue;
                    }
                    blow++;
                }
            }
        }
            //戻り値はResponseのインスタンス
            return new Response(hit, blow);
        }
    }
