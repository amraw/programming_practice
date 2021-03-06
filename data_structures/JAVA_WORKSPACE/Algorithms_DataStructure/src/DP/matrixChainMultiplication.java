package DP;

public class matrixChainMultiplication {
	
public static int matrixMultiplicationRecur(int []p, int i, int j)
{
	int k;
	int min = Integer.MAX_VALUE;
	if(i==j)
		return 0;
	
	for(k=i; k<j; k++)
	{
		int multiplyCount = matrixMultiplicationRecur(p,i,k)+matrixMultiplicationRecur(p,k+1,j)+ p[i-1]*p[k]*p[j];
			if(multiplyCount < min)
				min = multiplyCount;
	}
	
	return min;
}

public static void main(String []args)
{
	int arr[] = new int[]{1,2,3,4};
	System.out.println("Matrix chain multiplication: "+matrixMultiplicationRecur(arr,1,arr.length-1));
	

}

}
