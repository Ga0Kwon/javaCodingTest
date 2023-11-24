import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

         dp = new Integer[N+1];

         dp[0] = dp[1] = 0; //dp[0]의 값은 쓰지 않는다.

        System.out.println(solution(N));

        br.close();

    }

    //최소 횟수를 구하는 솔루션 함수
    public static int solution(int value){
        if(dp[value] == null){
            // 여기서 중요한 점은 무조건 큰 수로 나눈다고 적은 횟수가 아님!
            // => 즉, 각 연산 별 최소값을 구해야 함!
            if(value % 6 == 0) { //2, 3 나누는 거 다 되고 -1도 됨(-1은 안되는 경우가 없음)
                dp[value] = Math.min(Math.min(solution(value/3), solution(value/2)), solution(value-1))+1;

            }else if(value % 3 == 0){ //나누기 3과 -1만 되는 경우
                dp[value] = Math.min(solution(value/3), solution(value-1))+1;

            }else if(value % 2 == 0){ //나누기 1과 -1만 되는 경우
                dp[value] = Math.min(solution(value/2), solution(value-1))+1;

            }else{ //-1만 되는 경우
                dp[value] = solution(value-1)+1;
            }
        }

        return dp[value];
    }
}