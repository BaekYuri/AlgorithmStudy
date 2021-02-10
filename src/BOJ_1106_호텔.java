import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1106_호텔 {
	static List<Integer> city;
	static int C, N;
	static int minValue = Integer.MAX_VALUE;
	static Map<Integer, Integer> cityMap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());// 최소 인원
		N = Integer.parseInt(st.nextToken());// 도시 개수
		city = new ArrayList<Integer>();
		cityMap = new HashMap<>();
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int b =  Integer.parseInt(st.nextToken());
			int a =  Integer.parseInt(st.nextToken());
			if(cityMap.containsKey(a) && cityMap.get(a)<b) {
				continue;
			}
			cityMap.put(a, b);
		}
		city.addAll(cityMap.keySet());
		
		Collections.sort(city,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		choise(0,C,0);
		
		System.out.println(minValue);
	}

	static void choise(int index,int nowPerson,int nowMoney) {
		if(index == city.size() ||nowPerson<=0 ||nowMoney>=minValue) {
			return;
		}
		int first = city.get(index); //현재 인덱스 고객의 수
		int number = nowPerson / first;
		number = nowPerson % first != 0 ? number + 1 : number; //최대 고를수 있는 숫자
		
		int money =cityMap.get(first);
		for(int i=number;i>=0;i--) {
			
			int tempPerson = first*i;
			if(nowPerson<=tempPerson) {
				minValue = Integer.min(minValue, nowMoney + (i * money));
				continue;
			}else {
				choise(index+1, nowPerson-tempPerson, nowMoney + (i * money));
			}
		}
	}
}
