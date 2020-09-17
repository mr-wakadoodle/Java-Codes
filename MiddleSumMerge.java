import java.util.*;
public class MiddleSumMerge {
	// https://www.geeksforgeeks.org/median-of-two-sorted-arrays/
	public static int getMedian(int a[], int b[], int StartA, int StartB, int EndA, int EndB) {
		if (EndA-StartA == 1) {
			return (Math.max(a[StartA], b[StartB]) + Math.min(a[EndA], b[EndB]))/2;
		}
		int m1=median(a, StartA, EndA);
		int m2=median(b, StartB, EndB);
		if (m1==m2)
			return m1;
		else if (m1>m2) {
			return getMedian(a, b, StartA, (EndB+StartB+1)/2, (EndA+StartA+1)/2, EndB);
		}
		else {
			return getMedian(a, b, (EndA+StartA+1)/2, StartB, EndA, (EndB+StartB+1)/2);
			}
	}
	
	public static int median(int a[], int start, int end) {
		int n=end - start + 1;
		if (n%2==0) {
			return (a[start + (n/2)] + a[start + (n/2-1)]) / 2;
		}
		else {
		return a[start + (n/2)];
		}
	}
	
	/*
	 *My Approach O(n)
	 * public static int MergeSumMiddle(int a[], int b[]) {
		int n=a.length;
		int temp1[]=new int[n+1];
		int temp2[]=new int[n+1];
		int farray[]=new int[2*n];
		int i;
		temp1[temp1.length-1]=99999;
		temp2[temp2.length-1]=99999;
		int k=0;
		for (i=0;i<temp1.length-1;i++) {
			temp1[i]=a[k];
			temp2[i]=b[k];
			k++;
		}
		int t1=0,t2=0;
		for (i=0;i<farray.length;i++) {
			if (temp1[t1]<temp2[t2]) {
				farray[i]=temp1[t1];
				if (t1<temp1.length) {t1++;}
			}
			else {
				farray[i]=temp2[t2];
				if (t2<temp2.length) {t2++;}
			}
		}
		int l=farray.length;
		System.out.println(Arrays.toString(farray));
		int sum=0;
		sum=farray[l/2-1]+farray[l/2];
		return sum;
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		int n,i;
		int sum=0;
		while (t>0) {
			n=ob.nextInt();
			int a[]=new int[n];
			int b[]=new int[n];
			for (i=0;i<n;i++) {
				a[i]=ob.nextInt();
			}
			for (i=0;i<n;i++) {
				b[i]=ob.nextInt();
			}
			//sum=MergeSumMiddle(a, b); //My Approach O(n)
			//Geeks for Geeks O(log n)
			sum=getMedian(a, b, a[0], b[0], a[n-1], b[n-1]);
			System.out.println(sum);
			t--;
		}
	}

}
