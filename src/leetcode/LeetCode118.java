package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode118 {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> lastList = null;
            if (i > 2) {
                lastList = list.get(i - 2);
            }
            List<Integer> subList = new ArrayList<>();
            subList.add(1);
            for (int j = 1; j < i - 1; j++) {
                if (lastList != null) {
                    subList.add(lastList.get(j - 1) + lastList.get(j));
                }
            }
            if (i > 1) {
                subList.add(1);
            }
            list.add(subList);
        }
        return list;
    }

}
