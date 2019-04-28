package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHNUM {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(bf.readLine());
            int []array = new int[n];
            String []input = bf.readLine().split(" ");
            int positiveCount = 0;
            int negativeCount = 0;
            int zeroCount = 0;
            for(int i=0; i < n; i++){
                array[i] = Integer.parseInt(input[i]);
                if(array[i] > 0) positiveCount++;
                if(array[i]< 0) negativeCount++;
                if(array[i] == 0) zeroCount++;
            }
            int maxCount = 0;
            int minCount = 0;
            if(positiveCount == 0){
                maxCount = negativeCount + zeroCount;
                minCount = negativeCount + zeroCount;
            }
            else if(negativeCount == 0){
                maxCount = positiveCount + zeroCount;
                minCount = positiveCount + zeroCount;
            }
            else
            {
                if(positiveCount < negativeCount){
                    maxCount = negativeCount + zeroCount;
                    minCount = positiveCount;
                }
                else
                {
                    maxCount = positiveCount +zeroCount;
                    minCount = negativeCount;
                }
            }
            //int minCount = (negativeCount == 0 || negativeCount<positiveCount) ? positiveCount: negativeCount;
            System.out.print(minCount+" "+maxCount);
        }
    }
}
