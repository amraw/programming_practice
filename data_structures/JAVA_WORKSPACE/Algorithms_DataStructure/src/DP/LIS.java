package DP;
import java.util.*;
import java.io.*;
public class LIS {
	
public static int  max_subsequence;
public static void main (String args[])
{
	int array[] = {10,22,9,33,21,50,41,60,80};
	//int array[] = {9,19};
	//PrintWriter writer = new PrintWriter(System.out);
	LIS lis = new LIS();
	System.out.println(""+lis.recursiveLis(array));
	System.out.println("Second function");
	System.out.println(""+lis.lisDPSolution(array));
	System.out.println("Third function");
	LIS.recursiveLis2(array);
	System.out.println(""+LIS.max_subsequence);
}
public int recursiveLis(int []array)
{
	if(array != null)
	{
		int result = 0;
		int max = 0;
		for(int i = array.length-1; i>0; i--)
		{
			result = recursiveLisUtil(array,i, i-1);
			if(result> max)
				max = result;
		}
		return max+1;
	}
	return 0;
}

public int recursiveLisUtil(int []array, int last, int index)
{
	if(array == null || last<0 || index<0)
		return 0;
	if(last >0 && index>=0)
	{
		if(array[last] >= array[index])
		{
			return Math.max(1+recursiveLisUtil(array,index,index-1), recursiveLisUtil(array,last,index-1));
		}
		else
			return recursiveLisUtil(array,last,index-1);
	}
	
	return 1;
}

public static void recursiveLis2(int []array)
{
	recursiveLis2Util(array, array.length);
}

public static int recursiveLis2Util(int []array, int n){
	if(n==1)
		return 1;
	int current_subsequence_list=1;
	for(int i=0; i<n-1; i++)
	{
		int subsequence_lis = recursiveLis2Util(array,i+1);
		if(array[i] < array[n-1] && current_subsequence_list< (1+subsequence_lis))
			current_subsequence_list = 1 + subsequence_lis;
		if(max_subsequence<current_subsequence_list)
			max_subsequence = current_subsequence_list;
	}
	
	return current_subsequence_list;
}

public int lisDPSolution(int []array)
{
	
	if(array!=null){
		int []lis = new int[array.length];
		Arrays.fill(lis, 1);
		for(int i = 1; i<array.length; i++)
		{
			int j = i-1;
			while(j>=0)
			{
				if(array[i] > array[j])
				{
					if(lis[i]< lis[j]+1)
						lis[i]=lis[j]+1;
				}
				j--;
			}
		}
		return findMax(lis);
	}
	
	return 0;
}

public int findMax(int []array)
{
	int max = Integer.MIN_VALUE;
	for(int i=0; i<array.length; i++)
	{
		if(max < array[i])
			max = array[i];
	}
	return max;
}

}
