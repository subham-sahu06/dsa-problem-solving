class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long[] val = new long[n];
        long[] cnt = new long[n];
        int head = n, tail = n;
        long cost = 0, ans = 0;
        int j = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            long c = 1;
            while (head < tail && val[head] <= nums[i]) {
                cost += (nums[i] - val[head]) * cnt[head];
                c += cnt[head];
                head++;
            }
            head--;
            val[head] = nums[i];
            cnt[head] = c;
            while (cost > k) {
                cost -= val[tail - 1] - nums[j];
                cnt[tail - 1]--;
                if (cnt[tail - 1] == 0) tail--;
                j--;
            }
            ans += j - i + 1;
        }
        return ans;
    }
}
