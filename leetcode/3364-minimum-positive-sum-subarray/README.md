# 3364. Minimum Positive Sum Subarray
**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-positive-sum-subarray/
## Problem
Find the minimum sum of a subarray whose length is between `l` and `r` (inclusive) and whose sum is
greater than 0. Return -1 if there is no such subarray.
## Approach
`n` is at most 100, so we can try every subarray. For each start `i`, extend the end `j` while the
length is at most `r`, keeping a running sum. When the length is at least `l` and the sum is positive,
update the answer.
## Complexity
- Time: O(n * r)
- Space: O(1)
## Solutions
- [Java](Solution.java)
- [C++](solution.cpp)
- [Python](solution.py)
