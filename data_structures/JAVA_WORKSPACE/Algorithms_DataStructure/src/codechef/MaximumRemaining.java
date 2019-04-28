package codechef;

import java.util.Scanner;

public class MaximumRemaining {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int secondMax = 0;
        int maxNumber = 0;
        for(int i=0; i < n; i++){
            int num = in.nextInt();
            if(num > maxNumber){
                secondMax = maxNumber;
                maxNumber = num;
            }
            else if(num != maxNumber && num > secondMax){
                secondMax = num;
            }
        }
        System.out.println(secondMax);
    }
}
