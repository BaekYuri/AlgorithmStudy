package study.boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11497_통나무건너뛰기 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T= Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]= Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int left=0, right=0;
			int start = N-1;
			int result[] = new int[N];
			if(N%2==0) {
				left = N/2-1;
				right = N/2;
				start = N-3;
				result[left] = arr[N-1];
				result[right] = arr[N-2];
			}else {
				left = N/2;
				right = N/2;
				start = N-2;
				result[left] = arr[N-1];
			}
			
			for(int s = start, x=0; s>=0 ; s--, x++) {
				if(x%2==0) {
					result[--left] = arr[s];
				}else {
					result[++right] = arr[s];
				}
			}
			
			int dis = Math.abs(result[0]-result[N-1]);
			for(int i=0;i<N-1;i++) {
				dis = Math.max(dis, Math.abs(result[i]-result[i+1]));
			}
			
			sb.append(dis).append("\n");
		}
		System.out.println(sb);
	}
}