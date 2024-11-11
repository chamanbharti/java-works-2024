package functional.java.interview;

import java.util.Arrays;

public class FindAlternativeSort {
    public static void main(String[] args) {
       // int arr[] = {5, 3, 7, 1, 6, 0, 8, 9};
        //Sorted:   {0, 1, 3, 5, 6, 7, 8, 9}
        // output: 9 0 8 1 7 3 6 5

        int arr[] = {-5, -3, 7, -2, 8, 0, -4, 0};
        // output:  {8, -5, 7, -4, 0, -3, 0, -2}
        arr = new int[]{1, 4, 5, 8, 3, 2, 6, 9, 7};
        Arrays.sort(arr);
        rearrangeList(arr, arr.length);

    }
    private static void rearrangeList(int[] arr,int n){
        int i=0,j= n-1;
        while (i<j){
            System.out.print(arr[j--]+" ");
            System.out.print(arr[i++]+" ");
        }
        if(n%2 !=0){
            System.out.print(arr[i]);
        }
    }
}
