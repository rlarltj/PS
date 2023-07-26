import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Ingredient> ingredients;
    static boolean[] selected;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ingredients = new ArrayList<>();
        selected = new boolean[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());

            ingredients.add(new Ingredient(sour, bitter));
        }

        backTracking(0, n);
        System.out.println(min);
    }

    private static void backTracking(int depth, int n) {
        int sourIdx = 1;
        int bitterIdx = 0;

        if (depth == n) {
            for (int i = 0; i < n; i++) {
                if (selected[i]) {
                    sourIdx *= ingredients.get(i).sour;
                    bitterIdx += ingredients.get(i).bitter;
                }
            }

            if (sourIdx != 1 && bitterIdx != 0) {
                min = Math.min(min, Math.abs(sourIdx - bitterIdx));
            }
            
            return;
        }

        selected[depth] = true;
        backTracking(depth + 1, n);
        selected[depth] = false;
        backTracking(depth + 1, n);
    }

    static class Ingredient {
        int sour;
        int bitter;
        public Ingredient(int sour, int bitter) {
            this.sour = sour;
            this.bitter = bitter;
        }
    }
}
