import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] building = new int[n];

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());

            building[i] = height;
        }

        Stack<Integer> st = new Stack<>();
        st.add(building[0]);

        long answer = 0;

        for (int i = 1; i < n; i++) {
            int now = building[i];

            while (!st.isEmpty() && st.peek() <= now) {
                st.pop();
            }

            answer += st.size();
            st.add(now);
        }

        System.out.println(answer);
    }
}
