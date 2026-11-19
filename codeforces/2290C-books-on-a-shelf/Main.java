import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = nextInt(in);
            int[] h = new int[n];
            for (int i = 0; i < n; i++) h[i] = nextInt(in);
            Arrays.sort(h);
            int[] left = new int[n], mid = new int[n], right = new int[n];
            int l = 0, m = 0, r = 0;
            int i = 0;
            while (i < n) {
                int j = i;
                while (j < n && h[j] == h[i]) j++;
                left[l++] = h[i];
                if (j - i >= 2) right[r++] = h[i];
                for (int k = i + 2; k < j; k++) mid[m++] = h[i];
                i = j;
            }
            sb.append(l + r).append('\n');
            for (int k = 0; k < l; k++) sb.append(left[k]).append(' ');
            for (int k = 0; k < m; k++) sb.append(mid[k]).append(' ');
            for (int k = r - 1; k >= 0; k--) sb.append(right[k]).append(' ');
            sb.setLength(sb.length() - 1);
            sb.append('\n');
        }
        System.out.print(sb);
    }
    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0, b = in.read();
        while (b < '0') b = in.read();
        while (b >= '0') {
            ret = ret * 10 + b - '0';
            b = in.read();
        }
        return ret;
    }
}
