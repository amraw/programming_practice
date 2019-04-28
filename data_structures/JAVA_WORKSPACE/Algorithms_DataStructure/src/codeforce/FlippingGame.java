//package codeforce;

import java.util.Scanner;

public class FlippingGame {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []arr = new int[n];
        int oneCount = 0;
        //int zeroToOneCount = 0;
        //int maxZeroToOneCount = 0;
        //Method 1
        for(int i=0; i < n; i++){
            int num = in.nextInt();
            if(num == 1) oneCount++;
            arr[i] = num == 1? -1 : 1;
        }

        int maxSum = arr[0];
        int sum = arr[0];
        for(int i=1; i < n; i++){
            sum = Math.max(sum+arr[i], arr[i]);
            maxSum = Math.max(maxSum, sum);
        }

        /*for(int i=0; i < n; i++){
            int num = in.nextInt();
            if(num == 1){
                oneCount++;
                if(zeroToOneCount > 0){
                    zeroToOneCount--;
                }
            }
            else
            {
                zeroToOneCount++;
                maxZeroToOneCount = Math.max(maxZeroToOneCount, zeroToOneCount);
            }
        }*/
        System.out.println(oneCount+maxSum);
    }
}
