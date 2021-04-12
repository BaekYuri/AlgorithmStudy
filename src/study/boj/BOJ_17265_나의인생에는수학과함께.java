package study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17265_나의인생에는수학과함께 {
	static int[][] deltas = {{1,0},{0,1}};
	static char[][] map;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map =new char[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		int[][][] dp = new int[N][N][2];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				dp[i][j][0] = Integer.MAX_VALUE;
				dp[i][j][1] = Integer.MIN_VALUE;
			}
		}
		dp[0][0][0] = map[0][0]-'0';
		dp[0][0][1] = map[0][0]-'0';
		
		boolean[][] visited= new boolean[N][N];
		Queue<int[]> queue = new LinkedList<>();
		//0:숫자 1:+ 2:- 3:* 4:/
		queue.add(new int[] {0,0,0});
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			if(visited[temp[0]][temp[1]]) continue;
			visited[temp[0]][temp[1]] = true;
			for(int d=0;d<2;d++) {
				int nowMin = dp[temp[0]][temp[1]][0];
				int nowMax = dp[temp[0]][temp[1]][1];
				int nr = temp[0]+deltas[d][0];
				int nc = temp[1]+deltas[d][1];
				if(!isIn(nr,nc)) continue;
				int nowNum = 0;
				int next = map[nr][nc]-'0';
				switch(temp[2]) {
				case 0:
					dp[nr][nc][0] = Math.min(dp[nr][nc][0], nowMin);
					dp[nr][nc][1] = Math.max(dp[nr][nc][1], nowMax);
					nowNum= getNum(nr,nc);
					queue.add(new int[] {nr,nc,nowNum});
					break;
				case 1:
					dp[nr][nc][0] = Math.min(dp[nr][nc][0], nowMin+next);
					dp[nr][nc][1] = Math.max(dp[nr][nc][1], nowMax+next);
					queue.add(new int[] {nr,nc,nowNum});
					break;
				case 2:
					dp[nr][nc][0] = Math.min(dp[nr][nc][0], nowMin-next);
					dp[nr][nc][1] = Math.max(dp[nr][nc][1], nowMax-next);
					queue.add(new int[] {nr,nc,nowNum});
					break;
				case 3:
					dp[nr][nc][0] = Math.min(dp[nr][nc][0], nowMin*next);
					dp[nr][nc][1] = Math.max(dp[nr][nc][1], nowMax*next);
					queue.add(new int[] {nr,nc,nowNum});
					break;
				case 4:
					if(next!=0) {
						dp[nr][nc][0] = Math.min(dp[nr][nc][0], nowMin/next);
						dp[nr][nc][1] = Math.max(dp[nr][nc][1], nowMax/next);
						queue.add(new int[] {nr,nc,nowNum});
					}
					break;
				}
				
			}
			
		}
		StringBuilder sb = new StringBuilder();
		sb.append(dp[N-1][N-1][1]).append(" ").append(dp[N-1][N-1][0]);
		System.out.println(sb);
	}
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	static int getNum(int r, int c) {
		//0:숫자 1:+ 2:- 3:* 4:/
		int result =0;
		switch(map[r][c]) {
		case '+':
			result =1;
			break;
		case '-':
			result = 2;
			break;
		case '*':
			result =3;
			break;
		case '/':
			result = 4;
			break;
			
		}
		return result;
	}

}