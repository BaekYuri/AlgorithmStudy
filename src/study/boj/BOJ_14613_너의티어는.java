package study.boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14613_너의티어는 {
	static double win, lose, draw;
	static double[][] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		win = Double.parseDouble(st.nextToken());
		lose = Double.parseDouble(st.nextToken());
		draw = Double.parseDouble(st.nextToken());
		
		result = new double[20][41];
		result[0][20] = draw;
		result[0][19] = lose;
		result[0][21] = win;
		for(int i=1;i<20;i++) {
			for(int j=0;j<41;j++) {
				if(j==0) {
					result[i][0] = result[i-1][1]*lose+ result[i-1][0];
				}else if(j==40) {
					result[i][40] = result[i-1][39]*win+ result[i-1][40];
				}else {
					result[i][j] = result[i-1][j-1]*win+ result[i-1][j]*draw+ result[i-1][j+1]*lose;
				}
			}
		}
		double bronze = 0;
		double silver = 0;
		double gold = 0;
		double plat = 0;
		double dia = 0;
		for(int i=0;i<10;i++) {
			bronze += result[19][i];
		}
		for(int i=10;i<20;i++) {
			silver += result[19][i];
		}
		for(int i=20;i<30;i++) {
			gold+= result[19][i];
		}
		for(int i=30;i<40;i++) {
			plat+= result[19][i];
		}
		dia = result[19][40];
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%.8f\n%.8f\n%.8f\n%.8f\n%.8f\n", bronze, silver, gold, plat, dia));
		
		System.out.println(sb);
	}
}
