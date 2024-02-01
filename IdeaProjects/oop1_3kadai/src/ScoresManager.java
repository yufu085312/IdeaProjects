import java.util.Scanner;

public class ScoresManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Score s = new Score();

        System.out.println("出席番号:");
        s.id = Integer.parseInt(sc.nextLine());
        System.out.println("氏名:");
        s.name = sc.nextLine();
        System.out.println("国語:");
        s.setJapanese(Integer.parseInt(sc.nextLine()));
        System.out.println("数学:");
        s.setMathmatics(Integer.parseInt(sc.nextLine()));
        System.out.println("理科:");
        s.setScience(Integer.parseInt(sc.nextLine()));
        System.out.println("社会:");
        s.setSocialStudies(Integer.parseInt(sc.nextLine()));
        System.out.println("英語:");
        s.setEnglish(Integer.parseInt(sc.nextLine()));

        s.printInfo();

    }
}

