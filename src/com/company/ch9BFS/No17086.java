package com.company.ch9BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17086 {
    static int N, M, answer = -1;
    static int[][] map;
    static boolean[][] visited;
    static int[][] move = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}}; // 이동 방향 배열

    static int bfs(int row, int col) {
        visited = new boolean[N + 1][M + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col, 0});
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int j = 0; j < 8; j++) { // 방향별로 움직여주자
                int newRow = cur[0] + move[j][0];
                int newCol = cur[1] + move[j][1];
                int newDist = cur[2] + 1;

                if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= M || visited[newRow][newCol])
                    continue;

                if (map[newRow][newCol] == 1)
                    return newDist;
                q.add(new int[]{newRow, newCol, newDist});
                visited[newRow][newCol] = true;
            }
        }
        return 0;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(bfr.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1)
                    continue;
                int tmp = bfs(i, j);
                answer = tmp > answer ? tmp : answer;
            }
        }
        System.out.println(answer);
    }
}
