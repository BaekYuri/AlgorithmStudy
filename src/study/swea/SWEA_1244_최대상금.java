package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_1244_최대상금 {
	static Set<Numbers> visited;
	static int resultMoney;
	static int maxMoney;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder rs = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String money = st.nextToken();
			int change = Integer.parseInt(st.nextToken());
			
			char[] charArr = money.toCharArray();
			Arrays.sort(charArr);
			
			resultMoney = 0;
			visited = new HashSet<>();
			changeMoney(Integer.parseInt(money), change);
			
			rs.append("#").append(t).append(" ").append(resultMoney).append("\n");
		}
		System.out.println(rs);
	}

	public static void changeMoney(int money, int change) {
		
		Numbers now = new Numbers(money, change);

		if(visited.contains(now)) return;
		visited.add(now);
		
		if(change==0) {
			resultMoney = Math.max(now.number, resultMoney);
			return;
		}
		
		
		for(int i=0, length=Integer.toString(money).length();i<length;i++) {
			for(int j=i+1;j<length;j++) {
				char[] clone = Integer.toString(money).toCharArray();
				char temp = clone[i];
				clone[i] = clone[j];
				clone[j] = temp;
				
				changeMoney(Integer.parseInt(new String(clone)),change-1);
			}
		}
	}
	
	public static class Numbers{
		int number;
		int change;
		
		public Numbers(int number, int change) {
			super();
			this.number = number;
			this.change = change;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Numbers other = (Numbers) obj;
			if (change != other.change)
				return false;
			if (number != other.number)
				return false;
			return true;
		}

	}
}
