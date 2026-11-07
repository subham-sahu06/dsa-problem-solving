import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        st.nextToken();
        int t = (int) st.nval;
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            st.nextToken();
            int n = (int) st.nval;
            st.nextToken();
            int k = (int) st.nval;
            int[] cnt = new int[n + 1];
            for (int i = 0; i < n; i++) {
                st.nextToken();
                cnt[(int) st.nval]++;
            }

            int mex = 0;
            int prefix = 0;
            for (int v = 0; v <= n; v++) {
                prefix += cnt[v];
                if (cnt[v] == 0 || prefix < (v + 1) * k) {
                    break;
                }
                mex = v + 1;
            }
            out.append(mex).append('\n');
        }
        System.out.print(out);
    }
}
