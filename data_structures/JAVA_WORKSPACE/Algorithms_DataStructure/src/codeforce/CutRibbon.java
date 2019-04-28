//package codeforce;

import java.util.Arrays;
import java.util.Scanner;

public class CutRibbon {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []size = new int[3];
        size[0] = in.nextInt();
        size[1] = in.nextInt();
        size[2] = in.nextInt();
        //Arrays.sort(size);
        long dp[] = new long[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        long x, y, z;
        for(int j=1; j <=n; j++){
            x = -1;
            y = -1;
            z = -1;
            if(size[0] <= j){
                x = dp[j-size[0]];
            }
            if(size[1] <= j){
                y = dp[j - size[1]];
            }
            if(size[2] <= j){
                z = dp[j - size[2]];
            }
            if(x == -1 && y == -1 && z == -1){
                dp[j] = -1;
            }
            else
            {
                dp[j] = Math.max(Math.max(x,y), z) + 1;
            }
        }

        System.out.println(dp[n]);
    }
}
