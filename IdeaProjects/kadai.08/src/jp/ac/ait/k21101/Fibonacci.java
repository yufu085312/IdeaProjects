package jp.ac.ait.k21101;

import java.util.List;
import java.util.ArrayList;

public class Fibonacci implements IKadai07_1 {
    @Override
    public List<Integer> get(int n) {

        int num1 = 0;
        int num2 = 1;
        int x = 0;

        List<Integer> fibonacci = new ArrayList();

        if (n >= 0) {
            fibonacci.add(num1);
        }
        if (n >= 1) {
            fibonacci.add(num2);
        }

        while ((num1 + num2) <= n) {
            x = num1 + num2;
            fibonacci.add(x);
            num1 = num2;
            num2 = x;
        }
        return fibonacci;
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        List<Integer> fibonacci = f.get(10000);
        f.get(10000);
        for (int a : fibonacci) {
            System.out.print(a + ",");
        }
    }
}

