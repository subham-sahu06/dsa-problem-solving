import java.io.*;
import java.util.*;
public class Main {
    static long gcd(long x, long y) {
        while (y != 0) {
            long t = x % y;
            x = y;
            y = t;
        }
        return x;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if (a == b) {
                out.append("0\n");
                continue;
            }
            if (gcd(a, b) == 1) {
                out.append("1\n").append(b - a).append('\n');
                continue;
            }
            long mid = -1;
            for (long c = a + 1; c < b; c++) {
                if (gcd(c, a) == 1 && gcd(c, b) == 1) {
                    mid = c;
                    break;
                }
            }
            if (mid != -1) {
                out.append("2\n").append(mid - a).append(' ').append(b - mid).append('\n');
                continue;
            }
            int len = (int) (b - a);
            int[] dist = new int[len + 1];
            int[] par = new int[len + 1];
            Arrays.fill(dist, -1);
            dist[0] = 0;
            int[] queue = new int[len + 1];
            int head = 0, tail = 0;
            queue[tail++] = 0;
            while (head < tail) {
                int u = queue[head++];
                long uv = a + u;
                for (int v = u + 1; v <= len; v++) {
                    if (dist[v] == -1 && gcd(uv, a + v) == 1) {
                        dist[v] = dist[u] + 1;
                        par[v] = u;
                        queue[tail++] = v;
                    }
                }
            }
            int k = dist[len];
            long[] steps = new long[k];
            int cur = len;
            for (int i = k - 1; i >= 0; i--) {
                steps[i] = cur - par[cur];
                cur = par[cur];
            }
            out.append(k).append('\n');
            for (int i = 0; i < k; i++) {
                if (i > 0) out.append(' ');
                out.append(steps[i]);
            }
            out.append('\n');
        }
        System.out.print(out);
    }
}
