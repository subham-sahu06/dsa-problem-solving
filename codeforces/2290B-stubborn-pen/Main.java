import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            br.readLine();
            String s = br.readLine().trim();
            char cur = 'R';
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur != c) ans++;
                cur = c == 'R' ? 'B' : 'R';
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
