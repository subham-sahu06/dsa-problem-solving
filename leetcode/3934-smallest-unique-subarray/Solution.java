import java.util.*;
class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int[] sa = new int[n], rank = new int[n], tmp = new int[n];
        long[] key = new long[n];
        for (int i = 0; i < n; i++) rank[i] = nums[i];
        for (int k = 1; ; k <<= 1) {
            for (int i = 0; i < n; i++) {
                long second = i + k < n ? rank[i + k] + 1 : 0;
                key[i] = ((long) rank[i] << 34) | (second << 17) | i;
            }
            Arrays.sort(key);
            for (int i = 0; i < n; i++) sa[i] = (int) (key[i] & 131071);
            tmp[sa[0]] = 0;
            for (int i = 1; i < n; i++) tmp[sa[i]] = tmp[sa[i - 1]] + ((key[i] >>> 17) != (key[i - 1] >>> 17) ? 1 : 0);
            System.arraycopy(tmp, 0, rank, 0, n);
            if (rank[sa[n - 1]] == n - 1 || k >= n) break;
        }
        int[] lcp = new int[n];
        for (int i = 0, h = 0; i < n; i++) {
            if (rank[i] > 0) {
                int j = sa[rank[i] - 1];
                while (i + h < n && j + h < n && nums[i + h] == nums[j + h]) h++;
                lcp[rank[i]] = h;
                if (h > 0) h--;
            } else h = 0;
        }
        int ans = n;
        for (int r = 0; r < n; r++) {
            int need = Math.max(lcp[r], r + 1 < n ? lcp[r + 1] : 0) + 1;
            if (need <= n - sa[r]) ans = Math.min(ans, need);
        }
        return ans;
    }
}
