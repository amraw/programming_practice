//package codeforce;

import java.util.Scanner;

public class DiverseStrings {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n > 0){
            String input = in.next();
            int []charCount = new int[26];
            for(int i=0; i < input.length(); i++){
                charCount[input.charAt(i)-'a']++;
            }
            int lastChar = -1;
            boolean isDiverse = true;
            for(int i=0; i < 26; i++){
                if(charCount[i]>1 || (charCount[i] == 1 && lastChar!=-1 && lastChar+1 != i))
                {
                    isDiverse = false;
                    break;
                }
                if(charCount[i] == 1){
                    lastChar = i;
                }
            }
            if(isDiverse){
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
            n--;
        }
    }
}
