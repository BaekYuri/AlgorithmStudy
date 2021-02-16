package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309_일곱난쟁이 {
	static int[] dwarf;
	static boolean isFound = false;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dwarf = new int[9];
		for(int i=0;i<9;i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(dwarf);
		
		combination(7,new int[7],0,0);
	}
	private static void combination(int toChoose, int[] choosed, int startIdx, int score) {
		if(isFound) {
			return;
		}
		if(toChoose == 0) {
			if(score == 100) {
				isFound = true;
				StringBuilder sb = new StringBuilder();
				for(int i=0;i<7;i++) {
					sb.append(choosed[i]).append("\n");
				}
				System.out.println(sb);
			}
			return;
		}
		for(int i= startIdx; i<dwarf.length;i++) {
			choosed[choosed.length-toChoose] = dwarf[i];
			combination(toChoose-1, choosed, i+1, score+ choosed[choosed.length-toChoose]);
		}
		
	}
	
}
