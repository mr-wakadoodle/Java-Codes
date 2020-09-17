import java.util.Scanner;
public class Kadane {
	// https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
	public static int maxSumArray(int a[], int n) {
		int curr_sum=0;
		int max_sum=Integer.MIN_VALUE;
		int i, start=0, end=0, s=0;
		for (i=0;i<n;i++) {
			curr_sum=curr_sum+a[i];
			if (curr_sum>max_sum) {
				max_sum=curr_sum;
				start=s;
				end=i;
			}
			if (curr_sum<0) { //it is <0 and not <=0, which means if you are bringing negative sum from beforehand to be added to next number
								//then its no need, to start the series from there hence clear sum to zero, and start from next index from sub array series 
				curr_sum=0;
				s=i+1;
			}
		}
		return max_sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ob=new Scanner(System.in);
		int i, t, n;
		t=ob.nextInt();
		while (t>0) {
			n=ob.nextInt();
			int a[]=new int[n];
			for (i=0;i<n;i++) {
				a[i]=ob.nextInt();
			}
			System.out.println(maxSumArray(a, n));
			t--;
		}
	}

}
