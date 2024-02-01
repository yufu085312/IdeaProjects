package jp.ac.ait.k21101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.String;
public class FizzBuzz implements IKadai07_2 {
    @Override
    public List<String> getConverted(List<Integer> targetList) {

        List<String> fizzbuzz = new ArrayList<String>();

        for (int i : targetList) {
            if(i==0){
                fizzbuzz.add(String.valueOf(i));
            } else if(i % 3 == 0 && i % 5 == 0) {
                fizzbuzz.add("FizzBuzz");
            } else if (i % 3 == 0) {
                fizzbuzz.add("Fizz");
            } else if (i % 5 == 0) {
                fizzbuzz.add("Buzz");
            } else {
                fizzbuzz.add(String.valueOf(i));
            }
        }


        return fizzbuzz;
    }

    public static void main(String[] args) {
        FizzBuzz f = new FizzBuzz();
        var targetList = Arrays.asList(0,1,2,3,4,5);
                System.out.println(f.getConverted(targetList));
    }
}

