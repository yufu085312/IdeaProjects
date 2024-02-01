package jp.ac.ait.k21101;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NonUniqueElements implements IKadai07_4{

    @Override
    public void convert(List<Integer> targetList) {

        List<Integer> nonuniquelements = new ArrayList<Integer>();
        int count = 0;

        for (int x : targetList) {
            for (int y : targetList) {
                if (x == y) {
                    count++;
                }
            }
            if (count > 1) {
                nonuniquelements.add(x);
            }
            count = 0;
        }
        System.out.println(nonuniquelements);
    }

    public static void main(String[] args) {
        IKadai07_4 ret = new NonUniqueElements();
        var list = Arrays.asList(1, 2, 3, 1, 3);  // ArrayList<Integer>
        ret.convert(list);
    }
}
