package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8972_미친아두이노 {
	static int N, M;
	static char[][] map;
	static int[] I;
	static ArrayList<int[]> R;
	static int[][] deltas= {{0,0},{1,-1},{1,0},{1,1},{0,-1},{0,0},{0,1},{-1,-1},{-1,0},{-1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		R = new ArrayList<>();
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			Arrays.fill(map[i], '.');
			for(int j=0;j<M;j++) {
				char now = s.charAt(j);
				if(now=='I') {
					I = new int[] {i,j};
				}else if(now=='R') {
					R.add(new int[] {i,j});
				}
			}
		}
		
		String go = br.readLine();
		
		for(int i=0, length = go.length();i<length;i++) {
			int direction = go.charAt(i)-'0';
			
			I[0]+=deltas[direction][0];
			I[1]+=deltas[direction][1];
			
			ArrayList<int[]> tempR = new ArrayList<>();
			boolean[][] visited = new boolean[N][M];
			while(!R.isEmpty()) {
				int[] nowR = R.remove(0);
				if(nowR[0]==I[0] && nowR[1]==I[1]) {
					System.out.println("kraj "+(i+1));
					return;
				}
				int distance = Integer.MAX_VALUE;
				int r=0;
				int c=0;
				for(int j=1;j<=9;j++) {
					if(j==5) continue;
					int nr = nowR[0]+deltas[j][0];
					int nc = nowR[1]+deltas[j][1];
					
					if(nr>=0 && nr<N && nc>=0 && nc<M) {
						int temp = Math.abs(I[0]-nr)+Math.abs(I[1]-nc);
						if(distance>temp) {
							distance = temp;
							r = nr;
							c = nc;
						}
					}
				}
				if(r==I[0] && c== I[1]) {
					System.out.println("kraj "+(i+1));
					return;
				}
				if(visited[r][c]) {
					for(int j=0, tempLength= tempR.size();j<tempLength;j++) {
						int[] temp = tempR.get(j);
						if(temp[0]==r && temp[1]==c) {
							tempR.remove(j);
							break;
						}
					}
				}else {
					visited[r][c]= true;
					tempR.add(new int[] {r,c});
				}
			}
			R = tempR;
		}
		
		while(!R.isEmpty()) {
			int[] now = R.remove(0);
			map[now[0]][now[1]] = 'R';
		}
		map[I[0]][I[1]] = 'I';
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
