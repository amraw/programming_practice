//package codeforce;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ParityAlternatedDeletions {
    public static void main(String []args){
        PriorityQueue<Integer> odd = new PriorityQueue<>((a,b)-> b-a);
        PriorityQueue<Integer> even = new PriorityQueue<>((a,b)-> b-a);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0; i < n; i++){
            int num = in.nextInt();
            if(num % 2 == 0){
                even.offer(num);
            }
            else
            {
                odd.offer(num);
            }
        }
        int sum = 0;
        int itr = Math.min(even.size(), odd.size())+1;
        while(itr > 0){
            if(!even.isEmpty()){
                even.poll();
            }
            if(!odd.isEmpty()){
                odd.poll();
            }
            itr--;
        }
        for(int num: even){
            sum+=num;
        }
        for(int num: odd){
            sum += num;
        }
        System.out.println(sum);
    }
}
