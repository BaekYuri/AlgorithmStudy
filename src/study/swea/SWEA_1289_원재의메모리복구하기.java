package study.swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;


/**
 * @since 2021. 2. 1.
 * @author Yuri Baek
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXdbYpT6xskDFAUO&contestProbId=AV19AcoKI9sCFAZN&probBoxId=AXdbYpUKxsoDFAUO+&type=PROBLEM&problemBoxTitle=0201&problemBoxCnt=++1+
 * @mem
 * @time
 * @caution
 */

public class SWEA_1289_원재의메모리복구하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		
		int N = Integer.parseInt(input.readLine());
		
		for(int n=1;n<=N;n++) {
			String str = input.readLine();
			int answer = 0;
			byte[] b = str.getBytes();
			for(int i=0;i<b.length;i++) {
				b[i]-=48;
			}
			byte[] tempb = new byte[b.length];
			byte temp = 0;
			for(int i=0;i<b.length;i++) {
				if((tempb[i]^b[i])==1) {
					if(tempb[i]==0) {
						temp =1;
					}else {
						temp =0;
					}
					for(int j=i;j<tempb.length;j++) {
						tempb[j]=temp;
					}

					answer++;
				}
			}

			
			output.append("#").append(n).append(" ").append(answer).append("\n");
			
		}
		System.out.println(output.toString());
	}
	
	static String src = "2\r\n"+"0011\r\n"+"100";
}
