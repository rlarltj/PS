import java.util.*;
 
public class Main {
    
    static int n, l, r;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<Point> list; //인구 이동이 필요한 노드 리스트
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);    
 
        n = scan.nextInt();
        l = scan.nextInt();
        r = scan.nextInt();
        
        board = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = scan.nextInt();
            }
        }
        
        System.out.println(move());
    }
    
    public static int move() { //더 이상 인구이동이 일어나지 않을 때까지 반복
        int result = 0;
        while(true) {
            boolean isMove = false;
            visited = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j]) {
                        int sum = bfs(i, j); //bfs탐색으로 열릴 수 있는 국경선 확인 하며 인구 이동할 총 인구수 반환
                        if(list.size() > 1) {
                            changePopulation(sum); //열린 국경선 내의 노드들 인구 변경
                            isMove = true;
                        }    
                    }
                }
            }
            if(!isMove) return result;;
            result++;
        }
    }
    
    public static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        list = new ArrayList<>();
        
        q.offer(new Point(x, y));
        list.add(new Point(x, y));
        visited[x][y] = true;
        
        int sum = board[x][y];
        while(!q.isEmpty()) {
            Point current = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    int diff = Math.abs(board[current.x][current.y] - board[nx][ny]);
                    
                    if(l <= diff && diff <= r) {
                        q.offer(new Point(nx, ny));
                        list.add(new Point(nx, ny));
                        sum += board[nx][ny];
                        visited[nx][ny] = true;
                    }        
                }
            }
        }
        return sum;
    }
    
    public static void changePopulation(int sum) {
        int avg = sum / list.size();
        for(Point p : list) {
            board[p.x][p.y] = avg;
        }
    }
    
    public static class Point {
        int x; 
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
