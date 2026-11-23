import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = readInt(in);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = readInt(in), d = readInt(in);
            int m = 2 * n - 1;
            int[] a = new int[m + 1], b = new int[m + 1], dep = new int[m + 1], id = new int[m + 1], ans = new int[n + 1];
            for (int k = n + 1; k <= m; k++) {
                a[k] = readInt(in);
                b[k] = readInt(in);
            }
            for (int k = m; k > n; k--) {
                dep[a[k]] = dep[k] + 1;
                dep[b[k]] = dep[k] + 1;
            }
            IntMaxHeap[] pq = new IntMaxHeap[n + 1];
            for (int i = 1; i <= n; i++) {
                pq[i] = new IntMaxHeap();
                pq[i].push(i);
                id[i] = i;
            }
            for (int k = n + 1; k <= m; k++) {
                int x = id[a[k]], y = id[b[k]];
                int mx = pq[x].top(), my = pq[y].top();
                while (pq[x].size > 0 && pq[x].top() >= my + d) {
                    int v = pq[x].pop();
                    ans[v] = dep[v] - dep[k];
                }
                while (pq[y].size > 0 && pq[y].top() >= mx + d) {
                    int v = pq[y].pop();
                    ans[v] = dep[v] - dep[k];
                }
                if (pq[x].size < pq[y].size) {
                    int tmp = x;
                    x = y;
                    y = tmp;
                }
                for (int i = 0; i < pq[y].size; i++) pq[x].push(pq[y].h[i]);
                pq[y] = null;
                id[k] = x;
            }
            IntMaxHeap r = pq[id[m]];
            for (int i = 0; i < r.size; i++) ans[r.h[i]] = dep[r.h[i]];
            for (int i = 1; i <= n; i++) sb.append(ans[i]).append(i == n ? '\n' : ' ');
        }
        System.out.print(sb);
    }
    static class IntMaxHeap {
        int[] h = new int[2];
        int size = 0;
        void push(int v) {
            if (size == h.length) h = Arrays.copyOf(h, size * 2);
            int i = size++;
            while (i > 0) {
                int p = (i - 1) >> 1;
                if (h[p] >= v) break;
                h[i] = h[p];
                i = p;
            }
            h[i] = v;
        }
        int top() {
            return h[0];
        }
        int pop() {
            int res = h[0], v = h[--size];
            int i = 0;
            while (true) {
                int c = 2 * i + 1;
                if (c >= size) break;
                if (c + 1 < size && h[c + 1] > h[c]) c++;
                if (h[c] <= v) break;
                h[i] = h[c];
                i = c;
            }
            if (size > 0) h[i] = v;
            return res;
        }
    }
    private static int readInt(DataInputStream in) throws IOException {
        int r = 0, b = in.read();
        while (b < '0') b = in.read();
        while (b >= '0') {
            r = r * 10 + b - '0';
            b = in.read();
        }
        return r;
    }
}
