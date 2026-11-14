# Codeforces Round 1134 (Div. 4) - G1. Lakeside Trail (Easy Version)
**Link:** https://codeforces.com/problemset/problem/2290/G1
**Tags:** binary search, brute force, math
## Problem
`n` sections lie on a circle with heights `h_1 .. h_n`. The steepness is the largest absolute difference
between two neighbouring sections (section `n` and section `1` are also neighbours). We can add at most `k`
units of soil (heights only go up). Find the minimum possible steepness.
## Note
The easy version only has smaller limits (`n <= 2000`, sum of `n <= 2000`). The same solution as G2 works here.
## Key idea
If steepness `D` is possible with some amount of soil, every bigger `D` is possible with the same soil,
so we can **binary search** on `D`.
For a fixed `D`, the cheapest valid heights are
`a_i = max over all j of (h_j - D * dist(i, j))`,
where `dist` is the distance around the circle. Every section must be at least this high, because a
section `j` that is `dist` steps away forces it up by at most `D` per step, and these heights already
satisfy the rule. So the cost for `D` is `sum(a_i - h_i)`.
## Approach
1. `cost(D)`: start with `a = h`. Walk around the circle **twice** forward doing
   `a_i = max(a_i, a_(i-1) - D)`, then twice backward doing `a_i = max(a_i, a_(i+1) - D)`.
   Two laps make sure the effect of every section reaches all others in both directions.
2. Binary search `D` between `0` and the current steepness for the smallest `D` with `cost(D) <= k`.
   Stop adding to the cost as soon as it goes above `k`.
Checked against a brute force over every way to place the soil (1,500 random tests with `n <= 5`).
## Complexity
- Time: O(n log(max h)), about 30 binary search steps of O(n)
- Space: O(n)
## Solutions
- [Java](Main.java)
- [C++](solution.cpp)
- [Python](solution.py)
