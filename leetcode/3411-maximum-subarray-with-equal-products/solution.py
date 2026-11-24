from math import gcd
from typing import List
class Solution:
    def maxLength(self, nums: List[int]) -> int:
        n, ans = len(nums), 0
        for i in range(n):
            prod, g, l = 1, 0, 1
            for j in range(i, n):
                x = nums[j]
                prod *= x
                g = gcd(g, x)
                l = l // gcd(l, x) * x
                if prod == l * g:
                    ans = max(ans, j - i + 1)
                if prod > 25200:
                    break
        return ans
