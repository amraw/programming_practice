import java.util.*;

public class increasingPower implements Comparable<increasingPower>{
	long val;
	long root;
	long mantisa;
	public increasingPower(long root, long mantisa)
	{
		this.root = root;
		this.mantisa = mantisa;
		val = (long) Math.pow(root, mantisa);
	}
	@Override
	public int compareTo(increasingPower p)
	{
		return (this.val - p.val) > 0 ? 1: (this.val - p.val) < 0? -1: 0;
	}
	
	public static void main(String []args)
	{
		PriorityQueue<increasingPower> queue = new PriorityQueue<increasingPower>();
		HashSet<Long> found = new HashSet<Long>();
		int x = 2;
	    for(int power = x; power<=62; power++)
	    	queue.add(new increasingPower(x,power));
	    while(!queue.isEmpty())
	    {
	    	increasingPower top = queue.poll();
	    	if(!found.contains(top.val))
	    	{
	    		found.add(top.val);
	    		System.out.println(top.val);
	    	}
	    	
	    	if(Math.pow(top.root+1, top.mantisa) < Long.MAX_VALUE)
	    		queue.add(new increasingPower(top.root+1, top.mantisa));
	    }
	}
}
