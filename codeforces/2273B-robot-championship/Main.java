import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            List<Integer> seq = new ArrayList<>();
            int time = 0;
            for (int target = 0; target < 3; target++) {
                int v = 2 * n;
                while (((v - time) % 3 + 3) % 3 != target) {
                    v--;
                }
                while (true) {
                    seq.add(v);
                    time++;
                    if (v <= 4) break;
                    v -= 2;
                }
            }
            out.append(seq.size()).append('\n');
            for (int i = 0; i < seq.size(); i++) {
                if (i > 0) out.append(' ');
                out.append(seq.get(i));
            }
            out.append('\n');
        }
        System.out.print(out);
    }
}
