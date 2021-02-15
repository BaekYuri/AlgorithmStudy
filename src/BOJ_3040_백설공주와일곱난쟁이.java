import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_3040_백설공주와일곱난쟁이 {
	static int[] dwarf=new int[9];
	static boolean selected = false;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0;t<9;t++) {
			dwarf[t] = Integer.parseInt(br.readLine());

		}
		combination(7,new int[7],0,0);
		
	}
	
	static void combination(int toChoose, int[] choosed,int startIdx,int score) {
		if(selected) return; //이미 난쟁이가 정해졌다면 그냥 종료
		if(toChoose ==0) {
			if(score ==100) {//조합된 난쟁이값의 합이 100이면 이게 답이다.
				StringBuilder sb = new StringBuilder();
				for(int a: choosed) {
					sb.append(a).append("\n");
				}
				selected = true;
				System.out.println(sb);
			}
			return;
		}
		for(int i=startIdx; i<dwarf.length;i++) {
			choosed[choosed.length-toChoose] = dwarf[i];
			combination(toChoose-1, choosed, i+1, score+dwarf[i]);
		}
	}
	

}
