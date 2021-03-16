package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {
	static int N, W, H;
	static int[][] blockMap;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb  = new StringBuilder();
		
		for(int t=1;t<=T;t++) {
			int result =0;
			
			StringTokenizer st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			blockMap = new int[H][W];
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					blockMap[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			broke(blockMap, 0);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	
	static void calculate(int[][] nowMap, int[] choosed, int toChoose) {
		
		int[][] clone= new int[nowMap.length][];
		for(int i=0;i<nowMap.length;i++) {
			clone[i] = nowMap[i].clone();
		}
		for(int t=0;t<nowMap[0].length;t++) {
			choosed[choosed.length-toChoose]=t;
		}
	}
	static int[][] deltas= {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean broke(int[][] map, int t) {
		int temp = -1;
		for(int r=0;r<map.length;r++) {
			if(map[r][t]!=0) {
				temp = r;
				break;
			}
		}
		if(temp == -1) {
			return false;
		}
		setMap(map[temp][t], temp, t, map);
		
		return true;
	}
	static void setMap(int blocknum, int i, int j, int[][] map) {
		//visited[i][j] = true;
		if(blocknum ==1) {
			map[i][j]=0;
			return;
		}
		for(int d=0;d<4;d++) {
			for(int num=1;num<blocknum;num++) {
				int ni = i+(deltas[d][0]*num);
				int nj = j+(deltas[d][1]*num);
				if(isIn(ni,nj) &&map[ni][nj]!=0) {
					setMap(map[ni][nj], ni, nj, map);
				}
			}
		}
		map[i][j]=0;
		
	}
	static boolean isIn(int i,int j) {
		return i>=0 && i<blockMap.length && j>=0 && j<blockMap[0].length;
	}
}
