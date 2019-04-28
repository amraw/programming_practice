package codeforce;

import java.util.Scanner;

public class The_Doors {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []input = new int[n];
        int left = 0;
        int right = 0;
        for(int i=0; i < n; i++){
            input[i] = in.nextInt();
            if(input[i] == 0){
                left++;
            }
            else
            {
                right++;
            }
        }
        int k;
        for(k = 1; k <=n; k++){
            if(input[k-1] == 0){
                left--;
            }
            else
            {
                right--;
            }
            if(left == 0 || right ==0) break;
        }
        System.out.println(k);
    }
}
