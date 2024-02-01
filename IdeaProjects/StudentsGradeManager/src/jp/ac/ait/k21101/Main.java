package jp.ac.ait.k21101;

import jp.ac.ait.oop1.section09.Grade;
import jp.ac.ait.oop1.section09.IStudent;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //動作確認
        //インスタンス化
        List<Grade> grades1 = new ArrayList<>();
            grades1.add(new Grade("線形代数",2, 'A'));
            grades1.add(new Grade("物理実験",3,'S'));
            grades1.add(new Grade("微分積分",2,'B'));
        List<Grade> grades2 = new ArrayList<>();
            grades2.add(new Grade("線形代数",2, 'C'));
            grades2.add(new Grade("物理実験",3,'Q'));
            grades2.add(new Grade("微分積分",2,'S'));
        List<Grade> grades3 = new ArrayList<>();
            grades3.add(new Grade("線形代数",2, 'B'));
            grades3.add(new Grade("物理実験",3,'F'));
            grades3.add(new Grade("微分積分",2,'Q'));

        List<IStudent> stu = new ArrayList<>();
            stu.add(new Student("K11111","太郎",grades1));
            stu.add(new Student("K22222","太郎2",grades2));
            stu.add(new Student("K33333","太郎3",grades3));
            System.out.println(stu);

            Student stay = new Student();
            stay.setGrades(grades1);
            System.out.println("-----------------------Student-----------------------------");
            System.out.println("太郎のデータ");
            System.out.println("成績を評価の降順で並び替えして取得");
            System.out.println(stay.getGradesSortByRatingDsc());
            System.out.println("指定された評価の成績リストを取得する");
            System.out.println(stay.getGradesFilterByRating('S'));
            System.out.println("単位取得できた成績リストを取得する");
            System.out.println(stay.getGradesFilterByCreditsEarned());
            System.out.println("単位の総取得数");
            System.out.println(stay.getTotalCreditsEarned());

            Student stay2 = new Student();
            stay2.setGrades(grades2);
            System.out.println("--------------------------------------------------------------");
            System.out.println("太郎2のデータ");
            System.out.println("成績を評価の降順で並び替えして取得");
            System.out.println(stay2.getGradesSortByRatingDsc());
            System.out.println("指定された評価の成績リストを取得する");
            System.out.println(stay2.getGradesFilterByRating('S'));
            System.out.println("単位取得できた成績リストを取得する");
            System.out.println(stay2.getGradesFilterByCreditsEarned());
            System.out.println("単位の総取得数");
            System.out.println(stay2.getTotalCreditsEarned());

            Student stay3 = new Student();
            stay3.setGrades(grades3);
            System.out.println("---------------------------------------------------------------");
            System.out.println("太郎3のデータ");
            System.out.println("成績を評価の降順で並び替えして取得");
            System.out.println(stay3.getGradesSortByRatingDsc());
            System.out.println("指定された評価の成績リストを取得する");
            System.out.println(stay3.getGradesFilterByRating('S'));
            System.out.println("単位取得できた成績リストを取得する");
            System.out.println(stay3.getGradesFilterByCreditsEarned());
            System.out.println("単位の総取得数");
            System.out.println(stay3.getTotalCreditsEarned());

            System.out.println("-------------------------StudentsSorter-----------------------------");
            StudentsSorter studentssorter = new StudentsSorter();
            studentssorter.setStudents(stu);
            System.out.println("生徒リストを設定");
            System.out.println(studentssorter.getStudents());
            System.out.println();
            System.out.println("取得単位数の昇順で並び替えた生徒リストの取得");
            System.out.println(studentssorter.sortByTotalCreditsEarnedAsc());
            System.out.println();
            System.out.println("取得単位数の降順で並び替えた生徒リストの取得");
            System.out.println(studentssorter.sortByTotalCreditsEarnedDsc());





    }
}
