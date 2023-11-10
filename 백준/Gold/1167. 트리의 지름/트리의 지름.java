import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Node>[] nodes;
    static boolean[] visit;
    static int max = 0;
    static int maxIdx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nodes = new ArrayList[n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());

            int to = 0;
            int cost = 0;

            while(true){
                to = Integer.parseInt(st.nextToken());

                if(to == -1) break;
                cost = Integer.parseInt(st.nextToken());
                nodes[from].add(new Node(to, cost));
            }

        }

        dfs(1, 0);
        visit = new boolean[n + 1];
        dfs(maxIdx, 0);
        System.out.println(max);
    }

    private static void dfs(int start, int distance) {
        visit[start] = true;
        if (max < distance) {
            max = distance;
            maxIdx = start;
        }

        ArrayList<Node> nodeList = nodes[start];
        for (Node next: nodeList) {
            if (!visit[next.to]) {
                visit[next.to] = true;
                dfs(next.to, distance + next.cost);
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
