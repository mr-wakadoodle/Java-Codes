import java.util.*;
public class KlargestElements {
	
	/*public static void kLargestElements(int b[],int k) {
		
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		int i;
		while (t-->0) {
			int a[]=new int[2];
			for (i=0;i<2;i++) {
				a[i]=ob.nextInt();
			}
			int len=a[0];
			int k=a[1];
			//int b[]=new int[len];
			Set<Integer> s=new TreeSet<Integer>();
			for (i=0;i<len;i++) {
				s.add(ob.nextInt());
				//b[i]=ob.nextInt();
			}
			Iterator it=s.iterator();
			i=1;
			String st="";
			while (it.hasNext()) {
				
				if (i>(len-k)) {
					st=" "+it.next()+st;
				}
				else {
					it.next();
				}
				i++;
			}
			System.out.print(st.trim());
			System.out.println();
		}
	}

}
