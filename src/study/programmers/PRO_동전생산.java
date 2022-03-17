package study.programmers;


public class PRO_동전생산 {
	static public int solution(int money, int[] costs) {
		int[] dp = new int[money+1];
		int[] coins = new int[] {1,5,10,50,100,500};
		
		for(int i=1;i<=money;i++) {
			dp[i] = dp[i-1] + costs[0];
		}
		
		for(int i=1;i<6;i++) {
			for(int j=coins[i];j<=money;j++) {
				dp[j] = Math.min(dp[j], dp[j-coins[i]]+costs[i]);
			}
		}
		
        return dp[money];
    }
	
	public static void main(String[] args) {
		System.out.println(solution(4578, new int[] {1,4,99,35,50,1000}));
	}
}
