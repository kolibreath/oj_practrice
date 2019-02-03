import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleii {
    static class Solution {
        public List<Integer> getRow(int rowIndex) {
            return create(rowIndex+1).get(rowIndex);
        }


        public List<List<Integer>> create(int numRows) {
            if (numRows == 0) {
                return new ArrayList<List<Integer>>();
            }

            ArrayList<List<Integer>> list = new ArrayList<>();

            if (numRows == 1) {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(1);
                list.add(l);
                return list;
            }

            if (numRows == 2) {
                ArrayList<Integer> l = new ArrayList<>();

                l.add(1);
                list.add(l);

                ArrayList<Integer> l1 = new ArrayList<>();
                l1.add(1);
                l1.add(1);

                list.add(l1);

                return list;
            }

            ArrayList<Integer> t = new ArrayList<>();

            t.add(1);
            list.add(t);

            ArrayList<Integer> t1 = new ArrayList<>();
            t1.add(1);
            t1.add(1);
            list.add(t1);

            for (int i = 3; i <= numRows; i++) {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(1);
                for (int j = 1; j <= i - 2; j++) {
                    l.add(list.get(i - 2).get(j - 1) + list.get(i - 2).get(j));
                }

                l.add(1);
                list.add(l);
            }

            return list;
        }
    }
}
