import java.util.*;
public class NotrepeatedInrepeated {
	
	public static void searchBinaryWay(int a[], int l, int h) {
		if (l>h)
			return;
		if (l==h)
			{System.out.println(a[l]);return;}
		int mid=(l+h)/2;
		if (mid%2==0) {
			if (a[mid]==a[mid+1])
				searchBinaryWay(a, mid+2, h);
			else
				searchBinaryWay(a, l, mid);
		}
		else {
			if (a[mid]==a[mid-1])
				searchBinaryWay(a, mid+1, h);
			else
				searchBinaryWay(a, l, mid-1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ob=new Scanner (System.in);
		int n=ob.nextInt();
		int a[]=new int[n];
		for (int i=0;i<n;i++)
			a[i]=ob.nextInt();
		searchBinaryWay(a, 0, a.length-1);
	}

}
