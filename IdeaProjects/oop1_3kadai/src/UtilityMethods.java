public class UtilityMethods {
    //1-1
    void printCurrency(double a) {
        System.out.printf("%.2f\n", a);
    }
    //1-2
    int add(int x, int y) {
        return x + y;
    }
    //1-3
    double division(int x, int y) {
        return (double)x / (double)y;
    }
    //1-4
    String getTheAnswerToTheUltimateQuestionOfLife_TheUniverse_And_Everything() {
        try{
            Thread.sleep(750);
        }catch(InterruptedException e){}
        return "42";
    }
    public static void main(String[] args) {
        UtilityMethods app = new UtilityMethods();
        //動作確認
        //1-1
        double a = 1.001;
        app.printCurrency(1.247);
        app.printCurrency(1);
        app.printCurrency(-12345678);
        app.printCurrency(12345678.9);

        //1-2
        System.out.println("1-2動作確認");
        double b = 1.001;
        System.out.println(app.add(1,2));
        System.out.println(app.add(34,5));

        //1-3
        System.out.println("1-3の動作確認");
        double c = 1.001;
        System.out.println(app.division(4,2));
        System.out.println(app.division(3,5));

        //1-4
        System.out.println("1-4動作確認");
        System.out.println(app.getTheAnswerToTheUltimateQuestionOfLife_TheUniverse_And_Everything());
    }
}
