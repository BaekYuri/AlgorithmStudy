import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958_OX퀴즈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String s = br.readLine();
			int score =0;
			int count =1;
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='O') {
					score+=count;
					count++;
				}else {
					count =1;
				}
			}
			
			System.out.println(score);
		}
	}
}
