import java.util.Scanner;
public class DDL {
	Node head;
	static class Node{
		Node prev,next;
		int data;
		Node(int data){
			prev=null;
			next=null;
			this.data=data;
		}
	}
	
	public void insertBeg(int v) {
		Node temp=new Node(v);
		if (head==null) {
			temp.next=null;
			temp.prev=null;
			head=temp;
		}
		else {
			temp.next=head;
			temp.prev=null;
			head.prev=temp;
			head=temp;
		}
	}
	
	public void insertEnd(int v) {
		Node temp=new Node(v);
		if (head==null) {
			temp.next=null;
			temp.prev=null;
			head=temp;
		}
		else if (head.next==null) {
			head.next=temp;
			temp.prev=head;
			temp.next=null;
		}
		else {
			Node curr=head;
			while (curr.next!=null) {
				curr=curr.next;
			}
			curr.next=temp;
			temp.prev=curr;
			temp.next=null;
		}
	}
	
	public void insertAt(int value,int pos) {
		Node temp=new Node(value);
		if (pos<=0)
			pos=1;
		
		if (head==null || pos==1) {
			temp.next=head;
			temp.prev=null;
			//1head.prev=temp;
			head=temp;
		}
		else if (head.next==null) {
			head.next=temp;
			temp.prev=head;
			temp.next=null;
			return;
		}
		else {
			Node curr=head;
			int c=1;
			while (curr!=null) {
				if ((pos-c)==1) {
					temp.next=curr.next;
					temp.prev=curr;
					curr.next.prev=temp;
					curr.next=temp;
					return;
				}
				curr=curr.next;
				c++;
			}
			insertEnd(value);
		}
	}
	
	public void deleteBeg() {
		if (head==null) {
			System.out.println("Empty List");
			return;
		}
		else if (head.next==null) {
			head=null;
			return;
		}
		else {
			Node temp=head;
			head.next.prev=null;
			head=head.next;
			temp.next=null;
			return;
		}
			
	}
	
	public void deleteEnd() {
		if (head==null) {
			System.out.println("Empty List");
			return;
		}
		else if (head.next==null) {
			head=null;
			return;
		}
		else {
			Node temp=head;
			while (temp.next!=null) {
				temp=temp.next;
			}
			temp.prev.next=null;
			temp=null;
			return;
		}
	}
	
	public void deleteAt(int pos) {
		if (pos<=0 )
		{
			pos=1;
		}
		
			
		
		if (head==null)
			System.out.println("Empty List");
		
		else if (head.next==null){
			head=null;
			return;
		}
		else {
			Node temp=head;
			int c=1;
			if (pos==1)
			{
				temp.next.prev=null;
				head=temp.next;
				return;
			}
			while (temp.next!=null) {
				if (c==pos) {
					temp.prev.next=temp.next;
					temp.next.prev=temp.prev;
					temp=null;
					return;
				}
				c++;
				temp=temp.next;
			}
			deleteEnd();
		}
	}
	
	public void display() {
		Node curr=head;
		if (head==null)
			System.out.println("Empty List");
		while(curr!=null) {
			System.out.print(curr.data+" ");
			curr=curr.next;
		}
	}
	
	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		DDL c=new DDL();
		int choice,value,pos;
		char ch;
		do {
			System.out.println("Enter Value:");
			value=ob.nextInt();
			System.out.println("1: Insert at Beg");
			System.out.println("2: Insert at End");
			System.out.println("3: Insert at certain Position");
			System.out.println("4: Display");
			System.out.println("5: Delete at Beg");
			System.out.println("6: Delete at End");
			System.out.println("7: Delete at certain Position");
			System.out.println("8: Exit");
			System.out.println("Choice is: ");
			choice=ob.nextInt();
			switch(choice) {
			case 1:
				c.insertBeg(value);
				break;
			case 2:
				c.insertEnd(value);
				break;
			case 3:
				System.out.println("Enter Position");
				pos=ob.nextInt();
				c.insertAt(value,pos);
				break;
			case 4:
				c.display();
				System.out.println();
				break;
			case 5:
				c.deleteBeg();
				break;
			case 6:
				c.deleteEnd();
				break;
			case 7:
				System.out.println("Enter Position");
				pos=ob.nextInt();
				c.deleteAt(pos);
				break;
			}
		}while(choice!=8);
	}
}
