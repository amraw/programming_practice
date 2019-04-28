package codechef;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FriendOrGirlfriend {
    public static void main(String []args) throws java.lang.Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while(t > 0){
            int n = Integer.parseInt(bf.readLine());
            String input = bf.readLine();
            String str[] = input.split(" ");
            long maxString = 0;
            long leftCount = 0;
            for(int i=0; i < n; i++)
            {
                if(str[0].charAt(i) == str[1].charAt(0)){
                    maxString += i+1;
                    leftCount = i+1;
                }
                else
                {
                    maxString += leftCount;
                }
            }
            System.out.println(maxString);
            t--;
        }
    }
}
