import java.util.*;
class CharCount{
	int count;
	int index;

	public CharCount(int index) {
		this.index=index;
		this.count=1;
	}
	
	public void IncCount() {
		this.count++;
	}
}
public class sequenceChar {
	
	public static String getCharacter(String s) {
		int i;
		HashMap <Character, CharCount> hash = new HashMap<Character, CharCount>();
		
		for (i=0;i<s.length();i++) {
			if (hash.containsKey(s.charAt(i))) {
				hash.get(s.charAt(i)).IncCount();
			}
			else {
				hash.put(s.charAt(i) ,new CharCount(i));
			}
		}
		
		int min=Integer.MAX_VALUE;
		for (Character ch: hash.keySet()) {
			int c=hash.get(ch).count;
			int j=hash.get(ch).index;
			if (c==1 && j<min) {
				min=j;
			}
		}
		if (min==Integer.MAX_VALUE)
			return "-1";
		
		return s.charAt(min)+"";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		int n,i;
		String s="";
		int sum=0;
		while (t>0) {
			n=ob.nextInt();
			s=ob.next();
			String res = getCharacter(s);
			System.out.println(res);
			t--;
		}

	}

}
