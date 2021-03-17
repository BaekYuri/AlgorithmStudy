package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	static int N;
	static int[][] map;
	static int[] shark;
	static int sharkSize =2;
	static int[][] deltas = {{-1,0},{0,-1},{0,1},{1,0}};
	static int result = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		shark = new int[2];
		for(int i=0;i<N;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					shark[0] = i;
					shark[1] = j;
					map[i][j]=0;
				}
			}
		}
		
		find();
		
		System.out.println(result);
	}
	
	static void find() {
		int eat= 0;
		int count = 0;
		int[][] countMap = new int[N][N];
		while(true) {
			Queue<int[]> queue = new LinkedList<>();
			
			PriorityQueue<int[]> someRst = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0]==o2[0]) {
						return o1[1]-o2[1];
					}else {
						return o1[0]-o2[0];
					}
				}
			});
			queue.add(new int[] {shark[0],shark[1]});
			boolean[][] visited= new boolean[N][N];
			int time = 0;
			boolean finded = false;
			while(!queue.isEmpty()) {
				int size = queue.size();
				
				while(size-->0) {
					int[] temp = queue.poll();
					if(visited[temp[0]][temp[1]]) continue;
					visited[temp[0]][temp[1]] = true;
					if(map[temp[0]][temp[1]]!=0 && map[temp[0]][temp[1]]<sharkSize) {

						someRst.add(new int[] {temp[0],temp[1]});
						finded = true;
						
					}
					if(!finded) {
						for(int d=0;d<4;d++) {
							int nr = temp[0]+deltas[d][0];
							int nc = temp[1]+deltas[d][1];
							if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc]<=sharkSize) {
								queue.add(new int[] {nr,nc});
							}
						}
					}
				}
				if(finded) {
					int[] now = someRst.poll();
					shark[0] = now[0];
					shark[1] = now[1];
					eat++;
					countMap[now[0]][now[1]]=++count;
					map[now[0]][now[1]] = 0;
					break;
				}
				time++;
			}
			if(!finded) {
				break;
			}
			result+=time;
			if(eat==sharkSize) {
				sharkSize++;
				eat=0;
			}
		}
	}
	static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}
