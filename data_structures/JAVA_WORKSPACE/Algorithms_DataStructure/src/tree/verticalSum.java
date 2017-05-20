package tree;
import java.util.*;
public class verticalSum {
public node root;
public verticalSum(int data){
	root = new node(data);
}
public void calcualteVerticalSum(node root)
{
	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	calcualteVerticalSumUtil(root,0,map);
	if(!map.isEmpty()){
		System.out.print(""+map.values());
	}
}

public void calcualteVerticalSumUtil(node root,int hd,HashMap map){
	if(root==null)
		return;
	else
	{
		if(!map.containsKey(hd)){
			map.put(hd,root.data);
		}
		else
		{
			map.put(hd, (int)map.get(hd)+root.data);
		}
		calcualteVerticalSumUtil(root.left,hd-1,map);
		calcualteVerticalSumUtil(root.right,hd+1,map);
	}
}

public static void main(String []args){
	verticalSum t = new verticalSum(1);
	t.root.left = new node(2);
	t.root.right = new node(3);
	t.root.left.left = new node(4);
	t.root.left.right = new node(5);
	t.root.right.left = new node(6);
	t.root.right.right = new node(7);
	t.calcualteVerticalSum(t.root);
}

}
