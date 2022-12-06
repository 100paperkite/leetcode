class Solution {
    public int coinChange(int[] coins, int amount) {
        int maximum = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0, dp.length, maximum);
        dp[0] = 0;

        for (int n = 1; n <= amount; n++){
            for(int coin : coins){
                if (n-coin >= 0){
                    dp[n] = Math.min(dp[n], dp[n-coin]+1);
                }
            }
        }
        
        return dp[amount] == maximum ? -1 : dp[amount];
    }
}