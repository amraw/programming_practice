package codeforce;

import java.util.Scanner;

public class Detective_Book {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []array = new int[n];
        for(int i=0; i < n; i++){
            array[i] = in.nextInt();
        }
        int days = 0;
        int max = 1;
        for(int i=0;i < n; i++){
            if(array[i] == max && i+1 == max){
                days++;
                max = array[i]+1;
            }
            else
            {
                max = Math.max(array[i], max);
            }
        }
        System.out.println(days);
    }
}
