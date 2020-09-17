import java.util.Scanner;

public class RotatingSortedArray {
	// Given a sorted and rotated array A of N distinct elements which is rotated at some point, and given an element K. 
	//The task is to find the index of the given element K in the array A.
	//https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
	public static int isPresentInArray(int a[], int size, int k) {
		int i, end=size-1, beg=0, mid;
		while (beg<=end) {
			mid=(beg+end)/2;
			if (k==a[mid])
				return mid;
			if (a[mid]>=a[beg]) {
				if (k>=a[beg] && k<=a[mid]) {
					end=mid-1;
				}
				else {
					beg=mid+1;
				}
			}
			else {
				if (k>=a[mid] && k<=a[end]) {
					beg=mid+1;
				}
				else {
					end=mid-1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int t, n, k, i;
		Scanner ob=new Scanner(System.in);
		t=ob.nextInt();
		while (t>0) {
			n=ob.nextInt();
			int a[]=new int[n];
			for (i=0;i<n;i++) {
				a[i]=ob.nextInt();
			}
			k=ob.nextInt();
			t--;
			System.out.println(isPresentInArray(a, n, k));
		}
	}

}
