import java.util.*;
public class InsertionSort {
	
	public static void insertionSort(int n[]) {
		int i, h, t;
		for (i=1;i<n.length;i++) {
			t=n[i];
			h=i-1;
			while (h>=0 && t<n[h]) {
				n[h+1]=n[h];
				h--;
			}
			h=h+1;
			n[h]=t;
		}
		System.out.println(Arrays.toString(n));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ob=new Scanner(System.in);
		int n=ob.nextInt();
		int a[]=new int[n];
		for (int i=0;i<n;i++)
			a[i]=ob.nextInt();
		insertionSort(a);
	}

}
