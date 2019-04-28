package codeforce;

import java.util.Arrays;
import java.util.Scanner;

public class RestoringThreeNumbers {
    public static void main(String []args){
        int []num = new int[4];
        Scanner in = new Scanner(System.in);
        num[0] = in.nextInt();
        num[1] = in.nextInt();
        num[2] = in.nextInt();
        num[3] = in.nextInt();
        Arrays.sort(num);
        System.out.println(String.valueOf(num[3]-num[0]) + " " + String.valueOf(num[3]-num[1]) + " "+ String.valueOf(num[3]-num[2]));
    }
}
