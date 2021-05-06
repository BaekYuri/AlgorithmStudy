package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520_내리막길 {
	static int N, M;
	static int[][] road;
	static int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}};
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			//입력받기 시작
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new int[N][M];
			road = new int[N][M];
			
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					dp[i][j] = -1;
					road[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력받기 끝
			//경우의수 구하는 함수
			find(0,0,road[0][0]);
			
			System.out.println(dp[0][0]);
		}
		
	
	
	static int find(int i, int j, int nowH) {
		if(i==N-1 && j==M-1) { //맨 밑 오른쪽이면 경우의수 하나 추가해주기
			return 1;
		}
		if(dp[i][j]==-1) {
			dp[i][j] = 0;
		
			for(int d=0;d<4;d++) { //네 방향으로 탐색
				int nr = i+deltas[d][0];
				int nc = j+deltas[d][1];
				
				if(isIn(nr,nc) && road[nr][nc]<nowH) { //만약 내리막길이면 그 길로 들어가기
					dp[i][j]+=find(nr,nc,road[nr][nc]);
				}
			}
		}
		return dp[i][j];
	}
	
	static boolean isIn(int a, int b) {
		return a>=0 && b>=0 && a<N && b<M;
	}
}
