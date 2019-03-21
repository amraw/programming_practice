//package codeforce;

import java.util.Scanner;

public class MaximalContinuousRest {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = 0;
        int start = 0;
        int []array = new int[2 * n];
        for(int i=0; i <n; i++){
            array[i] = in.nextInt();
            array[i+n] = array[i];
        }
        for(int i=0; i <2 * n; i++){
            if(array[i] == 0){
                start = i+1;
            }
            else
            {
                result = Math.max(result, i-start+1);
            }
        }
        System.out.println(result);
    }
}
