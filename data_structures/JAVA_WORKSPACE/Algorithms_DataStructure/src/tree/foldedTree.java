package tree;

public class foldedTree {
	public node root;

	public foldedTree(int data) {
		root = new node(data);
	}

	public boolean isFoldedTree(node root) {
		boolean result = false;
		if (root == null)
			result = true;
		else {
			mirrorTree(root.left);
			result = isFoldTreeUtil(root.left, root.right);
		}
		return result;
	}

	private void mirrorTree(node root) {
		if (root == null)
			return;
		else {
			mirrorTree(root.left);
			mirrorTree(root.right);
			node tmp = root.left;
			root.left = root.right;
			root.right = tmp;
		}
	}

	public boolean isFoldedTree2(node root) {
		boolean result = false;
		if (root == null) {
			result = true;
		} else {
			result = isFoldTreeUtil2(root.left, root.right);
		}
		return result;
	}

	public boolean isFoldTreeUtil(node left, node right) {
		boolean result = false;
		if ((right == null && left == null)) {
			return true;
		} else {
			result = (left != null && right != null) && isFoldTreeUtil(left.left, right.left)
					&& isFoldTreeUtil(left.right, right.right);
		}
		return result;
	}

	public boolean isFoldTreeUtil2(node n1, node n2) {
		boolean result = false;
		if (n1 == null && n2 == null) {
			result = true;
		} else if (n1 == null || n2 == null) {
			result = false;
		} else {
			result = isFoldTreeUtil2(n1.left, n2.right) && isFoldTreeUtil2(n1.right, n2.left);
		}
		return result;
	}

	public static void main(String[] args) {
		foldedTree t = new foldedTree(1);
		t.root.left = new node(2);
		t.root.right = new node(3);
		t.root.left.right = new node(4);
		t.root.right.left = new node(5);
		if (t.isFoldedTree2(t.root))
			System.out.println("Foldable");
		else
			System.out.println("Not foldable");
		if (t.isFoldedTree(t.root))
			System.out.println("Foldable");
		else
			System.out.println("Not foldable");
	}
}