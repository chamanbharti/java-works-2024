package functional.java_8_FI;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIteration {

    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();  //implements map interface
        hm.put(110,"Ravi");
        hm.put(120,"Prateek");
        hm.put(130, "Davesh");
        hm.put(140, "Kamal");
        hm.put(150, "Pawan");
        System.out.println("using iterator");
        Iterator<Integer>it = hm.keySet().iterator();
        while (it.hasNext()){
            int key = it.next();
            System.out.println("Roll No:"+key+" name:"+hm.get(key));
        }

        System.out.println("using keySet and Values");
        for(Integer key:hm.keySet()){
            System.out.println("key:"+key);
        }
        for(String value:hm.values()){
            System.out.println("value:"+value);
        }

        System.out.println("using map.entry");
        for (Map.Entry<Integer,String>itr: hm.entrySet()){
            System.out.println("key:"+itr.getKey()+" value:"+itr.getValue());
        }

        System.out.println("Iteration over keys and getting values");
        for (Integer i:hm.keySet()){
            String value = hm.get(i);
            System.out.println("key:"+i+" value:"+value);
        }

        System.out.println("Using forEach() method");
        hm.forEach( (k,v) -> System.out.println("key:"+k+" value:"+v));
    }
}
