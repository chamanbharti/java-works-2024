package functional.ds.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] ={55, 9, 8, 7, 3, 3, 1, 0};

        System.out.println("Array Before bubbleSort_ascending_order");
        printData(arr);
        System.out.println();

        SortingAlgorithm.bubbleSort_ascending_order1(arr);

        System.out.println("Array After bubbleSort_ascending_order");
        printData(arr);

        SortingAlgorithm.bubbleSort_optimized_descending_order(arr);

        System.out.println("Array After bubbleSort_descending_order");
        printData(arr);

    }

    private static void printData(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
