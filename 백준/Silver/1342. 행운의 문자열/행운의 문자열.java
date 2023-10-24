import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String s;
    static int answer = 0;
    static int[] alphabet = new int[27];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a'] ++;
        }

        backtracking(0,  "");

        System.out.println(answer);
    }

    private static void backtracking(int depth, String tmp) {
        if (depth == s.length()) {
            answer ++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] == 0) {
                continue;
            }

            char nextChar = (char) ('a' + i);
            
            if (!tmp.equals("") && tmp.charAt(tmp.length() - 1) == nextChar) {
                continue;
            }

            alphabet[i] --;
            backtracking(depth + 1 , tmp + nextChar);
            alphabet[i] ++;
        }
    }
}
