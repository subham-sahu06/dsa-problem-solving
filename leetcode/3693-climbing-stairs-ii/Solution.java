class Solution {
    public int climbStairs(int n, int[] costs) {
        long[] dp = new long[n + 1];
        for (int j = 1; j <= n; j++) {
            dp[j] = Long.MAX_VALUE;
            for (int d = 1; d <= 3 && j - d >= 0; d++) {
                dp[j] = Math.min(dp[j], dp[j - d] + costs[j - 1] + (long) d * d);
            }
        }
        return (int) dp[n];
    }
}
