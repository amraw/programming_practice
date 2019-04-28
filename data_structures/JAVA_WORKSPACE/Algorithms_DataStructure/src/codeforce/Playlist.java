//package codeforce;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Playlist {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long [][] songs = new long[n][2];
        for(int i=0; i < n; i++){
            songs[i][0] = in.nextLong();
            songs[i][1] = in.nextLong();
            //songs[i][2] = songs[i][0] * songs[i][1];
        }
        Arrays.sort(songs, (a,b)-> Long.compare(b[1],a[1]));
        long maxResult = 0;
        long sum = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i < songs.length; i++){
            sum += songs[i][0];
            pq.offer(songs[i][0]);
            if(pq.size() > k){
                sum -= pq.poll();
            }
            maxResult = Math.max(maxResult, sum * songs[i][1]);
        }
        System.out.println(maxResult);
    }
}
