# 2289D - Problem from Yuzhnouralsk

https://codeforces.com/problemset/problem/2289/D

## Idea

Look at the prefix sums p_k = a_1 + ... + a_k. An operation at index i changes a_{i-1}, a_i and a_{i+1} so that p_{i-1} and p_i swap places and every other prefix sum stays the same (this also holds for i = n).

So the operations are exactly adjacent swaps on p_1..p_n, while p_0 = 0 stays fixed. All elements are nonnegative exactly when 0, p_1, ..., p_n is nondecreasing.

- If any prefix sum is negative, it can never be placed after p_0 = 0, so the answer is -1.
- Otherwise the answer is the minimum number of adjacent swaps that sorts p, which is the number of pairs i < j with p_i > p_j (inversions), counted with merge sort.

Prefix sums reach 2 * 10^14, so 64-bit integers are used.

Checked against the sample and a BFS over all operation sequences on 4000 random small arrays.

## Complexity

O(n log n) per test.
