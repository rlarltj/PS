import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;

    static int MIN = Integer.MAX_VALUE;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visit = new boolean[n + 1];
        map = new int[n + 1][n + 1];

        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int cost = Integer.parseInt(st.nextToken());
                map[i][j] = cost;
            }
        }

        //1. 플로이드 와샬

        //2. 백트래킹
        for (int i = 1; i <= n; i++) {
            visit[i] = true;
            backTracking(i, i, 0, 0);
        }

        System.out.println(MIN);
    }

    private static void backTracking(int start, int now, int depth, int cost) {
        if (depth == n - 1 && map[now][start] != 0) {
            MIN = Math.min(MIN, cost + map[now][start]);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i] && map[now][i] != 0) {
                visit[i] = true;
                backTracking(start, i, depth + 1, cost + map[now][i]);
                visit[i] = false;
            }
        }
    }

    static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
