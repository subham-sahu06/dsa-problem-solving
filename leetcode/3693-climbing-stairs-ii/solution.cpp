class Solution {
public:
    int climbStairs(int n, vector<int>& costs) {
        vector<long long> dp(n + 1, LLONG_MAX);
        dp[0] = 0;
        for (int j = 1; j <= n; j++) {
            for (int d = 1; d <= 3 && j - d >= 0; d++) {
                dp[j] = min(dp[j], dp[j - d] + costs[j - 1] + 1LL * d * d);
            }
        }
        return (int) dp[n];
    }
};
