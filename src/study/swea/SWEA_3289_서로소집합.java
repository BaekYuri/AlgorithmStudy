package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {
	static int N,M;
	static int parents[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for(int t=1;t<=T;t++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parents = new int[N+1];
			
			make();
			
			sb.append("#").append(t).append(" ");
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int x= Integer.parseInt(st.nextToken());
				int a= Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				
				if(x==0) {
					union(a,b);
				}else {
					if(find(a)==find(b)) {
						sb.append(1);
					}else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
	static void make() {
		for(int i=0;i<N;i++) {
			parents[i] = i;
		}
	}
	static int find(int a) {
		if(parents[a]== a) {
			return a;
		}else {
			return parents[a]= find(parents[a]);
		}
	}
	static boolean union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		if(aParent == bParent) return false;
		
		parents[bParent] = aParent;
		return true;
	}
}
