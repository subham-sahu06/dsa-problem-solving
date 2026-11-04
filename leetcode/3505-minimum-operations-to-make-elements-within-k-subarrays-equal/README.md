# 3505. Minimum Operations to Make Elements Within K Subarrays Equal

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/

## Problem
Given an array `nums` and integers `x` and `k`, one operation increases or decreases any element by 1.
Return the minimum number of operations so that there are at least `k` non-overlapping subarrays
of size exactly `x` where all elements inside each subarray are equal.

## Approach
1. **Cost of one window:** to make `x` numbers equal with the fewest +1/-1 moves, move all of them
   to the **median**. Cost = (median * count_below - sum_below) + (sum_above - median * count_above).
2. **Sliding window median:** slide a window of size `x` over the array. A Fenwick tree over the
   compressed values keeps the count and sum of the numbers in the window, so the median and both
   sums come out in O(log n).
3. **Pick k windows (DP):** `dp[j][i]` = minimum cost using the first `i` elements with `j` windows.
   Either skip element `i` (`dp[j][i-1]`) or end a window at `i` (`dp[j-1][i-x] + cost[i-x]`).

## Complexity
- Time: O(n log n + n * k)
- Space: O(n)
