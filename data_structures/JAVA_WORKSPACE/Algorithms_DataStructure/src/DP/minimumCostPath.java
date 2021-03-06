package DP;

public class minimumCostPath {
public int minCostPath(int [][]cost, int i, int j, int m, int n)
{
	if(i== m && i == n)
		return cost[m][n];
	else if(i>m || j >n)
		return Integer.MAX_VALUE;
	else
		return cost[i][j]+min(minCostPath(cost,i+1,j,m,n),minCostPath(cost,i,j+1,m,n),minCostPath(cost,i+1,j+1,m,n));
}

public int minCostPahtDP(int [][]cost, int m, int n)
{
	int result[][] = new int[m+1][n+1];
	
	result[0][0] = cost[0][0];
	for(int i=1; i<=n; i++)
		result[0][i] = result[0][i-1]+cost[0][i];
	for(int i=1; i<=n; i++)
		result[i][0] = result[i-1][0]+cost[i][0];
	
	for(int i=1; i<=m; i++)
	{
		for(int j=1; j<=n; j++)
		{
			result[i][j] = cost[i][j]+min(result[i-1][j], result[i][j-1], result[i-1][j-1]);
		}
	}
	return result[m][n];
}

public int min(int a, int b, int c)
{
	return Math.min(Math.min(a, b), c); 
}

public static void main(String []args)
{
	int cost[][] = new int[][]{{1,2,3},{4,8,2},{1,5,3}};
	minimumCostPath t = new minimumCostPath();
	System.out.println("Min Cost:"+t.minCostPath(cost, 0, 0, 2, 2));
	System.out.println("DP Solution: " + t.minCostPahtDP(cost, 2, 2));
}

}
