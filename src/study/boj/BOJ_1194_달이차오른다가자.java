package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이차오른다가자 {
	static char[][] map;
	static int N, M;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Queue<int[]> queue = new LinkedList<int[]>();
		map = new char[N][M];
		boolean[][][] visited= new boolean[N][M][1<<6];
		for(int i=0;i<N;i++) {
			String s=  br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]= s.charAt(j);
				if(map[i][j]=='0') {
					queue.add(new int[] {i,j,0});
					map[i][j]= '.';
					visited[i][j][0] = true;
				}
			}
		}
		int depth = 0;
		boolean found = false;
		outer : while(!queue.isEmpty()) {
			int size= queue.size();
			while(size--> 0) {
				int[] now = queue.poll();
				if(map[now[0]][now[1]]=='1') {
					found = true;
					break outer;
				}
				for(int d=0;d<4;d++) {
					int nr= now[0]+deltas[d][0];
					int nc= now[1]+deltas[d][1];
					
					if(isIn(nr,nc)) {
						if((map[nr][nc]=='.' || map[nr][nc]=='1') && !visited[nr][nc][now[2]]) {
							queue.add(new int[] {nr,nc,now[2]});
							visited[nr][nc][now[2]] = true;;
						}else if(map[nr][nc]>='A' && map[nr][nc]<='F' && !visited[nr][nc][now[2]]) {
							int t = map[nr][nc]-'A';
							if((now[2]&(1<<t))!=0) {
								queue.add(new int[] {nr,nc,now[2]});
								visited[nr][nc][now[2]] = true;
							}
						}else if(map[nr][nc]>='a' && map[nr][nc]<='f') {
							int t = map[nr][nc]-'a'; // a : 0 b:1 c:2 ~~~~  1<<t   1 10 100 1000     000010 | 000001  = 000011
							if( !visited[nr][nc][now[2]|(1<<t)]) {
								queue.add(new int[] {nr,nc,now[2]|(1<<t)});
								visited[nr][nc][now[2]|(1<<t)] = true;
							}
						}
					}
				}
			}
			depth++;
		}
		if(found) {
			System.out.println(depth);
		}else {
			System.out.println(-1);
		}
		
	}
	static boolean isIn(int a, int b) {
		return a>=0 && b>=0 && a<N && b<M;
	}
	
	// or    0| 0 = 0   // 0|1 == 1   // 1|1 == 1
}
