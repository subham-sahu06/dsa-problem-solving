# 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
**Difficulty:** Easy
**Link:** https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/
## Problem
Return the length of the longest subarray of `nums` that is strictly increasing or strictly decreasing.
## Approach
Walk through the array and keep two counters:
- `inc`: length of the strictly increasing run ending here
- `dec`: length of the strictly decreasing run ending here
If `nums[i] > nums[i - 1]`, `inc` grows and `dec` resets to 1. If it is smaller, the opposite.
If they are equal, both reset to 1. The answer is the largest value either counter reaches.
## Complexity
- Time: O(n)
- Space: O(1)
## Solutions
- [Java](Solution.java)
- [C++](solution.cpp)
- [Python](solution.py)
