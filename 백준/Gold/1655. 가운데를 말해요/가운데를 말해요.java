import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> incr = new PriorityQueue<>();
        PriorityQueue<Integer> decr = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());


            if (incr.size() == decr.size()) {
                decr.offer(num);
            }else {
                incr.offer(num);
            }

            if (!incr.isEmpty() && !decr.isEmpty()) {
                if (incr.peek() < decr.peek()) {
                    int poll = incr.poll();
                    incr.offer(decr.poll());
                    decr.offer(poll);
                }
            }

            sb.append(decr.peek()).append('\n');
        }

        System.out.println(sb);
    }
}
