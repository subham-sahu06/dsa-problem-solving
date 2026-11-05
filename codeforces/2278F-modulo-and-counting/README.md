# Codeforces Round 1131 (Div. 3) - F. Modulo and Counting

**Link:** https://codeforces.com/contest/2278/problem/F

**Tags:** dp, math, number theory

## Problem
Count arrays `m + 2 >= a1 >= a2 >= ... >= an >= 1` such that
`(a1 mod a2) + (a2 mod a3) + ... + (a(n-1) mod an) = m`, modulo 998244353.

## Key observations
1. When `a >= b`, `a mod b <= a - b`. So the sum of all mods is at most
   `a1 - an <= (m + 2) - 1 = m + 1`. The sum must be exactly `m`, so the total "loss"
   `(a1 - an) - m` is 0 or 1.
2. The loss of one step is `(a - b) - (a mod b) = (q - 1) * b` where `q = a // b`.
   - Loss 0 means `b <= a < 2b`.
   - Loss 1 is only possible for the step `2 -> 1`.
3. A step `a -> 1` with no loss needs `a = 1`, so the only valid shapes are:
   - start at `m + 2`, every step has `b <= a < 2b`, and the array ends at `2`, or
   - the same thing, then a single `2 -> 1` step, then only 1s.
   In both cases the part from `m + 2` down to `2` follows the rule `b <= a < 2b`.

## Counting
Look only at the distinct values: a strict chain `m + 2 = v0 > v1 > ... > vk = 2` with
`v(i+1) > v(i) / 2`. Let `g(k)` be the number of such chains with `k` steps (a DP with prefix sums).

A chain with `k + 1` distinct values can be spread over the array in `C(n, k + 1)` ways
(this counts both shapes together, with or without the trailing 1s, using the hockey-stick identity).

**Answer = sum over k of g(k) * C(n, k + 1)**

## Complexity
- Time: O(m * min(n, m)) per test (the sums of n and m are at most 4000)
- Space: O(m)
