package study.swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1949_등산로조성 {
	static int N,K;
	static int[][] map;
	static List<int[]> maxPoint;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			result = Integer.MIN_VALUE;
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int max = Integer.MIN_VALUE;
			maxPoint = new ArrayList<>();
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Integer.max(max, map[i][j]);
				}
			}
			getMaxPoint(max);
			
			for(int i=0;i<maxPoint.size();i++) {
				bfs(maxPoint.get(i)[0],maxPoint.get(i)[1],K,new boolean[N][N], max ,1, false);
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	static void getMaxPoint(int max) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == max) {
					maxPoint.add(new int[] {i,j});
				}
			}
		}
	}
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	static void bfs(int pointX, int pointY, int nowK, boolean[][] visited, int nowValue, int length, boolean sliced) {
		
		boolean[][] clone = new boolean[N][N];
		for(int t=0;t<visited.length;t++) {
			clone[t] = visited[t].clone();
		}
		clone[pointX][pointY] = true;
		for(int d=0;d<4;d++) {
			int nr = pointX+deltas[d][0];
			int nc = pointY+deltas[d][1];
			if(isIn(nr,nc) && !clone[nr][nc]) {
				if(map[nr][nc]>=nowValue) {
					if(map[nr][nc]-nowK>=nowValue) {
						continue;
					}
					if(!sliced) {
						int toSlice = map[nr][nc]-nowValue+1;
						bfs(nr,nc,nowK-toSlice,clone,map[nr][nc]-toSlice, length+1,true);
					}
				}else {
					bfs(nr,nc,nowK,clone,map[nr][nc], length+1, sliced);
				}
				
			}
		}
		result = Integer.max(result, length);
		
	}
	static boolean isIn(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
}
