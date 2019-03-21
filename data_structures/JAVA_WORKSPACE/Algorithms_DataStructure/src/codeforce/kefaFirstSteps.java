//package codeforce;

import java.util.Scanner;

public class kefaFirstSteps {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int index = 0;
        int start = 0;
        int prev = 0;
        int maxLength = 0;
        while(index < n){
            int curr = in.nextInt();
            if(index == 0){
                maxLength =  1;
            }
            else
            {
                if(curr < prev){

                    start = index;
                }
                else
                {
                    maxLength = Math.max(index - start + 1, maxLength);
                }
            }
            prev = curr;
            index++;
        }
        System.out.println(maxLength);
    }
}
