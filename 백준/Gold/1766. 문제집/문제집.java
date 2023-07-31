import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static StringBuilder sb;
    static List<List<Integer>> lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lists = new ArrayList<>();
        sb = new StringBuilder();

        for (int i = 0; i <= n; i++) {
            lists.add(i, new ArrayList<>());
        }
        int[] degree = new int[n + 1];

        int a, b;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            //a는 b보다 먼저 풀어야 좋다.
            lists.get(a).add(b);
            degree[b] ++;
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(lists.get(i));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) { // 먼저 풀어야하는 문제가 없는 경우
                pq.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int now = pq.poll();
            sb.append(now + " ");

            // now와 연결된 문제가 있는지 확인.
            for (int next : lists.get(now)) {
                // now에 해당하는 문제를 풀었기때문에
                // next보다 먼저 풀어야하는 문제의 개수가 1개 줄어듦.
                degree[next]--;

                // 먼저 풀어야하는 문제가 없는 경우
                // 새롭게 큐에 데이터를 집어넣는다.
                if (degree[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        System.out.println(sb);
    }
}
