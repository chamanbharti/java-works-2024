package functional.ds.sorting;

//https://www.programiz.com/dsa/bubble-sort
// https://www.softwaretestinghelp.com/bubble-sort-java/
public class SortingAlgorithm {

    static void bubbleSort_ascending_order1(int[] arr) {
        int temp;
        for(int i=arr.length - 1; i>0; i--){
            for(int j=0; j < i; j++){
                if(arr[j] > arr[j+1]){//descending order
                    //swap elements
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    static void bubbleSort_ascending_order(int[] arr) {
        int n = arr.length;
        int temp;
        for(int i=0; i < n; i++){
            for(int j=0; j < (n-i-1); j++){
                if(arr[j] > arr[j+1]){//ascending order
                    //swap elements
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static void bubbleSort_descending_order(int[] arr) {
        int n = arr.length;
        int temp;
        for(int i=0; i < n; i++){
            for(int j=0; j < (n-i-1); j++){
                if(arr[j] < arr[j+1]){//descending order
                    //swap elements
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static void bubbleSort_optimized_descending_order(int[] arr) {

        int n = arr.length;
        int temp;
        boolean swapped;
        for (int i=0;i<n;i++){
            // check if swapping occurs
            swapped = false;
            // loop to compare adjacent elements
            for (int j=0;j<n-i-1;j++){
                 if(arr[j] < arr[j+1]){
                     temp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = temp;
                     swapped = true;
                 }
            }
            // no swapping means the array is already sorted
            // so no need for further comparison
            if(!swapped)
                break;
        }
    }

    static void bubbleSort_single_loop_descending_order(int[] arr) {
        int n = arr.length;
        int temp;
        for (int j=0;j<n-1;j++){
            if(arr[j] < arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                /*
                updating the value of j = -1
                so after getting updated for j++
                in the loop it becomes 0 and
                the loop begins from the start.
                 */
                j = -1;
            }
        }

    }
}
