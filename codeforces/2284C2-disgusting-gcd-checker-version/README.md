# Codeforces Round 1132 (Div. 2) - C2. Disgusting + GCD (Checker Version)

**Link:** https://codeforces.com/contest/2284/problem/C2

**Tags:** brute force, dp, graphs, greedy, math, number theory

## Problem
Start with `a <= b`. One operation picks a positive `x` with `gcd(a, x) = 1` and does `a += x`.
Reach `b` with the fewest operations and print the chosen `x` values.

## Key idea
`gcd(a, x) = gcd(a, a + x)`, so an operation can move `a` to any larger number `c` with
`gcd(a, c) = 1`. The task is a shortest path `a = c0 < c1 < ... < ck = b` where every pair of
neighbours is coprime.

## Approach
1. `a == b`: 0 operations.
2. `gcd(a, b) == 1`: 1 operation, `x = b - a`.
3. Look for one middle number `a < c < b` with `gcd(c, a) = 1` and `gcd(c, b) = 1`.
   If it exists, 2 operations: `c - a` and `b - c`.
   `a * b` has at most about 15 different prime factors, so numbers coprime to both appear very
   often. If `b - a` is not tiny, such a `c` is found after only a few checks.
4. If no such `c` exists, the gap `b - a` must be very small, so run a BFS over all numbers in
   `[a, b]` (edge `u -> v` when `u < v` and `gcd(u, v) = 1`) and rebuild the shortest path.

## Complexity
- Steps 1-3: a few gcd calls per test in practice
- Step 4: O((b - a)^2 log b), only for tiny gaps

## Solutions
- [Java](Main.java)
- [C++](solution.cpp)
- [Python](solution.py)
