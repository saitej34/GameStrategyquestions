import java.util.*;
public class Main
{
    static class pair implements Comparable<pair>{
        int w;
        int v;
        pair(int w,int v)
        {
            this.w=w;
            this.v=v;
        }
        @Override
        public int compareTo(pair p)
        {
            return (this.w/this.v)-(p.w/p.v);
        }
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<pair> a=new ArrayList<>();
		a.add(new pair(10,5));
		a.add(new pair(30,3));
		a.add(new pair(16,4));
		Collections.sort(a);
		for(int i=0;i<3;i++)
		{
		    System.out.println(a.get(i).w+" "+a.get(i));
		}
	}
}
