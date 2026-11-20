# 3041. Maximize Consecutive Elements in an Array After Modification

https://leetcode.com/problems/maximize-consecutive-elements-in-an-array-after-modification/

## Idea

Sort the array. Let dp[v] be the length of the longest run of consecutive values that ends at value v, using the numbers seen so far.

Each number x can become x or x + 1:

1. Use it as x + 1: dp[x + 1] = dp[x] + 1
2. Use it as x: dp[x] = dp[x - 1] + 1

Update dp[x + 1] first, because it needs the old dp[x] (the run built before this number). Sorting makes sure every smaller value is processed before it is needed. The answer is the largest dp value seen.

## Complexity

O(n log n) time for sorting, O(max value) extra memory for dp.
