import java.util.Arrays;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int q = queries.length;
        Integer[] order = new Integer[q];
        for (int i = 0; i < q; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> Integer.compare(queries[a], queries[b]));

        int[] count = new int[n + 1];
        int active = 0;
        int left = 0, right = 0;
        int[] answer = new int[q];

        for (int idx : order) {
            int end = queries[idx];
            int start = end - x;

            // Add every log with time <= end.
            while (right < logs.length && logs[right][1] <= end) {
                if (count[logs[right][0]]++ == 0) {
                    active++;
                }
                right++;
            }
            // Drop every log with time < start.
            while (left < right && logs[left][1] < start) {
                if (--count[logs[left][0]] == 0) {
                    active--;
                }
                left++;
            }
            answer[idx] = n - active;
        }
        return answer;
    }
}
