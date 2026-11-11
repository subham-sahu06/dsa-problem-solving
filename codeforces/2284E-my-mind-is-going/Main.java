import java.io.*;
import java.util.*;
public class Main {
    static DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static int nextInt() throws IOException {
        int r = 0, b = in.read();
        while (b != '-' && (b < '0' || b > '9')) b = in.read();
        boolean neg = false;
        if (b == '-') {
            neg = true;
            b = in.read();
        }
        while (b >= '0' && b <= '9') {
            r = r * 10 + (b - '0');
            b = in.read();
        }
        return neg ? -r : r;
    }
    static int[] buf;
    static boolean ask(int[] a, int la, int[] b, int lb) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("? 1 ").append(la + lb);
        for (int i = 0; i < la; i++) sb.append(' ').append(a[i]);
        for (int i = 0; i < lb; i++) sb.append(' ').append(b[i]);
        out.println(sb);
        out.flush();
        int r = nextInt();
        if (r == -1) {
            out.close();
            System.exit(0);
        }
        return r == 0;
    }
    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt(), m = nextInt();
            int[] eu = new int[m], ev = new int[m], deg = new int[n + 1];
            for (int i = 0; i < m; i++) {
                eu[i] = nextInt();
                ev[i] = nextInt();
                deg[eu[i]]++;
                deg[ev[i]]++;
            }
            int[][] adj = new int[n + 1][];
            for (int v = 1; v <= n; v++) adj[v] = new int[deg[v]];
            int[] fill = new int[n + 1];
            for (int i = 0; i < m; i++) {
                adj[eu[i]][fill[eu[i]]++] = ev[i];
                adj[ev[i]][fill[ev[i]]++] = eu[i];
            }
            int[] order = new int[n], pos = new int[n + 1];
            boolean[] seen = new boolean[n + 1];
            int cnt = 0;
            for (int s = 1; s <= n; s++) {
                if (seen[s]) continue;
                seen[s] = true;
                int head = cnt;
                order[cnt++] = s;
                while (head < cnt) {
                    int u = order[head++];
                    for (int w : adj[u]) {
                        if (!seen[w]) {
                            seen[w] = true;
                            order[cnt++] = w;
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) pos[order[i]] = i;
            int lo = 1, hi = n;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (ask(order, mid, order, 0)) hi = mid;
                else lo = mid + 1;
            }
            int x = order[lo - 1];
            int[] bord = new int[n];
            boolean[] inB = new boolean[n + 1];
            int bl = 0;
            inB[x] = true;
            bord[bl++] = x;
            int head = 0;
            while (head < bl) {
                int u = bord[head++];
                for (int w : adj[u]) {
                    if (!inB[w]) {
                        inB[w] = true;
                        bord[bl++] = w;
                    }
                }
            }
            int[] rest = new int[n];
            int rl = 0;
            int start = n;
            for (int i = 0; i < n; i++) {
                if (!inB[order[i]]) rest[rl++] = order[i];
                else start = Math.min(start, i);
            }
            lo = 1;
            hi = bl;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (ask(rest, rl, bord, mid)) hi = mid;
                else lo = mid + 1;
            }
            int x2 = bord[lo - 1];
            int bpart = lo;
            lo = 1;
            hi = start;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (ask(order, mid, bord, bpart)) hi = mid;
                else lo = mid + 1;
            }
            int y = order[lo - 1];
            if (x == x2) {
                out.println("! " + x + " " + y);
                out.flush();
                continue;
            }
            out.println("? 2 " + x + " " + y);
            out.flush();
            int r = nextInt();
            if (r == -1) {
                out.close();
                System.exit(0);
            }
            if (r == 1) out.println("! " + x + " " + y);
            else out.println("! " + x2 + " " + y);
            out.flush();
        }
        out.close();
    }
}
