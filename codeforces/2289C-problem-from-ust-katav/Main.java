import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = readInt(in);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = readInt(in);
            int[] p = new int[n + 2], left = new int[n + 2], right = new int[n + 2], st = new int[n + 2];
            for (int i = 1; i <= n; i++) p[i] = readInt(in);
            int top = 0;
            for (int i = 1; i <= n; i++) {
                while (top > 0 && p[st[top - 1]] > p[i]) top--;
                left[i] = top > 0 ? st[top - 1] : 0;
                st[top++] = i;
            }
            top = 0;
            for (int i = n; i >= 1; i--) {
                while (top > 0 && p[st[top - 1]] > p[i]) top--;
                right[i] = top > 0 ? st[top - 1] : n + 1;
                st[top++] = i;
            }
            long ans = 0;
            for (int i = 1; i <= n; i++) {
                int a = i - left[i], b = right[i] - i;
                ans += Math.min(a, b) == 1 ? right[i] - left[i] - 1 : 2;
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
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
