import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072_게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		double percent = 1.0 * Y / X;
		percent *= 100;
		int percentNow = (int) percent;
		long result = 0;

		long tempX = 0;
		long tempY = 0;
		long tempEnd = 1000000000;
		long tempStart = 0;
		if (percentNow >= 99) {
			result = -1;
		} else {
			while (true) {
				tempX = X + tempEnd;
				tempY = Y + tempEnd;
				percent = 1.0 * tempY / tempX;
				percent *= 100;
				int percentTemp = (int) percent;
				if (percentNow < percentTemp) {
					tempEnd = tempEnd/2 +1;
//					System.out.println(tempEnd);
				} else {
					if(tempEnd==0) tempEnd=1;
					tempStart = tempEnd;
					tempEnd= tempEnd*2 + 1;
//					
					break;
				}
			}
//			long nowTempStart=tempStart;
//			while(true) {
//				
//				tempX = X + nowTempStart;
//				tempY = Y + nowTempStart;
//				percent = 1.0 * tempY / tempX;
//				percent *= 100;
//				int percentTemp = (int) percent;
//
//				if (percentNow >= percentTemp) {
//					if(nowTempStart+1>=tempEnd) {
//						System.out.println(tempStart+ " "+tempEnd);
//						break;
//					}
//					tempStart = (nowTempStart+tempEnd)/2+1;
//					nowTempStart=tempStart;
//	
//				} else {
//					System.out.println(tempStart+ " "+tempEnd);
//					break;
//				}
//			}
			
			for (long i = tempStart; i <= tempEnd+1; i++) {
				tempX = X + i;
				tempY = Y + i;
				percent = 1.0 * tempY / tempX;
				percent *= 100;
				int percentTemp = (int) percent;
				if (percentNow < percentTemp) {
					result = i;
					break;
				}
			}
		}

		System.out.println(result);
	}
}
