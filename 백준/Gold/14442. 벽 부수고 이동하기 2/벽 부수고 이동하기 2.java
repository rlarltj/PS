import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[][] map;
    static boolean[][][] visit;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        backTracking();
    }

    private static void backTracking() {
        Queue<Point> qu = new LinkedList<>();
        qu.offer(new Point(0, 0, 0, 1));
        visit[0][0][0] = true;

        while (!qu.isEmpty()) {
            Point now = qu.poll();

            if (now.x == n - 1 && now.y == m - 1) {
                System.out.println(now.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 0 && !visit[nx][ny][now.boom]) {
                    visit[nx][ny][now.boom] = true;
                    qu.offer(new Point(nx, ny, now.boom, now.count + 1));
                } else {
                    if (now.boom < k && !visit[nx][ny][now.boom + 1]) {
                        visit[nx][ny][now.boom + 1] = true;
                        qu.offer(new Point(nx, ny, now.boom + 1, now.count + 1));
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static class Point{
        int x;
        int y;
        int boom;
        int count;

        public Point(int x, int y, int boom, int count) {
            this.x = x;
            this.y = y;
            this.boom = boom;
            this.count = count;
        }
    }
}
