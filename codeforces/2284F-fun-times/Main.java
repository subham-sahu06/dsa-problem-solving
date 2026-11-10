import java.io.*;
import java.util.*;
public class Main {
    static final long MOD = 1_000_000_007L;
    static long power(long b, long e) {
        b %= MOD;
        long r = 1;
        while (e > 0) {
            if ((e & 1) == 1) r = r * b % MOD;
            b = b * b % MOD;
            e >>= 1;
        }
        return r;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();
        long inv2 = (MOD + 1) / 2;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            int free = 0;
            long[] q = new long[2 * n + 2];
            int head = n, tail = n;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    q[tail++] = 0;
                } else {
                    q[tail++] = inv2;
                    free++;
                }
            }
            long v = 0, prod = 1;
            for (int i = tail - 1; i >= head; i--) {
                long r = (1 - q[i] + MOD) % MOD;
                v = r * (1 + v) % MOD;
                prod = prod * r % MOD;
            }
            long total = 0;
            for (int m = n; m >= 2; m--) {
                if (m == 2) {
                    long merged = q[head] * q[tail - 1] % MOD;
                    head = tail - 1;
                    q[head] = merged;
                    v = (1 - merged + MOD) % MOD;
                    prod = v;
                } else {
                    long z = q[--tail];
                    v = (v - prod + MOD) % MOD;
                    prod = prod * power(1 - z + MOD, MOD - 2) % MOD;
                    long y = q[--tail];
                    v = (v - prod + MOD) % MOD;
                    prod = prod * power(1 - y + MOD, MOD - 2) % MOD;
                    long a = q[head++];
                    long ia = power(1 - a + MOD, MOD - 2);
                    v = (v * ia % MOD - 1 + MOD) % MOD;
                    prod = prod * ia % MOD;
                    long merged = z * a % MOD;
                    long r = (1 - merged + MOD) % MOD;
                    v = r * (1 + v) % MOD;
                    prod = prod * r % MOD;
                    q[--head] = merged;
                    long ry = (1 - y + MOD) % MOD;
                    v = ry * (1 + v) % MOD;
                    prod = prod * ry % MOD;
                    q[--head] = y;
                }
                total = (total + v) % MOD;
            }
            out.append(total * power(2, free) % MOD).append('\n');
        }
        System.out.print(out);
    }
}
