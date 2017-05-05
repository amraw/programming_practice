package tree;

public class printNodeKDistance {
	public node root;

	public printNodeKDistance(int data) {
		root = new node(data);
	}

	public void printNodeAtDistanceK(node root, int k) {
		if (root == null) {
			return;
		} else if (k==1) {
			System.out.print(root.data + " ");
		} else {
			printNodeAtDistanceK(root.left,  k-1);
			printNodeAtDistanceK(root.right,  k-1);
		}
	}

	public static void main(String[] args) {
		printNodeKDistance t = new printNodeKDistance(1);
		t.root.left = new node(2);
		t.root.right = new node(3);
		t.root.left.right = new node(4);
		t.root.left.left = new node(6);
		t.root.right.left = new node(5);
		t.root.right.right = new node(7);
		t.printNodeAtDistanceK(t.root, 3);
	}

}