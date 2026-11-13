class Solution {
public:
    long long countNonDecreasingSubarrays(vector<int>& nums, int k) {
        int n = nums.size();
        deque<pair<long long, long long>> dq;
        long long cost = 0, ans = 0;
        int j = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            long long cnt = 1;
            while (!dq.empty() && dq.front().first <= nums[i]) {
                cost += (nums[i] - dq.front().first) * dq.front().second;
                cnt += dq.front().second;
                dq.pop_front();
            }
            dq.push_front({nums[i], cnt});
            while (cost > k) {
                cost -= dq.back().first - nums[j];
                if (--dq.back().second == 0) dq.pop_back();
                j--;
            }
            ans += j - i + 1;
        }
        return ans;
    }
};
