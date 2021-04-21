package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643_키순서 {
	static int N, M;
	static List<Integer> list[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb= new StringBuilder();
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[N+1][2];
			for(int i=0;i<=N;i++) {
				list[i] = new ArrayList[2];
				list[i][0] = new ArrayList<>();
				list[i][1] = new ArrayList<>();
			}
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int small = Integer.parseInt(st.nextToken());
				int big = Integer.parseInt(st.nextToken());
				list[small][0].add(big);
				list[big][1].add(small);
			}
			int result = N;
			for(int i=1;i<=N;i++) {
				Queue<int[]> queue = new LinkedList<>();
				
				queue.add(new int[] {i,0});
				queue.add(new int[] {i,1});
				boolean[] visited= new boolean[N+1];
				visited[i] = true;
				
				while(!queue.isEmpty()) {
					int[] now = queue.poll();
					for(int j=0, size=list[now[0]][now[1]].size();j<size;j++) {
						int temp = list[now[0]][now[1]].get(j);
						if(!visited[temp]) {
							visited[temp] = true;
							
							queue.add(new int[] {temp,now[1]});
						}
					}
				}
				for(int x=1;x<=N;x++) {
					if(!visited[x]) {
						result--;
						break;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
