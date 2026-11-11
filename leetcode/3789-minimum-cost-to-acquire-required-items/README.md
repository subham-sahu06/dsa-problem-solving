# 3789. Minimum Cost to Acquire Required Items
**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-cost-to-acquire-required-items/
## Problem
A type 1 item costs `cost1` and gives 1 unit to requirement 1, a type 2 item costs `cost2` and gives
1 unit to requirement 2, and a type 3 item costs `costBoth` and gives 1 unit to both.
Return the minimum cost to get at least `need1` and `need2` units.
## Approach
If we buy `k` items of type 3, the rest is fixed:
`f(k) = k * costBoth + max(0, need1 - k) * cost1 + max(0, need2 - k) * cost2`.
`f` is a straight line between the points `0`, `min(need1, need2)` and `max(need1, need2)`, and
after `max(need1, need2)` it only grows. So the minimum is at one of these three points.
Try all three and return the smallest. Use `long`, because the answer can be about `2 * 10^15`.
Checked against trying every `k` on 20,000 random small inputs.
## Complexity
- Time: O(1)
- Space: O(1)
## Solutions
- [Java](Solution.java)
- [C++](solution.cpp)
- [Python](solution.py)
