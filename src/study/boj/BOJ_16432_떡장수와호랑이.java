package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16432_떡장수와호랑이 {
	static int N;
	static ArrayList<Integer> list[];
	static int[] result = null;
	static boolean have = true;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N];
		for(int i=0;i<N;i++) {
			list[i] = new ArrayList<>();
			StringTokenizer st= new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0;j<cnt;j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
			if(i!=0) {
				if(list[i-1].size()==1) {
					list[i].remove((Object)list[i-1].get(0));
				}
			}
			if(list[i].isEmpty()) {
				have =false;
			}
		}
		
		
		if(!have) {
			System.out.println(-1);
		}else {
			dfs(0,0,new int[N]);
			if(result!=null) {
				StringBuilder sb= new StringBuilder();
				for(int r: result) {
					sb.append(r).append("\n");
				}
				System.out.println(sb);
			}else {
				System.out.println(-1);
			}
		}
	}
	static void dfs(int idx, int cakeNum, int[] choosed) {
		
		if(idx ==N) {
			result = choosed;
			return;
		}
		
		for(int i=0;i<list[idx].size();i++) {
			int cake = list[idx].get(i);
			if(cakeNum!=cake) {
				choosed[idx] = cake;
				dfs(idx+1,cake, choosed);
			}
			if(result!=null) return;
		}
	}
	
}
