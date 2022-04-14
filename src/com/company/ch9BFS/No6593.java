    package com.company.ch9BFS;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.StringTokenizer;

    public class No6593 {
        private static int l, r, c;
        private static char[][][] map;
        private static int[][][] time;
        private static boolean[][][] visit;
        private static boolean flag = false;

        private static int[] dz = {-1, 0, 0, 1, 0, 0};
        private static int[] dy = {0, -1, 1, 0, 0, 0};
        private static int[] dx = {0, 0, 0, 0, -1, 1};

        private static int endZ = 0;
        private static int endY = 0;
        private static int endX = 0;

        private static ArrayList<String> list = new ArrayList<String>();

        public static void main(String[] args) throws IOException {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                flag = false;
                StringTokenizer st = new StringTokenizer(reader.readLine());

                if(!st.hasMoreTokens())
                    st = new StringTokenizer(reader.readLine());

                l = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                if (l == 0 && r == 0 && c == 0) {
                    break;
                }

                map = new char[l][r][c];
                time = new int[l][r][c];
                visit = new boolean[l][r][c];

                int startZ = 0;
                int startY = 0;
                int startX = 0;

                for (int i=0; i<l; i++) {
                    for (int j=0; j<r; j++) {
                        String input = reader.readLine();

                        if(input.equals(""))
                            input = reader.readLine();

                        for (int k=0; k<c; k++) {
                            map[i][j][k] = input.charAt(k);

                            if (map[i][j][k] == 'S') {
                                startZ = i;
                                startY = j;
                                startX = k;
                            } else if (map[i][j][k] == 'E') {
                                endZ = i;
                                endY = j;
                                endX = k;
                            }

                        }
                    }
                }

                bfs(startZ, startY, startX);

                if (!flag) {
                    list.add("Trapped!");
                }
            }

            for (String st : list) {
                System.out.println(st);
            }

        }


        private static void bfs(int startZ, int startY, int startX) {

            Queue<Building> q = new LinkedList();
            q.add(new Building(startZ, startY, startX));
            visit[startZ][startY][startX] = true;

            while (!q.isEmpty()) {

                Building bd = q.remove();
                int qz = bd.l;
                int qy = bd.r;
                int qx = bd.c;

                if (qz == endZ && qy == endY && qx == endX) {
                    //E만나면 종료
                    list.add("Escaped in " + time[qz][qy][qx] + " minute(s).");
                    flag = true;
                    return;
                }

                for (int i=0; i<dx.length; i++) {
                    int nz = qz + dz[i];
                    int ny = qy + dy[i];
                    int nx = qx + dx[i];

                    if (nz < 0 || ny < 0 || nx < 0 || nz >= l || ny >= r || nx >= c) {
                        continue;
                    }

                    if (map[nz][ny][nx] != '#' && !visit[nz][ny][nx]) {
                        // 방문x, ., 시간 -1(미방문)
                        visit[nz][ny][nx] = true;
                        time[nz][ny][nx] = time[qz][qy][qx] + 1;
                        q.add(new Building(nz, ny, nx));
                    }

                }
            }


        }
    }


    class Building {
        int l, r, c;
        Building(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }