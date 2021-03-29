package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2629_양팔저울 {
	static int chooNum;//추의 개수
	static int[] choos;//각 추의 무게 저장하는 배열
	static int ballNum;//구슬 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int gramSum = 0;//모든 추의 무게를 더한 값
		chooNum = Integer.parseInt(br.readLine());
		choos = new int[chooNum];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < chooNum; i++) {
			choos[i] = Integer.parseInt(st.nextToken());
			gramSum += choos[i];
		}
		

		int dp[][] = new int[chooNum][gramSum + 1];//dp배열 생성. dp[i][j]==1이면 0~i 구슬을 이용해서 j그램을 만들수 있다는 뜻이다.
		dp[0][0] = 1;
		dp[0][choos[0]] = 1;//초기화
		for (int i = 1; i < chooNum; i++) {
			
			for (int j = 0; j < choos[i]; j++) {//현재 추의 무게 전의 값들은 이전 값들과 같다.
				dp[i][j] = dp[i-1][j];
			}
			dp[i][choos[i]] = 1;
			for (int j = choos[i] + 1; j < gramSum + 1; j++) {//i-1번 구슬까지 구했던 값을 이용해 dp배열 구하기
				dp[i][j] = dp[i-1][j];
				if(dp[i-1][j-choos[i]]==1) {
					dp[i][j] = 1;
				}
			}
		}
		ballNum = Integer.parseInt(br.readLine());//구슬 갯수 받기
		
		StringBuilder sb =new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<ballNum;i++) {
			int now = Integer.parseInt(st.nextToken()); //현재 구슬의 무게 입력받기
			boolean confirm = false;
			for(int j=0;j<dp[0].length;j++) {//만약 구슬들을 이용해 j그램을 만들수 있고, j+now 그램도 만들 수 있으면 Y이다.
				if(dp[chooNum-1][j]==1 && j+now<dp[0].length && dp[chooNum-1][j+now]==1) {
					confirm = true;
					break;
				}
			}
			if(confirm) {
				sb.append("Y").append(" ");
			}else {
				sb.append("N").append(" ");
			}
		}
		
		//출력
		System.out.println(sb);
		
	}

}