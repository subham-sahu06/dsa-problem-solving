# 3934 - Smallest Unique Subarray

https://leetcode.com/problems/smallest-unique-subarray/

## Idea

Treat the array as a string and build its suffix array and LCP array.

A subarray that starts at i with length L appears somewhere else exactly when another suffix shares its first L elements. The suffixes that share the most with suffix i are its two neighbours in suffix-array order, so the subarray is unique exactly when L is greater than both neighbour LCP values. The shortest unique subarray starting at i therefore has length max(lcp with previous, lcp with next) + 1, as long as that still fits inside the array. The answer is the minimum of this over all i. The whole array is always unique, so an answer exists.

The suffix array is built by prefix doubling: each round packs (rank, rank k ahead, index) into one long and sorts. Kasai's algorithm gives the LCP array in O(n).

Checked against the examples and a brute force on 3000 random arrays.

## Complexity

O(n log^2 n) time, O(n) space.
