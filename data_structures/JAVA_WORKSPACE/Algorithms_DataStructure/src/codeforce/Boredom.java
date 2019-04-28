package codeforce;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Boredom {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        Map<Integer, Long> numFreq = new TreeMap<>();
        Map<Integer, Long> dp = new HashMap<>();
        int n = in.nextInt();
        int maxNum = 0;
        if(n > 0)
        {

            for(int i=0; i < n; i++){
                int num = in.nextInt();
                numFreq.put(num, numFreq.getOrDefault(num,0L)+1);
                maxNum = Math.max(maxNum, num);
            }
            dp.put(0,0L);
            dp.put(1, numFreq.getOrDefault(1,0L));
            for(int i=2; i <= maxNum; i++){
                dp.put(i, Math.max(dp.getOrDefault(i-1,0L) , dp.get(i-2) + numFreq.getOrDefault(i,0L) * i));
            }

        }

        System.out.println(dp.getOrDefault(maxNum,0L));
    }
}
