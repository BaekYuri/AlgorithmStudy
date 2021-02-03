import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072_게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		long X = Integer.parseInt(st.nextToken());
		long Y = Integer.parseInt(st.nextToken());
		//double형 썼다가 망함... 다신 쓰지 말자 
		long percent = (Y * 100) / X;
		
		long percentNow = percent;
		long result = 0;

		long tempX = 0;
		long tempY = 0;
		long tempEnd = 1000000000;
		long tempStart = 1;
		long temS = tempStart, temE = tempEnd;
		if (percentNow >= 99) {
			result = -1;
		} else {
			while (true) {
				tempX = X + temE;
				tempY = Y + temE;
				percent = (tempY * 100) / tempX;
	
				long percentTemp = percent;
				if (percentNow < percentTemp) {
					tempEnd = temE;
					temE = temE / 2;
					
				} else {
					break; 
				}
			}

			while (true) {
				tempX = X + temS;
				tempY = Y + temS;
				percent = (tempY * 100) / tempX;
				long percentTemp = percent;
			
				if (percentNow >= percentTemp) {
					tempStart = temS;
					temS = temS * 2;
				} else {
					break;
				}
			}

			for (long i = tempStart; i <= tempEnd; i++) {
				tempX = X + i;
				tempY = Y + i;
				percent = (tempY * 100) / tempX;
				long percentTemp = percent;
	
				if (percentNow < percentTemp) {
					result = i;
					break;
				}
			}
		}

		System.out.println(result);
	}
}
