import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static Integer dp[];

    static int grape[];

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //입력 개수 (포도잔의 개수)

        //배열 초기화
        grape = new int[N+1];
        dp = new Integer[N+1];

        //값 세팅 (포도주 한 잔의 양)
        for(int i = 1; i <= N; i++){
            grape[i] = Integer.parseInt(br.readLine());
        }

        //메모이제이션을 위해 초기값 지정
        dp[0] = 0;
        dp[1] = grape[1];

        // 만약 입력받은 포도잔의 개수가 1개 이상이면서 2잔인 경우
        // 당연히 첫잔과 두번째 잔을 더한게 최댓값이 된다.
        // (dp[2] = grape[1] + grape[2]) 일 수 밖에 없는
        if(N > 1){
            dp[2] = grape[1] + grape[2];
        }

        System.out.println(Top_Down(N));
    }

    static int Top_Down(int depth){
        if(dp[depth] == null){ //한번도 조회하지 않았다면
            //일단, N-2(전전)번째의 누적합과 N-3(전전전)번째의 누적합 + 그냥 전의 포두주 잔의 양 값 중 최댓값을 구한다. (연속 3잔은 마실 수 없기 때문)
            // 구했다면, 그 위의 구한 값에서 지금 잔의 포도잔의 양을 더한 값과 이전 누적합 포도주양 중 최댓값을 구한다.
            dp[depth] = Math.max(Math.max(Top_Down(depth-2), Top_Down(depth-3)+grape[depth-1])+ grape[depth], Top_Down(depth-1));
        }
        return dp[depth];
    }

}