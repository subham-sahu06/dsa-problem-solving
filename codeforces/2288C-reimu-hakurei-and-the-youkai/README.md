# 2288C - Reimu Hakurei and the Youkai

https://codeforces.com/problemset/problem/2288/C

## Idea

Youkai i dies after h_i = ceil(a_i / x) hits. Keep the youkai with the largest h alive and never hit it. Then every attack is automatically a proper subset, because that youkai is always left out.

Sort the other n - 1 values: b_1 <= b_2 <= ... <= b_{n-1}. Kill them one per attack in this order, hitting each one only in the b_i attacks that end with its death. The i-th youkai can die at attack i only if b_i <= i. Attacks that kill nobody cost one spell card, so the answer is max(0, b_i - i) over all i.

This is also a lower bound: in the first b_i - 1 attacks only youkai with a smaller h can die, and there are at most i - 1 of them, so at least b_i - i of those attacks kill nobody.

Checked against a brute force over all attack sequences on random small cases.

## Complexity

O(n log n) per test case because of the sort.
