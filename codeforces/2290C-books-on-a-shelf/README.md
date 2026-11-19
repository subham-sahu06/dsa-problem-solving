# 2290C - Books on a Shelf

https://codeforces.com/problemset/problem/2290/C

## Idea

A book is visible from the left only if it is strictly taller than everything before it, so the books visible from the left have strictly increasing heights and every height appears there at most once. The same holds for the right side. So each height can give at most two visible books: one seen from the left and one seen from the right. The answer can never be more than the sum of min(count, 2) over all distinct heights.

This bound is reachable:

1. Put one book of every distinct height in increasing order. All of them are visible from the left.
2. Put every copy beyond the second in the middle. The tallest book is already to their left, and a copy of their own height is to their right, so they are never visible.
3. Put one more book of every height that appears at least twice in decreasing order. All of them are visible from the right.

So k = (number of distinct heights) + (number of heights that appear at least twice).

## Complexity

O(n log n) per test case for sorting.
