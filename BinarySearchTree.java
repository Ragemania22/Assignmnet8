
public class BinarySearchTree {

	public static class Node{
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	//Represent the root of binary tree
	public Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	//code to add new node to the binary search tree
	public void insert(int value) {
		//Create a new node
		Node newNode = new Node(value);
		
		//Check whether tree is empty
		if(root == null) {
			root = newNode;
			return;
		}
		else {
			//current node point to root of the tree
			Node current = root, parent = null;
			
			while(true) {
				//Parent keep track to the parent node of current node.
				parent = current;
				
				//If data is less than currnet's data, node will be inserted to the left of tree
				if(value < current.value) {
					current = current.left;
					if(current == null) {
						parent.left = newNode;
						return;
					}
				}
				//If data is greater than current's data, node will be inserted to the right of tree
				else {
					current = current.right;
					if(current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
		
	}
	
	//minNode() will find out the minimum node
	public Node minNode(Node root) {
		if(root.left != null)
			return minNode(root.left);
		else
			return root;
	}
	
	//deleteNode() will delete the given node form the binary search tree
	public Node deleteNode(Node node, int value) {
		if(node == null) {
			return null;
		}
		else {
			//value is less than node's data then, search the value in left subtree
			if(value < node.value)
				node.left = deleteNode(node.left, value);
			
			//value is greater than node's data then, search the value in right subtree
			else if(value > node.value)
				node.right = deleteNode(node.right, value);
			
			//If value is equal to node's data that is, we have found the node to be deleted
			else {
				//If node to be deleted has no child the, set the node to null
				if(node.left == null && node.right == null)
					node = null;
				
				//If node to be deleted has only one right child
				else if(node.left == null) {
					node = node.right;
				}
				//If node to be deleted has only one left child
				else if(node.right == null) {
					node = node.left;
				}
				//If node to be deleted has two children node
				else {
					//Then find the minimum node from right subtree
					Node temp = minNode(node.right);
					//Exchange the data between node and temp
					node.value = temp.value;
					//Delete the node duplicate node form right subtree
					node.right = deleteNode(node.right, temp.value);
				}
			}
		}
		return node;
	}
	
	//inorder() will perform inorder traversal on binar
	public void inorderTraversal(Node node) {
		//Check whether tree is empty
		if(root == null) {
			System.out.println("Tree is empty");
			return;
		}
		else {
			
			if(node.left != null)
				inorderTraversal(node.left);
			System.out.print(node.value + "");
			if(node.right != null)
				inorderTraversal(node.right);
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree bt = new BinarySearchTree();
		//Add nodes to the binary tree
		bt.insert(50);
		bt.insert(30);
		bt.insert(40);
		bt.insert(20);
		bt.insert(60);
		bt.insert(70);

		System.out.println("Binary search tree after insertion:");
		//Displays the binary tree
		bt.inorderTraversal(bt.root);
		
		Node deletedNode = null;
		
		//Deleted node 30 which is in the Assignment
		deletedNode = bt.deleteNode(bt.root,30);
		System.out.println("\nBinary search tree after deleteing node 30:");
		bt.inorderTraversal(bt.root);
	}

}
