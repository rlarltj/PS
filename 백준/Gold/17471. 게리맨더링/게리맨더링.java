import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] population;
    static List<List<City>> cities;
    static int[] area;
    static boolean[] visit;
    static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        population = new int[n + 1];
        cities = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            cities.add(i, new ArrayList<>());
        }

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());

            for (int j = 0; j < number; j++) {
                int idx = Integer.parseInt(st.nextToken());
                cities.get(i).add(new City(idx, population[idx]));
            }
        }

        area = new int[n + 1];
        dfs(1);
        
        if(answer == Integer.MAX_VALUE) {
           System.out.println(-1);
           return;
        }
        
        System.out.println(answer);
    }

    private static void dfs(int k) {
        if (k == n + 1) {
            int area1 = 0;
            int area2 = 0;

            for (int i = 1; i <= n; i++) {
                if (area[i] == 1) {
                    area1 += population[i];
                }else {
                    area2 += population[i];
                }
            }

            visit = new boolean[n + 1];

            int linkCount = 0;

            for (int i = 1; i <= n; i++) {
                if (!visit[i]) {
                    bfs(i, area[i]);
                    linkCount ++;
                }
            }

            if(linkCount == 2) {
                answer = Math.min(answer, Math.abs(area1 - area2));
            }

            return;
        }

        area[k] = 1;
        dfs(k + 1);

        area[k] = 2;
        dfs(k + 1);
    }

    private static void bfs(int idx, int areaNum) {
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(idx);
        visit[idx] = true;

        while (!qu.isEmpty()) {
            int now = qu.poll();

            List<City> city = cities.get(now);

            for (City nextCity : city) {
                if (area[nextCity.idx] == areaNum && !visit[nextCity.idx]) {
                    qu.offer(nextCity.idx);
                    visit[nextCity.idx] = true;
                }
            }
        }
    }

    static class City{
        int idx;
        int population;

        public City(int idx, int population) {
            this.idx = idx;
            this.population = population;
        }
    }
}
