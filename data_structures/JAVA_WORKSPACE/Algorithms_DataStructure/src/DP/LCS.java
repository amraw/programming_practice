package DP;

import java.util.Arrays;

public class LCS {
	
	public static void main(String []args){
		String S1 = "AGGTAB";
		String S2 = "GXTXAYB";
		LCS l = new LCS();
		System.out.println(""+l.LCS(S1, S2, S1.length()-1, S2.length()-1));
		System.out.println("DP solution");
		System.out.println(""+l.LCS_DP_SOL(S1, S2, S1.length(), S2.length()));
	}
	
	public int LCS(String A, String B, int size1, int size2)
	{
		if(size1 < 0 || size2<0)
			return 0;
		else if( A.charAt(size1) == B.charAt(size2))
		{
			return 1+LCS(A,B, size1-1, size2-1);
		}
		else
			return Math.max(LCS(A,B, size1-1, size2), LCS(A,B, size1, size2-1));
	}
	
	public int LCS_DP_SOL(String A, String B, int size1, int size2)
	{
		int [][]lcs = new int [size1+1][size2+1];
		Arrays.fill(lcs[0], 0);
		for(int i=1; i<size1+1; i++)
		{
			for(int j=1; j<size2+1; j++)
			{
				if(A.charAt(i-1) == B.charAt(j-1))
				{
					lcs[i][j] = lcs[i-1][j-1] +1;
				}
				else
				{
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
		
		
		return lcs[size1][size2];
	}

}
