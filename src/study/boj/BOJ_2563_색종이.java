package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] paper = new boolean[100][100]; //도화지 생성
		int count =0;
		for(int n=0;n<N;n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = 100-Integer.parseInt(st.nextToken())-10;
			
			for(int i=x;i<x+10;i++) {
				for(int j=y;j<y+10;j++) {
					if(paper[i][j]) continue; //이미 색종이가 올려져있는 부분이면 넘어간다
					paper[i][j]=true;
					count++;
				}
			}
			
		}
		System.out.println(count);
	}
}
