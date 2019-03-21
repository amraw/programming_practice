//package codeforce;

import java.util.*;

public class Game23 {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Set<Integer> seen = new HashSet<>();
        Queue<CurrLevel> queue = new LinkedList<>();
        boolean found = false;
        int result = -1;
        if(n == m)
        {
            System.out.print("0");
            found = true;
        }
        else if(n < m){
            queue.offer(new CurrLevel(n,0));
            while(!queue.isEmpty()){
                CurrLevel number = queue.poll();
                //System.out.println(number.number);
                if(number.number * 2 == m || number.number * 3 == m){
                    System.out.println(number.level+1);
                    found = true;
                    break;

                }
                if(!seen.contains(number.number * 2) && (number.number*2 < m)){
                    queue.offer(new CurrLevel(number.number*2, number.level+1));
                    seen.add(number.number * 2);
                }
                if(!seen.contains(number.number * 3) && (number.number*3 < m)){
                    queue.offer(new CurrLevel(number.number * 3, number.level+1));
                    seen.add(number.number * 3);
                }

            }
        }
        if(!found)
            System.out.println("-1");
    }
}

class CurrLevel{
    int number;
    int level;
    public CurrLevel(int numb, int level){
        this.number = numb;
        this.level = level;
    }
}