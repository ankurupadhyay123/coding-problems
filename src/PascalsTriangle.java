import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 1) {
            list.add(Arrays.asList(1));
        } else if (numRows == 2) {
            list.add(Arrays.asList(1, 1));
        } else {
            list.add(Arrays.asList(1));
            list.add(Arrays.asList(1, 1));
            for (int i = 2; i < numRows; i++) {
                List<Integer> subList = new ArrayList<>();
                subList.add(0, 1);
                for (int k = 1; k < i; k++) {
                    List<Integer> prevList = list.get(i - 1);
                    subList.add(k, (prevList.get(k - 1) + prevList.get(k)));
                }

                subList.add(i, 1);
                list.add(subList);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}