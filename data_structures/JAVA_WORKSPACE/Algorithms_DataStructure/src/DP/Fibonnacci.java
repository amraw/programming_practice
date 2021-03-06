package DP;

public class Fibonnacci {
public static int fibonnacciRecursive(int N)
{
	if(N<=1)
		return N;
	else
		return fibonnacciRecursive(N-1)+fibonnacciRecursive(N-2);
}

public static int DynamicSoution1(int N)
{
	int result[] = new int[N+1];
	if(N<=1)
		return N;
	else
	{
		result[0] = 0;
		result[1] = 1;
		for(int i=2; i<=N; i++)
			result[i] = result[i-1]+result[i-2];
	}
	return result[N];
}

public static int DPSpaceOptimized(int N)
{
	int result = 0;
	if(N<=1)
		return N;
	else
	{
		int secondLast = 0;
		int firstLast = 1;
		for(int i=2; i<=N; i++)
		{
			result = firstLast + secondLast;
			secondLast = firstLast;
			firstLast = result;
		}
	}
	return result;
}

public static void main(String []args)
{
	int N = 9;
	System.out.println("Fibonnacci Recursion Answer:"+fibonnacciRecursive(N));
	System.out.println("Fibonnacci Dynamic Solution1:"+DynamicSoution1(N));
	System.out.println("Fibonnacci Dynamic Solution with Space Optimization:"+DPSpaceOptimized(N));
}

}
