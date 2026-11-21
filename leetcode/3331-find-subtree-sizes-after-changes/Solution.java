import java.util.*;
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        int[] head = new int[n], nxt = new int[n];
        Arrays.fill(head, -1);
        for (int i = n - 1; i >= 1; i--) {
            nxt[i] = head[parent[i]];
            head[parent[i]] = i;
        }
        int[] last = new int[26], prev = new int[n], np = new int[n], order = new int[n], stack = new int[2 * n];
        Arrays.fill(last, -1);
        int top = 0, cnt = 0;
        stack[top++] = 0;
        while (top > 0) {
            int v = stack[--top];
            if (v < 0) {
                int u = ~v;
                last[s.charAt(u) - 'a'] = prev[u];
                continue;
            }
            int c = s.charAt(v) - 'a';
            order[cnt++] = v;
            np[v] = v == 0 ? -1 : (last[c] != -1 ? last[c] : parent[v]);
            prev[v] = last[c];
            last[c] = v;
            stack[top++] = ~v;
            for (int ch = head[v]; ch != -1; ch = nxt[ch]) stack[top++] = ch;
        }
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = n - 1; i >= 1; i--) {
            int u = order[i];
            ans[np[u]] += ans[u];
        }
        return ans;
    }
}
