import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        st.resetSyntax();
        st.wordChars(33, 126);
        st.whitespaceChars(0, 32);
        st.nextToken();
        String mode = st.sval;
        st.nextToken();
        int t = Integer.parseInt(st.sval);
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            if (mode.equals("first")) {
                st.nextToken();
                int n = Integer.parseInt(st.sval);
                st.nextToken();
                String s = st.sval;
                List<int[]> edges = new ArrayList<>();
                int w = -1;
                for (int v = 2; v <= n; v++) {
                    if (s.charAt(v - 2) == '1') {
                        w = v;
                        break;
                    }
                }
                if (w == -1) {
                    edges.add(new int[]{1, 2});
                    edges.add(new int[]{2, 3});
                    edges.add(new int[]{1, 3});
                    for (int v = 4; v <= n; v++) edges.add(new int[]{v - 1, v});
                } else {
                    for (int v = 2; v <= n; v++) {
                        if (s.charAt(v - 2) == '1') edges.add(new int[]{1, v});
                        else edges.add(new int[]{w, v});
                    }
                }
                out.append(edges.size()).append('\n');
                for (int[] e : edges) out.append(e[0]).append(' ').append(e[1]).append('\n');
            } else {
                st.nextToken();
                int n = Integer.parseInt(st.sval);
                st.nextToken();
                int m = Integer.parseInt(st.sval);
                List<List<Integer>> adj = new ArrayList<>();
                for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
                for (int i = 0; i < m; i++) {
                    st.nextToken();
                    int u = Integer.parseInt(st.sval);
                    st.nextToken();
                    int v = Integer.parseInt(st.sval);
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
                int[] color = new int[n + 1];
                Arrays.fill(color, -1);
                color[1] = 0;
                ArrayDeque<Integer> q = new ArrayDeque<>();
                q.add(1);
                boolean ok = true;
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int x : adj.get(u)) {
                        if (color[x] == -1) {
                            color[x] = color[u] ^ 1;
                            q.add(x);
                        } else if (color[x] == color[u]) {
                            ok = false;
                        }
                    }
                }
                for (int v = 2; v <= n; v++) out.append(ok ? (char) ('0' + color[v]) : '0');
                out.append('\n');
            }
        }
        System.out.print(out);
    }
}
