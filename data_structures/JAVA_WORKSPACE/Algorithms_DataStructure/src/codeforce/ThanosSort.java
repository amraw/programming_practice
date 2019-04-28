package codeforce;

import java.util.Scanner;

public class ThanosSort {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int start = 0;
        int length = Math.min(n, 1);
        if(n > 1){
            int prev = in.nextInt();
            for(int i=1; i < n; i++){
                int next = in.nextInt();
                if(next >= prev){
                    length = Math.max(length, i-start+1);
                }
                else
                {
                    start = i;
                }
                prev = next;
            }
        }
        System.out.println(length);
    }
}
