public class Car {
    double fuelEfficiency = 0.0;
    double totalMileage = 0.0;
    double expendedFuel = 0.0;

    double run(double mileage) {
        totalMileage += mileage;
        double syouhi = mileage / fuelEfficiency;
        expendedFuel += syouhi;
        return syouhi;
    }
    void printInfo() {
        System.out.println("走行距離:" + totalMileage  + "km " + "消費燃料:" + expendedFuel + "L");
    }
}
