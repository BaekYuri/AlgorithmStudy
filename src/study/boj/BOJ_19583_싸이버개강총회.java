package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_19583_싸이버개강총회{

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringTokenizer stTime;
		Set<String> member = new HashSet<>();
		
		Date[] date = new Date[3];
		
		int[][] time = new int[3][2];
		for(int i=0;i<3;i++) {
			
			String temp = st.nextToken();
			stTime = new StringTokenizer(temp,":");
			int hour = Integer.parseInt(stTime.nextToken());
			int minute = Integer.parseInt(stTime.nextToken());
			date[i] = new Date(0, 0, 0, hour, minute);
		}
		
		String input = "";
		int count =0;
		while((input = br.readLine())!=null) {
			st = new StringTokenizer(input);
			String temp = st.nextToken();
			stTime = new StringTokenizer(temp,":");
			int hour = Integer.parseInt(stTime.nextToken());
			int minute = Integer.parseInt(stTime.nextToken());
			Date tempDate = new Date(0, 0, 0, hour, minute);
			String id = st.nextToken();
			if(tempDate.before(date[0]) 
					|| tempDate.equals(date[0])) {
				member.add(id);
			}

			if((tempDate.after(date[1]) && tempDate.before(date[2])) || tempDate.equals(date[1])|| tempDate.equals(date[2])) {
				if(member.isEmpty()) break;
				if(member.remove(id)) {
					count++;
				}
			}

		}
		
		System.out.println(count);
	}
}
