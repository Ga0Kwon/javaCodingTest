import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] floor;
    static int N;

    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        floor = new int[N][N]; //N층이고 N층에 최대 N개 들어감
        dp = new Integer[N][N]; //최댓값 더한 배열

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++) {
                floor[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        /* 마지막 행 복사 */
        for(int i = 0; i < N; i++){
            dp[N-1][i] = floor[N-1][i];
        }
        System.out.println(solution(0, 0));
    }


    public static int solution(int depth, int index){
        if(depth == (N-1)){ //마지막 층까지 조회했다면 해당 깊이, 인덱스 값을 반환
            return dp[depth][index];
        }

        //탐색하지 않은게 존재하면 다음 행의 두개의 이웃한 열 중 최댓값 + 지금 해당 값과 더해서 넣기
        if(dp[depth][index] == null){
            dp[depth][index] = Math.max(solution(depth+1, index), solution(depth+1, index+1)) + floor[depth][index];
        }

        return dp[depth][index];
    }
}