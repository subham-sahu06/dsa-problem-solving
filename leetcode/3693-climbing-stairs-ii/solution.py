class Solution:
    def climbStairs(self, n: int, costs: List[int]) -> int:
        dp = [0] + [float('inf')] * n
        for j in range(1, n + 1):
            for d in range(1, 4):
                if j - d >= 0:
                    dp[j] = min(dp[j], dp[j - d] + costs[j - 1] + d * d)
        return dp[n]
