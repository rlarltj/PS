
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static String[] word;
    static char[] alphabet;
    static boolean[] isUsed;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        // a n t i c
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));
        word = new String[n];

        alphabet = new char[26];
        isUsed = new boolean[26];

        if (m < 5) {
            System.out.println(0);
            return;
        } else if (m >= 26) {
            System.out.println(n);
            return;
        }

        for (int i = 0; i < n; i++) {
            String s1 = br.readLine();
            String s = s1.substring(4, s1.length()-4);

            word[i] = s;
        }

        isUsed['a' - 'a'] = true;
        isUsed['n' - 'a'] = true;
        isUsed['t' - 'a'] = true;
        isUsed['i' - 'a'] = true;
        isUsed['c' - 'a'] = true;

        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a'+ i);
        }

        solve(0, 0);
        System.out.println(max);
    }

    private static void solve(int start, int depth) {
        if(depth == m - 5){
            int count = 0;
            for (int i = 0; i < n; i++) {
                boolean read = true;
                for (int j = 0; j < word[i].length(); j++) {
                    if(!isUsed[word[i].charAt(j) - 'a']){
                        read = false;
                        break;
                    }
                }

                if(read) count ++;
            }
            max = Math.max(max, count);
            return;
        }

        for (int i = start; i < 26; i++) {

            if(!isUsed[i]){
                isUsed[i] = true;
                solve(i+1, depth + 1);
                isUsed[i] = false;
            }
        }
    }
}
