# 2289C - Problem from Ust-Katav

https://codeforces.com/problemset/problem/2289/C

## Idea

All values in a permutation are different, so two subarrays can only clash when they have the same minimum value. For each value p_i, look at the subarrays whose minimum is p_i. They lie strictly between the previous smaller element at l and the next smaller element at r, and they contain i.

Let a = i - l, b = r - i and W = r - l - 1. The number of subarrays of length L with minimum p_i is min(a, b, L, W - L + 1). A subarray is good exactly when this count is 1.

- If min(a, b) = 1, the count is 1 for every length from 1 to W, so p_i gives W good subarrays.
- Otherwise the count is 1 only for L = 1 and L = W, so p_i gives 2 good subarrays.

The previous and next smaller elements come from a monotonic stack. The answer can reach about n^2 / 2, so it is stored in a 64-bit integer.

Checked against the sample and a brute force on 4800 random permutations.

## Complexity

O(n) per test.
