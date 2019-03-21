//package codeforce;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NewYearTransport {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        //Set<Integer> possible = new HashSet<>();
        int next = 1;
        //possible.add(next);
        boolean isFound = false;
        for(int i=1; i <= n-1; i++){
            if(next == i){
                next = i + in.nextInt();
                if(next == t){
                    System.out.println("YES");
                    isFound = true;
                    //break;
                }
            }
            else
            {
                in.nextInt();
            }
        }
        if(!isFound){
            System.out.println("NO");
        }

    }
}
