import java.util.*;
class Node{
	int data;
	Node next;
	public Node(int data) {
		this.data=data;
		this.next=null;
	}
}
public class SLL {
	int count=0;
	Node head;
	public SLL() {
		head=null;
	}
	public int listLength() {
		return count;
	}
	
	public void addBeg(int data) {
		Node temp=new Node(data);
		if (head==null) {
			head=temp;
		}
		else {
			temp.next=head;
			head=temp;
		}
		count=count+1;
	}
	
	public void addEnd(int data) {
		Node temp=new Node(data);
		if (head==null) {
			head=temp;
		}
		else {
			Node curr=head;
			while (curr.next!=null) {
				curr=curr.next;
			}
			curr.next=temp;
		}
		count=count+1;
	}
	
	public void addBetween(int data, int index) {
		if (index<=1) {
			System.out.println("Index was either below 1 or 1: Adding at the Beginning");
			addBeg(data);
		}
		else if (index>count) {
			System.out.println("Index above length of list: Adding at the End");
			addEnd(data);
		}
		else {
			Node temp=new Node(data);
			int i;
			Node curr=head;
			Node prev=null;
			for (i=1;i<index;i++) {
				prev=curr;
				curr=curr.next;
			}
			prev.next=temp;
			temp.next=curr;
		}
		count=count+1;
	}
	
	public int delBeg() {
		if (head==null) {
			System.out.println("Empty List");
			return -1;
		}
		
		int res=0;
		Node temp=head;
		head=head.next;
		res=temp.data;
		count=count-1;
		return res;
	}
	
	public int delEnd() {
		if (head==null) {
			System.out.println("Empty List");
			return -1;
		}
		int res=0;
		Node curr=head;
		Node prev=null;
		while (curr.next!=null) {
			prev=curr;
			curr=curr.next;
		}
		if (prev==null) {
			res=curr.data;
			head=null;
			return res;
		}
		prev.next=null;
		res=curr.data;
		count=count-1;
		return res;
	}
	
	public int delBetween(int index) {
		int res=0;
		if (index<=1) {
			System.out.println("Index was either below 1 or 1: Deleting from the Beginning");
			delBeg();
		}
		else if (index>=count) {
			System.out.println("Index above length of list: Deleting from the End");
			delEnd();
		}
		else {
		int i;
		Node curr=head;
		Node prev=null;
		for (i=1;i<index;i++) {
			prev=curr;
			curr=curr.next;
		}
		prev.next=curr.next;
		res=curr.data;
		
		count=count-1;
		}
		return res;
	}
	
	public void display() {
		if (head==null) {
			System.out.println("Empty List");
		}
		else {
			Node curr=head;
			while (curr!=null) {
				System.out.print(curr.data+" ");
				curr=curr.next;
			}
			System.out.println();
		}
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SLL abc=new SLL();
		Scanner ob=new Scanner(System.in);
		char ch='y';
		int c;
		while (ch!= 'n' && ch!='N') {
			System.out.println("Press 1: Add At Beg");
			System.out.println("Press 2: Add At End");
			System.out.println("Press 3: Add in Between");
			System.out.println("Press 4: Delete At Beg");
			System.out.println("Press 5: Delete At End");
			System.out.println("Press 6: Delete At Between");
			System.out.println("Press 7: Length of List");
			System.out.println("Press 8: Print List");
			c=ob.nextInt();
			switch(c) {
			case 1:
				System.out.println("Enter Data: ");
				int d1=ob.nextInt();
				abc.addBeg(d1);
				System.out.println("***********Done**************");
				break;
			case 2:
				System.out.println("Enter Data: ");
				int d2=ob.nextInt();
				abc.addEnd(d2);
				System.out.println("***********Done**************");
				break;
			case 3:
				System.out.println("Enter Data: ");
				int d3=ob.nextInt();
				System.out.println("Enter Index: ");
				int index=ob.nextInt();
				abc.addBetween(d3, index);
				System.out.println("***********Done**************");
				break;
			case 4:
				abc.delBeg();
				System.out.println("***********Done**************");
				break;
			case 5:
				abc.delEnd();
				System.out.println("***********Done**************");
				break;
			case 6:
				System.out.println("Enter Index: ");
				int index1=ob.nextInt();
				abc.delBetween(index1);
				System.out.println("***********Done**************");
				break;
			case 7:
				System.out.println(abc.listLength());
				System.out.println("***********Done**************");
				break;
			case 8:
				abc.display();
				break;
			default:
				System.out.println("***********Wrong Choice**************");
				break;
			}
			
			
			System.out.println("Want to do again? Y/N");
			ch=ob.next().charAt(0);
		}

	}

}
