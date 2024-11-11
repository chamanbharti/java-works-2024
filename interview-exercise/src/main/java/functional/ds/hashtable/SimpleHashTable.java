package functional.ds.hashtable;

import functional.ds.linear.dynamic.stack.Employee;

public class SimpleHashTable {
    private Employee[] hashtable;
    public SimpleHashTable(){
        hashtable = new Employee[10];
    }
    private int hashKey(String key){
        return key.length() % hashtable.length;
    }
    private boolean occupied(int index){
        return hashtable[index] != null;
    }
    public void put(String key,Employee employee){
        int hashKey = hashKey(key);
        if(occupied(hashKey)){
            int stopIndex = hashKey;
            if(hashKey == hashtable.length - 1){
                hashKey = 0;
            }else {
                hashKey++;
            }
            while (occupied(hashKey) && hashKey != stopIndex){
                hashKey = (hashKey+1) % hashtable.length;
            }
        }
//        if (hashtable[hashKey] != null){
        if (occupied(hashKey)){
            System.out.println("Sorry, there's already an employee at position:"+hashKey);
        }else {
            hashtable[hashKey] = employee;
        }
    }
    public Employee get(String key){
        int hashKey = hashKey(key);
        return hashtable[hashKey];
    }
    public void printHashtable(){
        for(int i=0;i<hashtable.length;i++){
            System.out.println(hashtable[i]);
        }
    }

    public static void main(String[] args) {
        SimpleHashTable ht = new SimpleHashTable();
        ht.put("a",new Employee("Rahi","Akela",123));
        ht.put("bb",new Employee("Saima","Rahi",1234));
        ht.put("ccc",new Employee("Chaman","Bharti",125));
        ht.put("dddd",new Employee("Roshan","Parveen",126));
        ht.put("eeeee",new Employee("Sahil","Bharti",127));
        ht.put("eeeee",new Employee("Sahil","Bharti",127));
        ht.printHashtable();
        System.out.println(ht.get("eeeee"));;
    }
}
