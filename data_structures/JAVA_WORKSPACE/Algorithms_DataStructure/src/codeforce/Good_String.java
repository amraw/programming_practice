package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Good_String {
    public static void main(String []args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        while(t > 0){
            int n = Integer.parseInt(bf.readLine());
            String input = bf.readLine();
            int deletion = getDeletion(input);
            System.out.println(deletion);
            t--;
        }

    }
    public static int getDeletion(String input){
        Stack<Character> stk = new Stack<>();
        /*StringBuilder sb = new StringBuilder();
        for(int i=0; i < input.length(); i++){
            if(i == 0){
                sb.append(input.charAt(i));
            }
            else if( input.charAt(i) != input.charAt(i-1)){
                sb.append(input.charAt(i));
            }
        }
        input = sb.toString();*/
        for(int i=0 ; i < input.length(); i++){
            while(!stk.isEmpty() && input.charAt(i) == '<'){
                stk.pop();
            }
            stk.push(input.charAt(i));
        }
        if(stk.size() == 1) return 0;

        Stack<Character> stk2 = new Stack<>();
        for(int i=input.length()-1 ; i >= 0; i--){
            while(!stk2.isEmpty() && input.charAt(i) == '>'){
                stk2.pop();
            }
            stk2.push(input.charAt(i));
        }
        if(stk2.size() == 1) return 0;
        return Math.min(stk.size()-1, stk2.size()-1);
    }
}
