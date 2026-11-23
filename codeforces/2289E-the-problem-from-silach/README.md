# 2289E - The Problem from Silach

https://codeforces.com/problemset/problem/2289/E

## Idea

For a subtree let S be the set of athletes that can win it. Athlete a can win a match against the winner of the other subtree if some w in S(other) satisfies a < w (a is stronger) or a - w < d. Both cases reduce to one test: a < max(S(other)) + d.

So S(match) = { x in S(left) : x < max(S(right)) + d } united with { y in S(right) : y < max(S(left)) + d }. Filtering always removes the largest elements, so each set is a max-heap. An athlete removed at match k has played every match from its leaf up to k, which is depth(leaf) - depth(k) matches. Athletes still in the root set play depth(leaf) matches.

The other subtree's outcome does not affect anything higher up, so these local checks give the true maximum.

Heaps are merged small to large.

Checked against a brute force that tries every outcome of every match (4500 random trees with n <= 7) and the sample.

## Complexity

O(n log^2 n) per test. n = 2 * 10^5 runs in about 0.1 s in C++.
