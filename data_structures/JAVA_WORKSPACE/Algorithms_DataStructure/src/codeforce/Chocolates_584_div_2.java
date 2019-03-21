package codeforce;

import java.util.Scanner;

public class Chocolates_584_div_2 {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long result = 0;
        int []input = new int[n];

        for(int i=0;i < n; i++){
            input[i] = in.nextInt();
        }
        int min = input[n-1];
        for(int i=n-1; i >=0; i--){
            if(i == n - 1){
                result += input[i];
            }
            else
            {
                if(input[i] < min){
                    result += input[i];
                    min = input[i];
                }
                else if( input[i] >= min){
                    result += min - 1;
                    min = min - 1;
                }
            }
            if(min == 0) break;
        }
        System.out.println(result);
    }
}
