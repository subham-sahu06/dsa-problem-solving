# 1352 - Product of the Last K Numbers

https://leetcode.com/problems/product-of-the-last-k-numbers/

## Idea

Keep prefix products of the numbers added since the last zero, starting with 1. The product of the last k numbers is the last prefix divided by the prefix k steps earlier.

A zero makes every product that includes it equal to 0, so on a zero the list is reset to [1]. If k reaches back past the last zero (k >= size of the list), the answer is 0.

Every prefix is the product of a contiguous part of the stream, so it fits in a 32-bit integer.

Checked against the example and against a brute force on 3000 random streams.

## Complexity

O(1) for both add and getProduct, O(n) memory.
