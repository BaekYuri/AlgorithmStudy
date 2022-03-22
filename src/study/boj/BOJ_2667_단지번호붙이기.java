package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] visited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<N;j++) {
				visited[i][j] = input.charAt(j)=='0'?true:false;
			}
		}
		
		List<Integer> result = new ArrayList<>();
		
		Queue<int[]> queue = new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]) continue;
				visited[i][j]=true;
				queue.add(new int[] {i,j});
				int house = 1;
				while(!queue.isEmpty()) {
					int[] now = queue.poll();
					for(int k=0;k<4;k++) {
						int nr = now[0]+deltas[k][0];
						int nc = now[1]+deltas[k][1];
						if(nr>=0 && nc>=0 && nr<N && nc<N && !visited[nr][nc]) {
							visited[nr][nc] = true;
							queue.add(new int[] {nr,nc});
							house++;
						}
					}
				}
				result.add(house);
			}
		}
		
		Collections.sort(result);
		
		StringBuilder output = new StringBuilder();
		
		output.append(result.size()).append("\n");
		
		for(int item : result) {
			output.append(item).append("\n");
		}
		
		System.out.println(output);
		
	}
}
