import java.util.Scanner;

public class ListNode {
	Node head;
	static class Node{
		int data;
		Node next;
		public Node(int value){
			data=value;
			next=null;
		}
	}

	public void insertBeg(int value){
		Node temp=new Node(value);
		temp.next=head;
		head=temp;
	}

	public void insertEnd(int value){
		Node temp=new Node(value);
		if (head==null){
			head=temp;
			head.next=null;
		}
		else{
		Node curr=head;
		while(curr.next!=null){
			curr=curr.next;
		}
		curr.next=temp;
		temp.next=null;
	}
	}

	public void insertAt(int value,int p){
		Node temp=new Node(value);
		ListNode s=new ListNode();
		int f=0;
		if (head==null || p==1){
			//System.out.println("No element so adding head");
			temp.next=head;
			head=temp;
			//head.next=null;
		}
		else{
		Node i=head;
		
		int count=1;
		while(i!=null){
			if (p-count==1){
				temp.next=i.next;
				i.next=temp;
				f=1;
				break;
			}
			count++;
			i=i.next;
		}
		if (f==0){
			
			s.insertEnd(value);
		}
	}
	}

	public void deleteEnd(){
		if (head==null){
			System.out.println("Empty List");
		}
		else{
			Node curr=head,p=head;
			while (curr.next!=null){
				p=curr;
				curr=curr.next;
			}
			p.next=null;
		}
	}

	public void removeAt(Node r){
		if (head==null){
			System.out.println("Empty List");	
		}
		else if (head.data==(r.data)){
			head=head.next;
		}
		else{
			Node curr=head,p=head;
			while (curr.next!=null){
				p=curr;
				curr=curr.next;
				if (curr.data==(r.data)){
					p.next=curr.next;
				}
			}
		}
	}

	public void display(){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}

	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		ListNode c=new ListNode();
		char ch;
		int choice;
		int v,pos;
		do{
		System.out.println("Enter Value: ");
		v=ob.nextInt();
		System.out.println("Enter Head(1) or Tail(2) or addAt(3) or deleteEnd(4) or removeAt(5): ");
		choice=ob.nextInt();
		if (choice==1)
		c.insertBeg(v);
		else if (choice==2)
		c.insertEnd(v);
		else if(choice==3){
			System.out.println("Enter Position: ");
			pos=ob.nextInt();
			c.insertAt(v,pos);
		}
		else if (choice==4){
			c.deleteEnd();
		}

		else if (choice==5){
			Node temp=new Node(v);
			c.removeAt(temp);
		}

		System.out.println("Want to enter again? Y or N");
		ch=ob.next().charAt(0);
		

	}while(!((ch=='N') || (ch=='n')));
		c.display();
	}
}
