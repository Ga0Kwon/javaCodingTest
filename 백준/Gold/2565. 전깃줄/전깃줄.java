import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][2]; //A전봇대 - B전봇대
        dp = new Integer[N];

        for(int i = 0; i < N; i++){ //전깃줄 이어진 선 입력받기
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //전봇대 정렬(왼쪽 A기준으로 정렬)
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        
        int max = Integer.MIN_VALUE;

        //전봇대 A를 순서대로 탐색 -> A를 기준으로 B 전봇대가 들어갈 수 있는지.
        for(int i = 0; i < N; i++) {
            max = Math.max(solution(i), max);
        }

        System.out.println(N - max);

        br.close();
    }

    static int solution(int depth){
        if(dp[depth] == null) { //탐색하지 않은 경우
            dp[depth] = 1; //1로 초기화

            //A전봇대 기준으로 다음 전봇대와 비교한다.
            for (int i = depth + 1; i < dp.length; i++) {
                if (arr[depth][1] < arr[i][1]) { //전봇대B 연결된 부위가 커야 한다.
                    // 연결 가능한 전선의 경우의 수 중 큰 값을 dp에 저장
                    dp[depth] = Math.max(dp[depth], solution(i) + 1);
                }
            }
        }
        return dp[depth];
    }
}