import java.util.Scanner;

public class FuelExpenseCalcurator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Car c = new Car();
        c.fuelEfficiency = 14.0;

        System.out.println("走行距離は？ (endで終了)");
        while (true) {
            String line = sc.nextLine();
            if (line.equals("end")) return;
            c.run(Double.parseDouble(line));
            c.printInfo();
        }
    }
}

