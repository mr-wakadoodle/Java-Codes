import java.util.*;
public class Majority {
	//Moore Volting Algorithm
	public static int isMajorityElement(int a[], int size) {
		int i, c=1, mindex=0;
		for (i=1;i<size;i++) {
			if (a[mindex]==a[i]) {
				c++;
			}
			else {
				c--;
			}
			if (c==0) {
				c=1;
				mindex=i;
			}
		}
		c=0;
		int x=0;
		for (i=0;i<size;i++) {
			if (a[i]==a[mindex])
				c++;
			if (c>(size/2)) {
				x=1;
				break;
			}
		}
		if  (x==0)
			return -1;
		
		return a[mindex];
	}

	public static void main(String[] args) {
		int t, n, i;
		Scanner ob=new Scanner(System.in);
		t=ob.nextInt();
		while (t>0) {
			n=ob.nextInt();
			int a[]=new int[n];
			for (i=0;i<n;i++) {
				a[i]=ob.nextInt();
			}
			t--;
			System.out.println(isMajorityElement(a, n));
		}
	}

}
