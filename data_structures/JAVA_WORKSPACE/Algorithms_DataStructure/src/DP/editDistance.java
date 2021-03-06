package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class editDistance {
public static int editDistanceCalculate(String str1, String str2, int size1, int size2){
	if(size1== 0)
		return size2;
	else if(size2==0)
		return size1;
	else if(str1.charAt(size1-1) == str2.charAt(size2-1))
		return editDistanceCalculate(str1,str2,size1-1, size2-1);
	else 
	{
		return 1+editDistance.min(editDistanceCalculate(str1,str2,size1,size2-1), editDistanceCalculate(str1,str2,size1-1,size2-1), editDistanceCalculate(str1,str2,size1-1, size2));
	}
}
public static int min(int a, int b, int c)
{
	return Math.min(Math.min(a, b), c);
}		

public static int editDistanceCalculateDynamicSoluction(String str1, String str2, int size1,int size2){
	int editDistanceCalculate[][] = new int[size1+1][size2+1];
	editDistanceCalculate[0][0] = 0;
	for(int i=1; i< size1+1; i++)
		editDistanceCalculate[i][0] = i;
	for( int i=1; i< size2+1; i++)
		editDistanceCalculate[0][i] = i;
	for(int i=1; i<size1+1; i++)
	{
		for(int j=1; j<size2+1; j++)
		{
			if(str1.charAt(i-1) == str2.charAt(j-1))
				editDistanceCalculate[i][j] = editDistanceCalculate[i-1][j-1];
			else
				editDistanceCalculate[i][j] = 1+editDistance.min(editDistanceCalculate[i-1][j], editDistanceCalculate[i][j-1],editDistanceCalculate[i-1][j-1]);
		}
	}
	return editDistanceCalculate[size1][size2];
	
}

public static void main(String []args)
{
	String str1 = "sunday";
	String str2 = "saturday";
	System.out.println("Result: "+editDistanceCalculate(str1,str2,str1.length(),str2.length()));
	System.out.println("DP Result: "+editDistanceCalculateDynamicSoluction(str1,str2,str1.length(),str2.length()));
	
}


}
