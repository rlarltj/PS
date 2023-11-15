import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] tmp;
    static boolean[] used;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tmp = new int[n];
        used = new boolean[n + 1];
        sb = new StringBuilder();

        backTracking(n, 0);
        System.out.println(sb);
    }

    private static void backTracking(int n, int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                sb.append(tmp[i] + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                tmp[depth] = i;
                backTracking(n, depth + 1);
                used[i] = false;
            }
        }
    }
}
