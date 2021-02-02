import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int comNum= Integer.parseInt(br.readLine());
		boolean[] isVirus = new boolean[comNum+1];
		isVirus[1]=true;
		int lineNum = Integer.parseInt(br.readLine());
		int[][] comLine = new int[lineNum][2];
		
		
		LinkedList<Integer> comList = new LinkedList<>();
		
		
		
		StringTokenizer st;
		
		for(int i=0;i<lineNum;i++) {
			String getLine = br.readLine();
			st = new StringTokenizer(getLine);
			
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			comList.add(x, y);
		}
		
		Arrays.sort(comLine, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) {
		    	return o1[0] - o2[0];
		    }
		});
		if(comLine[0][0]!=1) {
			Arrays.sort(comLine, new Comparator<int[]>() {
			    @Override
			    public int compare(int[] o1, int[] o2) {
			    	return o1[1] - o2[1];
			    }
			});
		}

		
//		for(int i=0;i<lineNum;i++) {
//			if(isVirus[comLine[i][0]]){
//				isVirus[comLine[i][1]] = true;
//			}
//			if(isVirus[comLine[i][1]]){
//				isVirus[comLine[i][0]] = true;
//			}
//		}
//		int count =0;
//		for(int i=2;i<isVirus.length;i++) {
//			if(isVirus[i]) {
//				count++;
//			}
//		}
//		System.out.println(count);
		
	}
}
