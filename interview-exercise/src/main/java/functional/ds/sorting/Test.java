package functional.ds.sorting;

public class Test {
    public static void main(String[] args) {
        int[] a = {55, 9, 8, 7, 3, 3, 1, 0};

            for (int j=0;j< a.length-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    j = -1;
                }

        }
        print(a);
    }
    static void print(int[] a){
        for (int i=0;i< a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
