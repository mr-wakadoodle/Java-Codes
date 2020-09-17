import java.util.*;
public class JumpingNumbers {
	Set<Integer> s=new TreeSet<Integer>();
	public void actualGenerator(int curr, int limit) {
		Queue<Integer> store=new LinkedList<Integer>();
		int lastdigit;
		store.add(curr);
		while (!store.isEmpty()) {
			curr=store.peek();
			store.poll();
			if (curr<=limit) {
				s.add(curr);//System.out.print(curr+" ");
				lastdigit=curr%10;
				if (lastdigit == 0) {
					store.add((curr*10) + (lastdigit+1));
				}
				else if (lastdigit == 9) {
					store.add((curr*10) + (lastdigit-1));
				}
				else {
					store.add((curr*10)+(lastdigit-1));
					store.add((curr*10)+(lastdigit+1));
				}
			}
		}
	}
	
	public void generateJumpingNumbers(int n) {
		//System.out.print("0 ");
		s.add(0);
		int i;
		for (i=1;i<=9 && i<=n;i++) {
			actualGenerator(i, n);
		}
		System.out.println(s);
		
	}
	
	/*public static boolean checkJump(int i) {
		String s=""+i;
		int t1,t2;
		for (int j=1;j<s.length();j++) {
			t1=s.charAt(j-1);
			t2=s.charAt(j);
			if (t2!=t1+1) {
				if (t2!=t1-1) {
					return false;
				}
			}
		}
		
		return true;
	}
	public static void generateJumpingNumbers(int n) {
		int i=0;
		while (i<=n) {
			if (i<=10) {
				System.out.print(i+" ");
			}
			else {
				if (checkJump(i)) {
					System.out.print(i+" ");
				}
			}
			i++;
		}
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpingNumbers abc=new JumpingNumbers();
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		int n;
		while (t>0) {
			n=ob.nextInt();
			abc.generateJumpingNumbers(n);
			System.out.println();
			t--;
		}
	}

}
