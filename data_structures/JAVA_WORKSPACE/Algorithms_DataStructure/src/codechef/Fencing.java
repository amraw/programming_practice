package codechef;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Fencing {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            long [][] index = new long[k][2];
            Set<String> allIndex = new HashSet<>();
            long fence = 0;
            for(int i=0; i < k; i++){
                int row = in.nextInt();
                int col = in.nextInt();
                index[i][0] = row;
                index[i][1] = col;
                allIndex.add(index[i][0]+" "+index[i][1]);
            }
            for(int i=0; i < k; i++){
                fence += 4;
                if( allIndex.contains((index[i][0]+1)+" "+index[i][1]))
                {
                    fence--;
                }
                if(allIndex.contains((index[i][0]-1)+" "+index[i][1]))
                {
                    fence--;
                }
                if(allIndex.contains(index[i][0]+" "+ (index[i][1]-1)))
                {
                    fence--;
                }
                if(allIndex.contains(index[i][0]+" "+(index[i][1]+1)))
                {
                    fence--;
                }
            }
            System.out.println(fence);
            t--;
        }
    }

}
