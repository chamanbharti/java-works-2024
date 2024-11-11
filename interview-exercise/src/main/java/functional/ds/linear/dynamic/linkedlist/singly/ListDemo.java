package functional.ds.linear.dynamic.linkedlist.singly;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        //2 --> 4 --> 3 --> 5 --> 7 --> null
        List list =new ArrayList<>();
        list.add(2);list.add(4);list.add(3);list.add(5);list.add(7);
        System.out.println(list.get(1));
    }
}
