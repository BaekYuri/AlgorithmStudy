package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9536_여우는어떻게울지 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		String input = br.readLine();
		List<String> shout = new ArrayList<>();
		StringTokenizer st= new StringTokenizer(input);
		while(st.hasMoreTokens()) {
			shout.add(st.nextToken());
		}
		
		String s;
		while((s=br.readLine())!=null && s!="what does the fox say?") {
			st= new StringTokenizer(s);
			st.nextToken();
			st.nextToken();
			String animalShout = st.nextToken();
			while(shout.remove(animalShout)) {
			}
			
		}
		StringBuilder sb= new StringBuilder();
		for(String out : shout) {
			sb.append(out).append(" ");
		}
		System.out.println(sb);
	}

}
