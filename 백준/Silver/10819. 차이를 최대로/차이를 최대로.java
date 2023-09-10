import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] nums;
    static int[] arr;
    static boolean[] used;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        arr = new int[n];
        used = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0);

        System.out.println(answer);
    }

    private static void backTracking(int depth) {
        if (depth == n) {
            int sum = getSum();
            answer = Math.max(sum, answer);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                arr[depth] = nums[i];
                backTracking(depth + 1);
                used[i] = false;
            }
        }
    }

    public static int getSum() {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }

        return sum;
    }
}
