package com.company.ch9BFS;

import java.io.*;

public class No10026 {
    static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
    static int[] dc = { 0, 1, 0, -1 };
    static boolean[][] v, cv; // 방문했는지 확인
    static int N, count, ccount;
    static char[][] grid, cgrid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        // N*N 그리드
        grid = new char[N][N]; // 적록색약이 아닌 사람이 본 구역
        cgrid = new char[N][N]; // 적록색약인 사람이 본 구역

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                char col = str.charAt(j);
                grid[i][j] = col;

                //적록색약의 경우 빨간색과 초록색 구분을 못하므로 G를 R로 넣어줌
                if (col == 'G') cgrid[i][j] = 'R';
                else cgrid[i][j] = col;
            }
        }

        // 초기화
        v = new boolean[N][N]; count = 0; //적록색약이 아닌 경우
        cv = new boolean[N][N]; ccount = 0; // 적록색약인 경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j]) { // 방문하지 않았다면
                    // 적록색약이 아닌 사람
                    dfs(i, j, v, grid, grid[i][j]);
                    count++;
                }
                if (!cv[i][j]) {
                    // 적록색약인 사람
                    dfs(i, j, cv, cgrid, cgrid[i][j]);
                    ccount++;
                }
            }
        }
        System.out.println(count + " " + ccount);
    }

    static void dfs(int r, int c, boolean[][] bool, char[][] area, char color) {
        bool[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            // 좌표가 범위 안에 들어오고
            // 방문하지 않았다면
            // 이동하려는 좌표의 색이 현재와 같다면 이동
            if (0 <= nr && nr < N && 0 <= nc && nc < N && !bool[nr][nc] && area[nr][nc] == color) {
                dfs(nr, nc, bool, area, color);
            }
        }
    }
}