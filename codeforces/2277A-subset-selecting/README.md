# Codeforces Round 1129 (Div. 2) - A. Subset Selecting

**Link:** https://codeforces.com/contest/2277/problem/A

**Tags:** greedy

## Problem
Split some elements of `a` into groups, each with at least `k` elements (an element can be left out).
Maximize `mex` of the set of group maximums.

## Key idea
To get `mex = m` we need groups whose maximums are exactly `0, 1, ..., m - 1`.
- A group with maximum `v` needs one element equal to `v` and `k - 1` more elements that are `<= v`.
- So for every `v < m`:
  - the value `v` must appear at least once, and
  - the groups for `0..v` use `(v + 1) * k` elements, all `<= v`, so
    `count(elements <= v) >= (v + 1) * k`.

These two conditions are also enough: build the groups for `v = 0, 1, 2, ...` in order, each time
taking one copy of `v` and any `k - 1` unused elements `<= v`.

## Approach
Count every value, then walk `v = 0, 1, 2, ...` with a running prefix count. Stop at the first `v`
where `v` is missing or the prefix count is less than `(v + 1) * k`. The answer is that `v`.

## Complexity
- Time: O(n) per test
- Space: O(n)

## Solutions
- [Java](Main.java)
- [C++](solution.cpp)
- [Python](solution.py)
