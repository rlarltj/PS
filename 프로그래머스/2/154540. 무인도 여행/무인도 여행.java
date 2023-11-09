import java.util.*;

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] visit;
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        int height = maps.length;
        int width = maps[0].length();
        
        map = new int[height][width];
        visit = new boolean[height][width];
        
        for(int i =0; i<height; i++) {
            String line = maps[i];
            
            for(int j = 0; j<width; j++) {
                if(line.charAt(j) == 'X') {
                    map[i][j] = -1;
                 }else {
                    map[i][j] = line.charAt(j) - '0';
                }
            }
        }

        for(int i = 0; i<height; i++) {
            for(int j = 0; j<width; j++) {
                if(map[i][j] == -1) continue;
                if(visit[i][j]) continue;
                        
                int count = bfs(new Point(i, j), width, height);
                answer.add(count);
            }
        }
        Collections.sort(answer);
        
        if(answer.size() == 0) {
            return new int[]{-1};
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    private int bfs(Point point, int width, int height) {
        int result = 0;
        Queue<Point> qu = new LinkedList();
        visit[point.x][point.y] = true;
        qu.offer(point);
        
        while(!qu.isEmpty()) {
            Point now = qu.poll();
            result += map[now.x][now.y];

            for(int i = 0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= height || ny >= width || visit[nx][ny]) {
                    continue;
                }
                
                if(map[nx][ny] == -1) continue;
                
                qu.offer(new Point(nx, ny));
                visit[nx][ny] = true;
            }
        }
        
        return result;
    }
    
    static class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}