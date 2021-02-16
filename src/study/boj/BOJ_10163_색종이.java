package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] paper = new boolean[101][101];
		int N = Integer.parseInt(br.readLine());

		
		
		int from[][] = new int[N][2];
		int length[][] = new int[N][2];
		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			from[i][0] = Integer.parseInt(st.nextToken());
			from[i][1] = Integer.parseInt(st.nextToken());
			length[i][0] = Integer.parseInt(st.nextToken());
			length[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i=N-1;i>=0;i--) {
			for (int x = from[i][0]; x < from[i][0] + length[i][0]; x++) {
				for (int y = from[i][1]; y < from[i][1] + length[i][1]; y++) {
					if (paper[x][y])
						continue;
					paper[x][y] = true;
					result[i]++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int a: result) {
			sb.append(a).append("\n");
		}
		System.out.println(sb);
	}
}
