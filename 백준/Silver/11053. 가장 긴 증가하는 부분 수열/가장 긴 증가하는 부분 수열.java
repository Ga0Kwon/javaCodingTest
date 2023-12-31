import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 각각의 위치에 해당하는 길이를 구함
        for(int i = 0; i < N; i++) {
            solution(i);
        }

        int max = dp[0]; //최댓값 변수 (초기값 dp[0] 값)

        // 최댓값 찾는 코드
        for(int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
        br.close();
    }


    static int solution(int depth) {

        // 조회하지 않는 것일 경우 
        if(dp[depth] == null) {
            dp[depth] = 1;	// 1로 초기화

            // 현재 위치보다 작은 값들을 찾고 카운트해서 넣는 방식
            for(int i = depth - 1; i >= 0; i--) {
                if(arr[i] < arr[depth]) {
                    dp[depth] = Math.max(dp[depth], solution(i) + 1);
                }
            }
        }
        return dp[depth];
    }
}