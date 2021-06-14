package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14867_물통 {
	static int a,b,c,d;
	public static void main(String[] args) throws IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a= Integer.parseInt(st.nextToken());
		b= Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());
		d= Integer.parseInt(st.nextToken());
		
		Bottle bottle = new Bottle(0, 0);
		HashSet<Bottle> visited = new HashSet<>();
		Queue<Bottle> queue = new LinkedList<>();
		queue.add(bottle);
		visited.add(bottle);
		int depth = 0;
		boolean found = false;
		outer: while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Bottle now = (Bottle) queue.poll().clone();
				
				if(now.getNowA() == c && now.getNowB() == d) {
					found = true;
					break outer;
				}
				//Fill a
				Bottle fill = (Bottle) now.clone();
				fill.setNowA(a);
				if(!visited.contains(fill)) {
					queue.add(fill);
					visited.add(fill);
				}
				//Fill b
				fill = (Bottle) now.clone();
				fill.setNowB(b);
				if(!visited.contains(fill)) {
					queue.add(fill);
					visited.add(fill);
				}
				
				//Empty a
				fill = (Bottle) now.clone();
				fill.setNowA(0);
				if(!visited.contains(fill)) {
					queue.add(fill);
					visited.add(fill);
				}
				
				//Empty b
				fill = (Bottle) now.clone();
				fill.setNowB(0);
				if(!visited.contains(fill)) {
					queue.add(fill);
					visited.add(fill);
				}
				
				//Move from a to b
				fill = (Bottle) now.clone();
				fill.setNowB(fill.getNowB()+fill.getNowA());
				fill.setNowA(0);
				if(fill.getNowB()>b) {
					fill.setNowA(fill.getNowB()-b);
					fill.setNowB(b);
				}
				if(!visited.contains(fill)) {
					queue.add(fill);
					visited.add(fill);
				}
				
				//Move from b to a
				fill = (Bottle) now.clone();
				fill.setNowA(fill.getNowB()+fill.getNowA());
				fill.setNowB(0);
				if(fill.getNowA()>a) {
					fill.setNowB(fill.getNowA()-a);
					fill.setNowA(a);
				}
				if(!visited.contains(fill)) {
					queue.add(fill);
					visited.add(fill);
				}
			}
			depth++;
		}
		
		System.out.println(found?depth:-1);
	}
	
	static class Bottle{
		int nowA;
		int nowB;
		public int getNowA() {
			return nowA;
		}
		public void setNowA(int nowA) {
			this.nowA = nowA;
		}
		public int getNowB() {
			return nowB;
		}
		public void setNowB(int nowB) {
			this.nowB = nowB;
		}
		public Bottle(int nowA, int nowB) {
			super();
			this.nowA = nowA;
			this.nowB = nowB;
		}
		@Override
		public String toString() {
			return "Bottle [nowA=" + nowA + ", nowB=" + nowB + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + nowA;
			result = prime * result + nowB;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Bottle other = (Bottle) obj;
			if (nowA != other.nowA)
				return false;
			if (nowB != other.nowB)
				return false;
			return true;
		}
		@Override
		protected Object clone() throws CloneNotSupportedException {
			
			return new Bottle(nowA, nowB);
		}
		
	}
}
