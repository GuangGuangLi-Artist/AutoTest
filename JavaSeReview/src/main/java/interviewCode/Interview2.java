package interviewCode;

import java.util.*;

public class Interview2 {

    /**
     * @param args
     */

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("B");
        list1.add("A");
        list1.add("A");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("D");
        list2.add("C");
        list2.add("C");

        List<ArrayList> lists = quchong(list1, list2);
        System.out.println(Arrays.toString(lists.toArray()));


    }

    public static List<ArrayList> quchong(ArrayList list1, ArrayList list2) {

        ArrayList res = new ArrayList();
        list1.stream().sorted();
        list2.stream().sorted();
        Set<String> setres1 = new TreeSet<>(list1);
        Set<String> setres2 = new TreeSet<>(list2);
        setres1.addAll(setres2);
        for (String s : setres1) {
            res.add(s);
        }


        return res;

    }
}
