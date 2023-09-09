import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static Queue<Point> qu;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        qu = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < m; i++) {
            if (map[0][i] == 0) {
                map[0][i] = 2;

                qu.offer(new Point(0, i));
            }
        }

        bfs(n, m);

        boolean flag = false;

        for (int i = 0; i < m; i++) {
            if (map[n - 1][i] == 2) {
                flag = true;
            }
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void bfs(int n, int m) {
        boolean[][] visit = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            visit[0][i] = true;
        }

        while (!qu.isEmpty()) {
            Point now = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (!visit[nx][ny] && map[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    map[nx][ny] = 2;
                    qu.offer(new Point(nx, ny));
                }
            }
        }
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
