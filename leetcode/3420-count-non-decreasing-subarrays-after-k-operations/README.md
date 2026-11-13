# 3420. Count Non-Decreasing Subarrays After K Operations
**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/
## Problem
For each subarray of `nums`, we may add 1 to any element of that subarray up to `k` times
(each subarray is handled on its own). Count the subarrays that can be made non-decreasing.
## Key idea
The cheapest way to make `nums[l..r]` non-decreasing is to raise every element to the running maximum
from `l`. So the cost is `sum(max(nums[l..i]) - nums[i])` for `i = l .. r`. This cost only grows when the
subarray grows on either side, so for every left end `l` the valid right ends form a prefix `l .. j`,
and `j` never moves right when `l` moves left. That allows a two pointer sweep.
## Approach
Move the left end `i` from right to left and keep the window `i .. j`. Store the running maximums of the
window as blocks `(value, count)` in a deque, from left to right.
1. Add `nums[i]` at the front: every front block with value `<= nums[i]` now has running maximum
   `nums[i]`, so add `(nums[i] - value) * count` to the cost and merge it into the new block.
2. While the cost is above `k`, drop `nums[j]` from the right: subtract `(last block value - nums[j])`,
   decrease the last block's count, and move `j` left.
3. All subarrays `i .. i`, `i .. i+1`, ..., `i .. j` are valid, so add `j - i + 1` to the answer.
Each element enters and leaves the deque at most once.
Checked against a brute force on 20,000 random small arrays.
## Complexity
- Time: O(n)
- Space: O(n)
## Solutions
- [Java](Solution.java)
- [C++](solution.cpp)
- [Python](solution.py)
