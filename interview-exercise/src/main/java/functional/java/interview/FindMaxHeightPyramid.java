package functional.java.interview;

import java.util.Arrays;

public class FindMaxHeightPyramid {
    public static void main(String[] args) {

        int []boxes = {10, 20, 30, 50, 60, 70};
        int n = boxes.length;
        System.out.println(maxLevel(boxes, n));
    }
    private static int maxLevel(int[] arr,int n){
        Arrays.sort(arr);
        int ans = 1;
        int preWidth = arr[0];
        int prevCount = 1;

        int currWidth = 0;
        int currCount = 0;

        for (int i=1;i<n;i++){
            currWidth = currWidth+arr[i];
            currCount = currCount+1;
            if(currWidth > preWidth && currCount > prevCount){
                // Update previous width,number of object on previous level.
                preWidth = currWidth;
                prevCount = currCount;

                //  Reset width of current level, number of object on current level.
                currWidth = 0;
                currCount = 0;
                // Increment number of level.
                ans++;
            }
        }
        return ans;
    }
}
