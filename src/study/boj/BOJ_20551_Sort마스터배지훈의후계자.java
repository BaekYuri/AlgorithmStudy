package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20551_Sort마스터배지훈의후계자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		for (int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);
		int result = Integer.MAX_VALUE;
		for(int i=0;i<M;i++) {
			int temp = Integer.parseInt(br.readLine());
			int now = Arrays.binarySearch(nums, temp);
			if(now>=0) {
				int nr = now-1;
				while(nr>=0) {
					if(nums[nr] == temp) {
						nr--;
					}else {

						break;
					}
				}
				nr++;
				sb.append(nr).append("\n");
		
			}else {
				sb.append(-1).append("\n");;
			}
		}
		
		System.out.println(sb);
		
	}
}
