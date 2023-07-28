import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static int n;
    static int[] nums;
    static List<Integer> sums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nums = new int[n];
        sums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sums.add(nums[i] + nums[j]);
            }
        }

        Collections.sort(sums);
        Arrays.sort(nums);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int a = nums[i] - nums[j];

                boolean exist = binarySearch(sums.size(), a);

                if (exist) {
                    System.out.println(nums[i]);
                    return;
                }
            }
        }
    }

    private static boolean binarySearch(int size, int num) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (num > sums.get(mid)) {
                left = mid + 1;
            } else if (num < sums.get(mid)) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
