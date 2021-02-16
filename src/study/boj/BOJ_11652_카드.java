package study.boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BOJ_11652_카드 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Map<BigInteger, Integer> map = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T= Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			BigInteger input = new BigInteger(br.readLine());
			if(map.containsKey(input)) {
				map.put(input, map.get(input)+1);
			}else {
				map.put(input, 1);
			}
		}
//		System.out.println(map);
		List<BigInteger> list = new ArrayList<>();
		list.addAll(map.keySet());
		Collections.sort(list, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				int a1 = map.get(o1);
				int a2 = map.get(o2);
				
				return a2-a1;
			}
		});
//		System.out.println(list);
		Iterator iterator = list.iterator();
		BigInteger big = (BigInteger) iterator.next();
		List<BigInteger> tempList = new ArrayList<>();
		tempList.add(big);
		while(iterator.hasNext()) {
			BigInteger b = (BigInteger) iterator.next();
			if (map.get(big).equals(map.get(b))) {
				tempList.add(b);
			}else {
				break;
			}
		}
		Collections.sort(tempList);
//		System.out.println(tempList);
		System.out.println(tempList.get(0));
	}
}
