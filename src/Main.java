import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new StringReader(src));
		
		List<String> shout = new ArrayList<>();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String getShout = br.readLine();
			StringTokenizer st = new StringTokenizer(getShout);
			List<String> animalShout = new ArrayList<>();
			while(st.hasMoreTokens()) {
				shout.add(st.nextToken());
			}
			while(true) {
				getShout = br.readLine();
				if(getShout.equals("what does the fox say?")) {
					break;
				}else {
					st = new StringTokenizer(getShout);
					String[] animal = getShout.split(" ");
					while(st.hasMoreTokens()) {
						if(shout.contains(st.nextToken())) {
							
						}
					}
					
					animalShout.add(animal[2]);
					
				}
			}
			shout.removeAll(animalShout);
			
			for(String str : shout) {
				sb.append(str).append(" ");
			}
			
			System.out.println(sb.toString());
			
		}
	}
	static String src = "1\r\n" + 
			"toot woof wa ow ow ow pa blub blub pa toot pa blub pa pa ow pow toot\r\n" + 
			"dog goes woof\r\n" + 
			"fish goes blub\r\n" + 
			"elephant goes toot\r\n" + 
			"seal goes ow\r\n" + 
			"what does the fox say?";
}
