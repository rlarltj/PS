import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[m];

        int left = 1;
        int right = 0;
        for (int i = 0; i < m; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, nums[i]);
        }

        int answer = 0;

        while (left <= right) {
            int peopleNum = 0;
            int mid = (left + right) / 2;

            for (int i = 0; i < m; i++) {
                if (nums[i] % mid == 0) {
                    peopleNum += nums[i] / mid;
                }else {
                    peopleNum += nums[i] / mid + 1;
                }
            }

            if (peopleNum > n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}
