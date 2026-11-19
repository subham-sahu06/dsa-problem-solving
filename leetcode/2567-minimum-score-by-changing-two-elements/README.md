# 2567. Minimum Score by Changing Two Elements

https://leetcode.com/problems/minimum-score-by-changing-two-elements/

## Idea

The low score can always be made 0: change a number to a value that already exists in the array, so two numbers are equal. So only the high score matters, and that is max minus min.

After sorting, changing a number only helps if it is one of the ends, and the best is to set it equal to a number that stays. With two changes there are three ways to cut the ends:

1. change the two smallest: nums[n-1] - nums[2]
2. change the two largest: nums[n-3] - nums[0]
3. change the smallest and the largest: nums[n-2] - nums[1]

The answer is the minimum of these three.

## Complexity

O(n log n) time for sorting, O(1) extra memory.
