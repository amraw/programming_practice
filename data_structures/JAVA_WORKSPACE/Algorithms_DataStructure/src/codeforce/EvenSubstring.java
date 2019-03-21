package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenSubstring {
    public static void main(String []args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String input = bf.readLine();
        int result = 0;
        for(int i=0; i < input.length(); i++){
            int num = input.charAt(i) - '0';
            if(num % 2 == 0){
                result += i + 1;
            }
        }
        System.out.println(result);
    }
}
