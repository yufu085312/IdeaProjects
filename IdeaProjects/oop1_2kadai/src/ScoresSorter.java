import java.util.Scanner;
public class ScoresSorter {
    public static void main(String[] args){
        String[] names = {"佐藤一郎", "鈴木次郎", "高橋三郎", "田中四郎", "伊藤五郎", "渡辺六郎", "山本七子", "中村八郎", "小林九", "加藤十子"};
        int[][] scores = {
                {100,30,50,40,50,60,70,80,95,10},
                {30,55,45,60,65,50,80,25,100,35},
                {90,75,35,90,65,60,80,25,0,20},
                {10,85,25,70,90,80,60,50,40,30},
                {60,40,30,50,70,70,70,70,15,55},
        };
        int[] gou = {0,0,0,0,0,0,0,0,0,0};

        for(int x = 0; x < 10; x++ ) {
            for (int y =0; y < scores.length; y++ ){
                gou[x] += scores[y][x];
            }
        }
        for (int i = 0; i < gou.length - 1; i++) {
            for (int h = i + 1 ; h < gou.length; h++) {
                if(gou[i] < gou[h]) {
                    int tmp = gou[h];
                    gou[h] = gou[i];
                    gou[i] = tmp;

                    String tmp2 = names[h];
                    names[h] = names[i];
                    names[i] = tmp2;
                }
            }
        }
        for (int x = 0; x < gou.length; x++) {
            System.out.println(names[x] + ":" + gou[x]);
        }
    }
}
