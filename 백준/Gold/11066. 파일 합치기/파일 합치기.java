import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb =  new StringBuilder();

        int T = Integer.parseInt(br.readLine()); //테스트 데이터 개수

        while(T --> 0){ //테스트 데이터 개수만큼 반복
            int K = Integer.parseInt(br.readLine()); //장의 개수
            st = new StringTokenizer(br.readLine()); //수록한 파일의 크기를 입력
            int[] sum = new int[K+1];
            int[][] dp = new int[K+1][K+1]; //동적 계획법 사용시

            for(int i = 1; i <= K; i++){
                /*  누적합을 사용하는 게 더 효율적이다.
                    누적합이 아닌 본래 입력값을 사용하게 되면 범위에 있는 파일크기 개수만큼 더하는 연산을 진행해줘야하기 때문에
                    특정범위값을 구할 땐 끝점에서 - (시작점-1)을 하면 구할 수 있다.
                    => 파일크기 개수만큼 연산이 늘지 않고 항상 일정한 연산을 수행할 수 있음
                 */
                sum[i] = sum[i-1]+ Integer.parseInt(st.nextToken()); //장의 개수만큼 수록된 파일의 크기를 입력
            }

            for(int page = 1; page <= K; page++){ //연산(+)의 개수 : (page+1)장씩 붙인다
                for(int start = 1; start+page<= K; start++){ //시작 점 : 붙이기 시작하는 점
                    int end = start+page; //끝 점 : 붙이는 걸 끝내는 점
                    dp[start][end] = Integer.MAX_VALUE; //최솟값을 구하기 위해 정수(int) 가장 큰 값으로 초기화
                    for(int cut = start; cut < end; cut++){ //자르는 점 : 시작점과 끝점 사이에 자르는 점
                        dp[start][end] = Math.min(dp[start][end], dp[start][cut] + dp[cut+1][end] + (sum[end] - sum[start-1]));
                    }
                }
            }
            sb.append(dp[1][K]).append("\n"); //1번째부터 K번째의 누적합 부분이 최종이면서 최소의 비용 값
        }
        br.close();
        System.out.println(sb);
    }

}