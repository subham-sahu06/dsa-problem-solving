from typing import List
class Solution:
    def smallestUniqueSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        rank = nums[:]
        k = 1
        while True:
            key = [(rank[i] << 34) | ((rank[i + k] + 1 if i + k < n else 0) << 17) | i for i in range(n)]
            key.sort()
            sa = [x & 131071 for x in key]
            new = [0] * n
            for i in range(1, n):
                new[sa[i]] = new[sa[i - 1]] + ((key[i] >> 17) != (key[i - 1] >> 17))
            rank = new
            if rank[sa[-1]] == n - 1 or k >= n:
                break
            k <<= 1
        lcp = [0] * n
        h = 0
        for i in range(n):
            if rank[i] > 0:
                j = sa[rank[i] - 1]
                while i + h < n and j + h < n and nums[i + h] == nums[j + h]:
                    h += 1
                lcp[rank[i]] = h
                if h:
                    h -= 1
            else:
                h = 0
        ans = n
        for r in range(n):
            need = max(lcp[r], lcp[r + 1] if r + 1 < n else 0) + 1
            if need <= n - sa[r]:
                ans = min(ans, need)
        return ans
