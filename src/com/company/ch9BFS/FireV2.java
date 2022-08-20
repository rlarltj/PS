//package com.company.ch9BFS;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class FireV2 {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken(" "));
//        int m = Integer.parseInt(st.nextToken(" "));
//        String[][] map = new String[n][m];
//        Queue<Point> jq = new LinkedList<>();
//        Queue<Point> fq = new LinkedList<>();
//
//        int[] dx = {1, 0 , -1 , 0};
//        int[] dy = {0, 1 , 0 , -1};
//
//        int[][] dist1 = new int[n][m];
//        int[][] dist2 = new int[n][m];
//
//        for (int i = 0; i < n; i++) {
//            String[] s = br.readLine().split("");
//            for (int j = 0; j < m; j++) {
//                map[i][j] = s[j];
//
//                if(map[i][j].equals("F")){
//                    fq.offer(new Point(i, j));
//                    dist1[i][j] = 1;
//                }else if(map[i][j].equals("J")){
//                    jq.offer(new Point(i, j));
//                    dist2[i][j] = 1;
//                }else if(map[i][j].equals(".")){
//                    dist1[i][j] = -1;
//                    dist2[i][j] = -1;
//                }
//            }
//        }
//
//        // 불 BFS
//        while(!fq.isEmpty()){
//            Point p = fq.poll();
//
//            for(int i =0 ;i<4; i++){
//                int nx = p.x+dx[i];
//                int ny = p.y+dy[i];
//
//
//                if(nx<0|| nx>= n || ny<0 || ny>= m) continue;
//
//                if(map[nx][ny].equals("#")) continue;
//                dist1[nx][ny] = dist1[p.x][p.y]+1;
//                fq.offer(new Point(nx, ny));
//            }
//        }
//
//        // 지훈 BFS
//
//        while(!jq.isEmpty()){
//            Point p = jq.poll();
//
//
//            for (int i = 0; i < 4; i++) {
//                int nx = p.x+dx[i];
//                int ny = p.y+dy[i];
//
//                if(nx<0 || nx>=n || ny<0 || ny>=m){
//                    System.out.println(dist2[nx][ny]);
//                    return;
//                }
//
//                if(map[nx][ny].equals("#")) continue;
//                if(dist2[nx][ny] >= 1) continue;
//
//                if(dist1[nx][ny] != -1 )
//            }
//        }
//
//
//    }
//
//    public static class Point{
//        int x;
//        int y;
//
//        public Point(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }
//}
