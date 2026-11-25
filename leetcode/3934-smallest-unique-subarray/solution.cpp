class Solution {
public:
    int smallestUniqueSubarray(vector<int>& nums) {
        int n = nums.size();
        vector<int> sa(n), rnk(n), tmp(n);
        vector<long long> key(n);
        for (int i = 0; i < n; i++) rnk[i] = nums[i];
        for (int k = 1; ; k <<= 1) {
            for (int i = 0; i < n; i++) {
                long long second = i + k < n ? rnk[i + k] + 1 : 0;
                key[i] = ((long long)rnk[i] << 34) | (second << 17) | i;
            }
            sort(key.begin(), key.end());
            for (int i = 0; i < n; i++) sa[i] = key[i] & 131071;
            tmp[sa[0]] = 0;
            for (int i = 1; i < n; i++) tmp[sa[i]] = tmp[sa[i - 1]] + ((key[i] >> 17) != (key[i - 1] >> 17));
            rnk = tmp;
            if (rnk[sa[n - 1]] == n - 1 || k >= n) break;
        }
        vector<int> lcp(n, 0);
        for (int i = 0, h = 0; i < n; i++) {
            if (rnk[i] > 0) {
                int j = sa[rnk[i] - 1];
                while (i + h < n && j + h < n && nums[i + h] == nums[j + h]) h++;
                lcp[rnk[i]] = h;
                if (h > 0) h--;
            } else h = 0;
        }
        int ans = n;
        for (int r = 0; r < n; r++) {
            int need = max(lcp[r], r + 1 < n ? lcp[r + 1] : 0) + 1;
            if (need <= n - sa[r]) ans = min(ans, need);
        }
        return ans;
    }
};
