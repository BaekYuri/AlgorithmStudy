import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2108_통계학 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		int[] max = new int[8001];

		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;

		for (int n = 0; n < N; n++) {
			int temp = Integer.parseInt(br.readLine());
			sum += temp;
			list.add(temp);
			max[temp+4000]++;
		}

	
//		double avg = (double) (sum) / N;
//		System.out.println(avg);
//		System.out.println(avg);
//		avg/=100;
//		avg = Math.round(avg);


		sb.append((int)Math.round((double) sum / (double) N)).append("\n");

		Collections.sort(list);

		sb.append(list.get(list.size() / 2)).append("\n");
		
		
		int tempValue = 0;
		List<Integer> tempList = new ArrayList<>();
		for(int i=0;i<max.length;i++) {
			tempValue = Integer.max(tempValue, max[i]);
		}
		for(int i=0;i<max.length;i++) {
			if(tempValue == max[i]) {
				tempList.add(i-4000);
			}
		}
		
		if(tempList.size()>1) {
			Collections.sort(tempList);
			
			sb.append(tempList.get(1)).append("\n");
		}else {
			sb.append(tempList.get(0)).append("\n");
		}
	

		sb.append(list.get(list.size() - 1)-list.get(0));

		System.out.println(sb.toString());
	}

}

