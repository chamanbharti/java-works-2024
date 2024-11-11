package functional.ds.linear.dynamic.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinarNumber {

    /* Generate Binary Numbers from 1 to n using a Queue.
    input: n=3
                       1    2    3
    output: result = {"1","10","11"}

    input: n=5
                       1    2    3    4     5
    output: result = {"1","10","11","100","101"}
                       1
                      / \
     */
    private static String[] generateBinaryNumber(int n){
        String[] result = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for(int i=0;i<n;i++){
            result[i] = queue.poll();
            String n1 = result[i]+"0";
            String n2 = result[i]+"1";
            queue.offer(n1);
            queue.offer(n2);
        }
        return result;
    }
}
