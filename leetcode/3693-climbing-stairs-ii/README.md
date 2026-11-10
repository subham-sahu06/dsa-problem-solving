# 3693. Climbing Stairs II
**Difficulty:** Medium
**Link:** https://leetcode.com/problems/climbing-stairs-ii/
## Problem
There are steps `0..n` and `costs[i]` is the cost of step `i` (1-indexed). From step `i` you can jump
to `i + 1`, `i + 2` or `i + 3`, and jumping from `i` to `j` costs `costs[j] + (j - i)^2`.
Start at step 0 with cost 0 and return the minimum total cost to reach step `n`.
## Approach
`dp[j]` = minimum cost to stand on step `j`, with `dp[0] = 0`. Step `j` can only be reached from
`j - 1`, `j - 2` or `j - 3`, so
`dp[j] = min(dp[j - d] + costs[j] + d^2)` for `d = 1, 2, 3`.
The answer is `dp[n]`.
## Complexity
- Time: O(n)
- Space: O(n)
## Solutions
- [Java](Solution.java)
- [C++](solution.cpp)
- [Python](solution.py)
