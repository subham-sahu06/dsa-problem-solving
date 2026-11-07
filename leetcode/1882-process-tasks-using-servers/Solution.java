import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<long[]> free = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0])
                    : a[1] != b[1] ? Long.compare(a[1], b[1]) : Long.compare(a[2], b[2]));

        for (int i = 0; i < servers.length; i++) {
            free.add(new long[]{servers[i], i});
        }

        int m = tasks.length;
        int[] ans = new int[m];
        long time = 0;

        for (int j = 0; j < m; j++) {
            time = Math.max(time, j);
            if (free.isEmpty()) {
                time = Math.max(time, busy.peek()[0]);
            }
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] s = busy.poll();
                free.add(new long[]{s[1], s[2]});
            }
            long[] s = free.poll();
            ans[j] = (int) s[1];
            busy.add(new long[]{time + tasks[j], s[0], s[1]});
        }
        return ans;
    }
}
