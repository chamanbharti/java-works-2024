package functional.java_8_date_time;

import java.time.Year;
import java.util.Scanner;

public class YearDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Year Number:");
        int n = sc.nextInt();
        Year y = Year.of(n);
        if(y.isLeap()){
            System.out.printf("%d Year is Leap Year",n);
        }else{
            System.out.printf("%d Year is Not Leap Year",n);
        }
    }
}
