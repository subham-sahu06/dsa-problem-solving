# 3411 - Maximum Subarray With Equal Products

https://leetcode.com/problems/maximum-subarray-with-equal-products/

## Idea

Try every start index and extend to the right while keeping the running product, GCD and LCM of the subarray. Whenever product == GCD * LCM, update the answer.

All values are between 1 and 10, so the LCM is at most lcm(1..10) = 2520 and the GCD is at most 10. GCD * LCM can never be more than 25200. The product never decreases as the subarray grows, so once it passes 25200 no longer subarray from this start can match, and we stop. This also keeps the product inside a 64-bit integer.

Checked against the examples and a brute force on 3000 random arrays.

## Complexity

O(n^2 log 10) time, O(1) extra space.
