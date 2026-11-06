# Codeforces - B. Rhythmic String

**Link:** https://codeforces.com/contest/2283/problem/B

## Problem
A string of 10^18 zeros gets a `1` at every multiple of every kept `a_i`.
The string is *rhythmic* if it is periodic and its first period contains exactly one `1`.
Remove the fewest elements so the string becomes rhythmic.

## Key idea
- If the first period `p` has exactly one `1`, the ones are exactly the positions `r, r + p, r + 2p, ...`.
- The smallest `1` is at `d` = the smallest kept number, and `2d` is also a `1`, so the period is `d`
  and the ones must be **exactly the multiples of `d`**.
- That holds only when every kept number is a multiple of `d`
  (a number that is not a multiple of `d` would add a `1` somewhere else).
- Keeping nothing gives all zeros, which is not rhythmic, so at least one number is kept.

## Approach
Try every distinct value `d` in the array as the smallest kept number and count how many
elements are divisible by `d`. Keep the best count.

**Answer = n - max over d of (number of elements divisible by d)**

## Complexity
- Time: O(n * distinct values) <= O(n^2) per test, fine because the sum of n is at most 5000
- Space: O(n)

## Solutions
- [Java](Main.java)
- [C++](solution.cpp)
- [Python](solution.py)
