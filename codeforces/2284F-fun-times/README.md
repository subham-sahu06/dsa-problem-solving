# Codeforces Round 1132 (Div. 2) - F. Fun Times
**Link:** https://codeforces.com/contest/2284/problem/F
**Tags:** combinatorics, data structures, dp, math, matrices
## Problem
For a set `A` of numbers from `0` to `n - 1`, do `n - 1` steps: at step `i` every element `x` becomes
`(x + 1) mod (n - i)` (duplicates merge). `f(A)` is the sum of the mex of the set after each step.
Given a set `S` as a binary string, find the sum of `f(A)` over all supersets `A` of `S`, modulo `10^9 + 7`.
## Key idea
Look at which **starting numbers** end up on each value. After every step, the starting numbers that
land on value `0`, `1`, `2`, ... form groups that are next to each other on a circle of `0..n-1`.
Write them as a list `G_0, G_1, ..., G_(m-1)` (`m = n - i`). One step turns it into
`G_(m-2), G_(m-1) + G_0, G_1, ..., G_(m-3)`:
the last two groups go to the front, and the old last group merges with the old first one.
The mex after a step is `k` exactly when the groups `G_0 .. G_(k-1)` each contain a chosen number.
## Counting
Pick every free number (a `0` in `s`) with probability `1/2`. For a group let
`q` = probability that **nothing** in it is chosen: `0` if it has a number from `S`, else `(1/2)^size`.
Merging two groups multiplies their `q`, and `r = 1 - q` is the chance the group is hit.
The expected mex is
`V = r_0 + r_0 r_1 + r_0 r_1 r_2 + ... = r_0 (1 + r_1 (1 + r_2 (...)))`
and the answer is `2^(free) * (sum of V over all steps)`.
## Approach
Keep the `q` values in a deque, plus `V` and `P` (the product of all `r`). One step is:
1. Pop the last group: `V -= P`, then divide `P` by its `r`. Do the same for the next last group.
2. Pop the first group `a`: `V = V / r_a - 1`, divide `P` by `r_a`.
3. Push the merged group (`q = q_last * q_a`) to the front, then the second last group:
   each push does `V = r * (1 + V)` and `P *= r`.
4. When only 2 groups are left, they merge into one and `V = r` of that group.
Every `r` is `1 - (1/2)^size` or `1`, which is never `0` mod `10^9 + 7` for these sizes, so
dividing with a modular inverse is safe.
Checked against a brute force over all supersets for 300 random tests with `n <= 11`.
## Complexity
- Time: O(n log MOD) per test, because of the modular inverses
- Space: O(n)
## Solutions
- [Java](Main.java)
- [C++](solution.cpp)
- [Python](solution.py)
