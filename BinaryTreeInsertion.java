import java.util.*;
class Node1 {
	int data;
	Node1 left, right;
	public Node1(int data) {
	this.data=data;
	this.left=null;
	this.right=null;
	}
}
class BinaryTreeInsertion {
	Node1 root;
	public BinaryTreeInsertion(){
	root=null;
	}
	
	public boolean search(int data) {
		if (root==null) {
			return false;
		}
		Node1 curr=root;
		while (curr!=null) {
			if (curr.data==data) {
				return true;
			}
			else if (curr.data < data) {
				curr=curr.right;
			}
			else if (curr.data > data) {
				curr=curr.left;
			}
		}
		return false;
	}
	
	public void insertion(int data) {
		Node1 temp=new Node1(data);
		if (root==null) {
			root=temp;
		}
		else {
			Node1 parent=null, current=root;
			while(current!=null) {
				parent=current;
				if (current.data<data) {
					current=current.right;
				}
				else {
					current=current.left;
				}
			}
			if (parent.data<data) {
				parent.right=temp;
			}
			else {
				parent.left=temp;
			}
		}
	}
	public void display(int c) {
		if (c==2)
			preOrderTraversal(root);
		else if (c==3)
			inOrderTraversal(root);
		else if (c==4)
			postOrderTraversal(root);
	}
	
	public void preOrderTraversal(Node1 root) {
		if (root!=null) {
			System.out.println(root.data+" ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
	
	public void inOrderTraversal(Node1 root) {
		if (root!=null) {
			inOrderTraversal(root.left);
			System.out.println(root.data+" ");
			inOrderTraversal(root.right);
		}
	}
	
	public void postOrderTraversal(Node1 root) {
		if (root!=null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.println(root.data+" ");
		}
	}
	
	public int sizeOfTree() {
		return numberOfNodes(root);
	}
	
	public int numberOfNodes(Node1 node) {
		if (node==null) {
			return 0;
		}
		int leftSize=numberOfNodes(node.left);
		int rightSize=numberOfNodes(node.right);
		return leftSize + rightSize + 1;
	}
	
	public int heightTree() {
		return height(root);
	}
	
	public int height(Node1 node) {
		if (node==null)
			return 0;
		
		int lft=height(node.left);
		int rt=height(node.right);
		
		return 1 + Math.max(lft, rt);
	}
	
	public void amazonQuestion(Node1 node) {
		if (node!=null) {
			amazonQuestion(node.left);
			amazonQuestion(node.right);
			if (node.left != null && node.right!=null) {
				node.data=node.left.data * node.right.data;
			}
		}
	}
	
	public void initiateAmazon() {
		amazonQuestion(root);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeInsertion abc=new BinaryTreeInsertion();
		Scanner ob=new Scanner(System.in);
		int t=0,c;
		while (t!=-1) {
			System.out.println("Press 1: To Insert");
			System.out.println("Press 2: To print PreOrder");
			System.out.println("Press 3: To print InOrder");
			System.out.println("Press 4: To print PostOrder");
			System.out.println("Press 5: To Search");
			System.out.println("Press 6: Size of the Tree");
			System.out.println("Press 7: Height of the Tree");
			System.out.println("Press 8: Initiate Amazon");
			c=ob.nextInt();
			switch(c) {
			case 1:
				System.out.println("Data");
				int i=ob.nextInt();
				abc.insertion(i);
				System.out.println("--------------------Done-------------------");
				break;
			case 2:
				abc.display(c);
				break;
			case 3:
				abc.display(c);
				break;
			case 4:
				abc.display(c);
				break;
			case 5:
				System.out.println("Enter Key data");
				int data = ob.nextInt();
				if (abc.search(data))
					System.out.println("Found");
				else
					System.out.println("Not Found");
			case 6:
				System.out.println("Number of Nodes: "+ abc.sizeOfTree());
				break;
			case 7:
				System.out.println("Height of the Tree: "+ abc.heightTree());
				break;
			case 8:
				abc.initiateAmazon();
				break;
			}
			System.out.println("Enter -1 to STOP");
			t=ob.nextInt();
		}
	}

}
