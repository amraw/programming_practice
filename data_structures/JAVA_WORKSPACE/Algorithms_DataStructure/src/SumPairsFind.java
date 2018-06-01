import java.util.*;
public class SumPairsFind {
	
	public static void main (String[] args) {
		int[] test1 = {6,6,3,9,3,5,1};

		System.out.println(numberOfPairs(test1, 12));
	}
	
	public static int numberOfPairs(int[]test, int k)
	{
		int res = 0;
		HashSet<Integer> found = new HashSet<Integer>();
		HashSet<Integer> element = new HashSet<Integer>();
		for(int i=0; i < test.length; i++)
			element.add(test[i]);
		for (int i = 0; i < test.length; i++) {
			if (test[i] <= k / 2 && !found.contains(test[i])) {
				found.add(test[i]);
				if (element.contains((int)(k - test[i]))) res++;
			}
		}
		return res;
		
	}
}
