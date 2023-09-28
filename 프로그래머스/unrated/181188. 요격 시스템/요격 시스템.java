import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int count = 1;

        //1. s 좌표가 작은 순서대로 정렬한다. s좌표가 같은 경우, e좌표가 큰 순서대로 정렬
        Arrays.sort(targets, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }

            return o1[1] - o2[1];
        });

        int s = targets[0][0];
        int e = targets[0][1];

        for (int i = 1; i < targets.length; i++) {
            int nextS = targets[i][0];
            int nextE = targets[i][1];

            if (e > nextS) {
                continue;
            }

            count ++;
            s = nextS;
            e = nextE;
        }

        //2. e 좌표와 뒤 미사일의 s좌표를 비교한다.
        //2-1. e 좌표가 s 좌표보다 큰 경우 => 다음 미사일로 넘어간다.
        //2-2. e 좌표가 s 좌표보다 작거나 같은 경우 => count ++, 기준점 변경


        return count;
    }
}