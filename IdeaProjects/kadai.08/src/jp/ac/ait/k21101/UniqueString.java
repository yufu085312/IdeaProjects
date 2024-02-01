package jp.ac.ait.k21101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.String;

public class UniqueString implements IKadai07_3 {

    @Override
    public List<String> getUniqueList(List<String> targetList) {

        List<String> uniquestring = new ArrayList<String>();

        for(String x : targetList) {
            int count =0;
            for (String y : targetList) {
                if (x == y) {
                    count++;
                }
            }
            if(count==1) {
                uniquestring.add(x);
            }

        }
        return uniquestring;
    }
    public static void main(String[] args) {
        UniqueString app = new UniqueString();
        var list = Arrays.asList("A", "B", "B", "B", "C");  // ArrayList<Integer>
        System.out.println(app.getUniqueList(list));
    }


}
