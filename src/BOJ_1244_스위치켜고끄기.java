import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244_스위치켜고끄기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st ;
	static boolean[] switches;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			String sw = br.readLine();
			st = new StringTokenizer(sw);
			switches = new boolean[st.countTokens()];
			int i = 0;
			
			while(st.hasMoreTokens()) {
				if(st.nextToken().equals("1")) {
					switches[i++]=true;
				}
			}
			int stuCnt = Integer.parseInt(br.readLine());
			for(int cnt=0;cnt<stuCnt;cnt++) {
				
			}
			
			
		}
	}
}
