import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static StringBuilder sb;
    static int[] tmp;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        tmp = new int[m + 1];
        used = new boolean[n + 1];
        backTracking(0, m);

        System.out.println(sb);
    }

    private static void backTracking(int depth, int length) {
        if (depth == length) {
            for (int i = 0; i < length; i++) {
                sb.append(tmp[i] + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                tmp[depth] = i;
                backTracking(depth + 1, length);
                used[i] = false;
            }
        }
    }
}
