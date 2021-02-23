package study.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class SWEA_1873_상호의배틀필드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] field;
	static StringTokenizer st;
	static int H, W;
	static int[] now = new int[2];
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int nowDeltas = 0;
	static char nowDirection;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			field = new char[H][W];

			for (int i = 0; i < field.length; i++) {
				s = br.readLine();
				for (int j = 0; j < field[i].length; j++) {
					field[i][j] = s.charAt(j);
					if (field[i][j] == '^' || field[i][j] == 'v' || field[i][j] == '<' || field[i][j] == '>') {
						now[0] = i;
						now[1] = j;
						nowDirection = field[i][j];
						if(nowDirection=='^') nowDeltas = 0;
						else if(nowDirection=='v') nowDeltas = 1;
						else if(nowDirection=='<') nowDeltas = 2;
						else nowDeltas = 3;
					}
				}
			}
			int N = Integer.parseInt(br.readLine());
			s = br.readLine();

			for (int i = 0; i < N; i++) {
				doOrder(s.charAt(i));
				
			}
			sb.append("#").append(t).append(" ");
			for(int i=0;i<field.length;i++) {
				for(int j=0;j<field[i].length;j++) {
					sb.append(field[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}

	static void doOrder(char order) {

		if (order != 'S') {
			switch (order) {
			case 'U':
				nowDirection = '^';
				nowDeltas = 0;
				break;
			case 'D':
				nowDirection = 'v';
				nowDeltas = 1;
				break;
			case 'L':
				nowDirection = '<';
				nowDeltas = 2;
				break;
			case 'R':
				nowDirection = '>';
				nowDeltas = 3;
				break;

			}
			field[now[0]][now[1]]=nowDirection;
			int nh = now[0]+deltas[nowDeltas][0];
			int nw = now[1]+deltas[nowDeltas][1];
			if (isIn(nh,nw) && field[nh][nw] == '.') {
				field[now[0]][now[1]] = '.';
				field[nh][nw] = nowDirection;
				now[0] = nh;
				now[1] = nw;
			}
		} else {
			doShoot(nowDeltas);
		}
		

	}

	static void doShoot(int direction) {
		int[] tempLoc = new int[2];
		tempLoc[0] = now[0];
		tempLoc[1] = now[1];
		while(isIn(tempLoc[0],tempLoc[1])&& (field[tempLoc[0]][tempLoc[1]]!='*' || field[tempLoc[0]][tempLoc[1]]!='#')){
			tempLoc[0]+=deltas[direction][0];
			tempLoc[1]+=deltas[direction][1];
			if(isIn(tempLoc[0],tempLoc[1]) && field[tempLoc[0]][tempLoc[1]]=='#') {
				break;
			}
			if(isIn(tempLoc[0],tempLoc[1])&&field[tempLoc[0]][tempLoc[1]]=='*') {
				field[tempLoc[0]][tempLoc[1]]='.';
				break;
			}
		}

	}

	static boolean isIn(int h, int w) {
		return h >= 0 && h < H && w >= 0 && w < W;
	}
}
