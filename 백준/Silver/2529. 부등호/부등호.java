import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static String[] eq;
    static boolean[] used;
    static List<String> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        eq = new String[n];
        numbers = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            eq[i] = st.nextToken();
        }

        used = new boolean[10];

        backTracking(0, "");

        Collections.sort(numbers);
        System.out.println(numbers.get(numbers.size() - 1));
        System.out.println(numbers.get(0));
    }

    private static void backTracking(int depth, String number) {
        if (depth == n + 1) {
            numbers.add(number);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!used[i]) {

                if (depth == 0 || check(Character.getNumericValue(number.charAt(depth - 1)), i, eq[depth - 1])) {
                    used[i] = true;
                    backTracking(depth + 1, number + i);
                    used[i] = false;
                }
            }
        }
    }

    private static boolean check(int now, int prev, String c) {
        if (c.equals(">")) {
            if (prev < now) {
                return true;
            }
        }else {
            if (prev > now) {
                return true;
            }
        }

        return false;
    }
}
