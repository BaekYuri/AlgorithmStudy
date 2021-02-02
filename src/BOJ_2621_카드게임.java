import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2621_카드게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] color = new int[4];
		Map<Integer, Integer> number = new HashMap<Integer, Integer>();
		for (int i = 0; i < 5; i++) {
			String getCard = br.readLine();
			StringTokenizer st = new StringTokenizer(getCard);
			
			String temp = st.nextToken();
			switch (temp) {
			case "R":
				color[0]++;
				break;
			case "B":
				color[1]++;
				break;
			case "Y":
				color[2]++;
				break;
			case "G":
				color[3]++;
				break;
			}
			
			temp = st.nextToken();
			int tempInt = Integer.parseInt(temp);
			if(!number.containsKey(tempInt)) {
				number.put(tempInt, 1);
			}else {
				number.put(tempInt, number.get(tempInt).intValue()+1);
			}
			
		}
		int bonusScore =0;
			Iterator<Integer> intKey = number.keySet().iterator();
			
			int min = intKey.next(); //Key 값으로 정렬 후 최솟값, 최댓값 구해놓기
			int max=0;
			int cnt=1;
			
			while(intKey.hasNext()) {
				max=intKey.next();
				
				cnt++;
			}
			
			bonusScore = 100+max;//9
			intKey = number.keySet().iterator();
			
			if(number.containsValue(2)) {
				
				 if(number.size()==3) {//7
					int[] tt= new int[number.size()];
					for(int a=0;a<number.size();a++) {
						tt[a] = intKey.next();
						if(number.get(tt[a]).intValue()==1) {
							tt[a]=0;
						}
					}
					int bigNum=0;
					for(int a=0;a<number.size()-1;a++) {
						bigNum = Integer.max(tt[a], tt[a+1]);
						
					}
					bonusScore = 300+(bigNum*9);
					for(int a=0;a<number.size();a++) {
						bonusScore+=tt[a];
					}
				}else {//8
					for(int a=0;a<number.size();a++) {
						int tt = intKey.next();
						if(number.get(tt).intValue()==2) {
							bonusScore = 200+tt;
							break;
						}
					}
				}
				
			}
			intKey = number.keySet().iterator();
			if(number.containsValue(3)) {//6
				for(int a=0;a<number.size();a++) {
					int tt = intKey.next();
					if(number.get(tt).intValue()==3) {
						bonusScore = 400+tt;
						break;
					}
					
				}
			}
			
			if((max-min)==4 && cnt==5) {//5
				bonusScore = 500+max;
			}
			if(number.containsValue(3)&& number.containsValue(2)) {//3
				for(int a=0;a<number.size();a++) {
					if(number.get(min).intValue()==3) {
						bonusScore = 700+(min*10)+max;
						break;
					}else {
						bonusScore = 700+(max*10)+min;
						break;
					}
				}
			}
			if(number.containsValue(4)) {//2
				for(int a=0;a<number.size();a++) {
					if(number.get(min).intValue()==4) {
						bonusScore = 800+min;
						break;
					}else {
						bonusScore = 800+max;
						break;
					}
				}
			}
			
			for(int a=0;a<4;a++) {//1, 4
				if(color[a]==5) {

					if((max-min)==4 && cnt==5) {
						bonusScore = 900+max;
						
					}else {
						bonusScore = 600+max;
						
					}
					break;

				}
			}

		
		System.out.println(bonusScore);
	}
}
