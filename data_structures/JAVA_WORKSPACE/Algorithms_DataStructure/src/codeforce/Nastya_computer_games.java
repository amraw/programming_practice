package codeforce;

import java.util.Scanner;

public class Nastya_computer_games {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in = new Scanner(System.in);
        int hole = in.nextInt();
        int position = in.nextInt();
        int minCost = hole * 2;
        if(position == 1 || position == hole){
            minCost += hole - 1;
        }
        else
        {
            //int sum = 0;
            if(position-1 < hole - position){
                minCost += (position - 1) * 2 + hole - position;
            }
            else
            {
                minCost += (hole - position) * 2 + position - 1;
            }
        }
        minCost++;
        System.out.println(minCost);
    }
}
