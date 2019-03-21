package codeforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Nastya_reading_book {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [][]book = new int[n][2];
        for(int i=0; i<n; i++){
            book[i][0] = in.nextInt();
            book[i][1] = in.nextInt();
        }
        int currPage = in.nextInt();
        int index = 0;
        while(index < n){
            if(currPage <= book[index][1]) break;
            index++;
        }
        System.out.println(n-index);
    }
}
