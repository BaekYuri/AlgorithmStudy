package study.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 정올_1828_냉장고 {
	static int N;
	static Things[] things;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		things = new Things[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			things[i] = new Things(min,max);
		}
		System.out.println(greedy(things).size());
	}
	static List<Integer> greedy(Things[] t) {
		Arrays.sort(t);
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(t[0].max);
		for(int i=1, size=t.length;i<size;i++) {
			int now = temp.get(temp.size()-1);
			if(now>=t[i].min && now<=t[i].max) continue;
			temp.add(t[i].max);
		}
		return temp;
	}
	
	static class Things implements Comparable<Things>{
		int min, max;

		public Things(int min, int max) {
			super();
			this.min = min;
			this.max = max;

		}

		@Override
		public int compareTo(Things o) {
			int diff= this.max!=o.max?this.max-o.max:this.min-o.min;
			return diff;
		}
		
	}
}
