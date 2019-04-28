//package codeforce;

import java.util.Arrays;
import java.util.Scanner;

public class InterestingDrink {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []arr = new int[100001];
        for(int i=0; i < n; i++){
            arr[in.nextInt()]++;
        }

        for(int i=1; i < 100001; i++){
            arr[i] = arr[i] + arr[i-1];
        }
        //Arrays.sort(arr);  Method 1
        int q = in.nextInt();
        while(q >  0){
            int m = in.nextInt();
            int result = 0;
            if(m > 100000){
                result = arr[100000];
            }
            else
            {
                result = arr[m];
            }
            System.out.println(result);
            q--;
        }
    }

    public static int binarySearch(int []arr, int target){
        int start = 0;
        int end = arr.length;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > target){
                end = mid;
            }
            else
            {
                start = mid + 1;
            }
        }
        return start - 1;
    }
}
