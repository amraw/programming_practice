package DP;

import java.util.Arrays;

public class coinChange {
public static int findCoinChange(int coinValue[], int n, int size){
	int result = 0;
	if(n < 0)
		return 0;
	else if(n == 0)
		return 1;
	else if(n!=0 && size<0)
		return 0;
	else
	{
		return findCoinChange(coinValue,n-coinValue[size], size)+findCoinChange(coinValue,n, size-1);
	}
}

public static int findCoinChangeDP(int coinValue[], int n, int size){
	int [][]coinChange = new int[coinValue.length+1][n+1];
	for(int i=0; i<coinValue.length+1; i++)
		coinChange[i][0] = 1;
	for(int i=0; i<=n; i++)
		coinChange[0][i] = 0;
	for(int i=1; i<=coinValue.length ; i++)
	{
		for(int j=1; j<=n; j++)
		{
			if(coinValue[i-1]<=j)
			{
					coinChange[i][j] = coinChange[i][j-coinValue[i-1]]+coinChange[i-1][j];
			}
			else
			{
				coinChange[i][j] = coinChange[i-1][j];
			}
		}
	}
	return coinChange[coinValue.length][n];
}

// Optimized DP solution
public static int findCoinChangeDPOP(int coinValue[], int n, int size){
int table[] = new int[n+1];
Arrays.fill(table, 0);
table[0] = 1;
for(int i=0; i<size; i++)
{
	for(int j=coinValue[i]; j<=n; j++)
		table[j]+=table[j-coinValue[i]];
}
return table[n];
}



public int max(int a, int b, int c)
{
	return Math.max((Math.max(a,b)),c);
}

public static void main(String []args)
{
	int coinValue[] = new int[]{1,2,3};
	System.out.println("Coin Change Values: "+findCoinChange(coinValue,4,coinValue.length-1));
	System.out.println("Coin change DP solution: "+findCoinChangeDP(coinValue, 4, coinValue.length));
	System.out.println("Coin change DP solution: "+findCoinChangeDPOP(coinValue, 4, coinValue.length));
}
}
