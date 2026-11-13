class Solution:
    def countNonDecreasingSubarrays(self, nums: List[int], k: int) -> int:
        n = len(nums)
        dq = deque()
        cost = 0
        ans = 0
        j = n - 1
        for i in range(n - 1, -1, -1):
            cnt = 1
            while dq and dq[0][0] <= nums[i]:
                v, c = dq.popleft()
                cost += (nums[i] - v) * c
                cnt += c
            dq.appendleft([nums[i], cnt])
            while cost > k:
                cost -= dq[-1][0] - nums[j]
                dq[-1][1] -= 1
                if dq[-1][1] == 0:
                    dq.pop()
                j -= 1
            ans += j - i + 1
        return ans
