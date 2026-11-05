from bisect import bisect_left
from typing import List
class Solution:
    def findTheDistanceValue(self, arr1: List[int], arr2: List[int], d: int) -> int:
        arr2.sort()
        count = 0
        for a in arr1:
            i = bisect_left(arr2, a - d)
            if i == len(arr2) or arr2[i] > a + d:
                count += 1
        return count
