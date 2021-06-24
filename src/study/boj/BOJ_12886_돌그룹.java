package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12886_돌그룹 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] stone = new int[3];
		int sum =0;
		for(int i=0;i<3;i++) {
			stone[i] = Integer.parseInt(st.nextToken());
			sum+=stone[i];
		}
		if(sum%3!=0) {
			System.out.println(0);
			return;
		}
		Stones nowStone = new Stones(stone[0], stone[1], stone[2]);
		if(nowStone.isSame()) {
			System.out.println(1);
			return;
		}
		Queue<Stones> queue =new LinkedList<>();
		HashSet<Stones> visited = new HashSet<>();
		queue.add(nowStone);
		visited.add(nowStone);
		while(!queue.isEmpty()) {
			nowStone = queue.poll();
			
			int[] temp = new int[] {nowStone.getA(),nowStone.getB(),nowStone.getC()};
			int[] clone = temp.clone();
			if(clone[0]!=clone[1]) {
				int min = Math.min(clone[0], clone[1]);
				if(clone[0]>clone[1]) {
					clone[0]-=min;
					clone[1]+=min;
				}else {
					clone[0]+=min;
					clone[1]-=min;
				}
				Stones tempStone = new Stones(clone[0], clone[1], clone[2]);
				if(tempStone.isSame()) {
					System.out.println(1);
					return;
				}else if(!visited.contains(tempStone)) {
					queue.add(tempStone);
				}
			}
			
			clone = temp.clone();
			if(clone[1]!=clone[2]) {
				int min = Math.min(clone[1], clone[2]);
				if(clone[1]>clone[2]) {
					clone[1]-=min;
					clone[2]+=min;
				}else {
					clone[1]+=min;
					clone[2]-=min;
				}
				Stones tempStone = new Stones(clone[0], clone[1], clone[2]);
				if(tempStone.isSame()) {
					System.out.println(1);
					return;
				}else if(!visited.contains(tempStone)) {
					queue.add(tempStone);
				}
			}
			
			clone = temp.clone();
			if(clone[0]!=clone[2]) {
				int min = Math.min(clone[0], clone[2]);
				if(clone[0]>clone[2]) {
					clone[0]-=min;
					clone[2]+=min;
				}else {
					clone[0]+=min;
					clone[2]-=min;
				}
				Stones tempStone = new Stones(clone[0], clone[1], clone[2]);
				if(tempStone.isSame()) {
					System.out.println(1);
					return;
				}else if(!visited.contains(tempStone)) {
					queue.add(tempStone);
				}
			}
			
		}
		System.out.println(0);
	}
	static class Stones{
		int a,b,c;

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}

		public int getC() {
			return c;
		}

		public void setC(int c) {
			this.c = c;
		}

		public Stones(int a, int b, int c) {
			super();
			int min = Math.min(a, Math.min(b, c));
			int max = Math.max(a, Math.max(b, c));
			this.a = min;
			this.c = max;
			if((min==a && max==b) || (min==b && max==a)) {
				this.b = c;
			}else if((min==a && max==c) || (min==c && max==a)) {
				this.b = b;
			}else if((min==b && max==c) || (min==c && max==b)) {
				this.b = a;
			}
		}
		public boolean isSame() {
			if(a==b && b==c) {
				return true;
			}
			return false;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + b;
			result = prime * result + c;
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
			Stones other = (Stones) obj;
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			if (c != other.c)
				return false;
			return true;
		}
		
	}
}
