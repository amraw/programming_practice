package codeforce;

import java.util.Scanner;

public class MinimumTriangulation {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = 0;
        for(int i= 1 ; i <= n - 2; i++){
            result += (i+1)* (i+2);
        }
        System.out.println(result);
    }
}
