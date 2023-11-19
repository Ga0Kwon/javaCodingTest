import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[] floor;
    static int N;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        floor = new int[N+1]; //계단 개수 초기화
        dp = new Integer[N+1]; //방문여부 확인 배열

        for(int i = 1; i <= N; i++){
            floor[i] = Integer.parseInt(br.readLine());
        }

        // 비교할 때 2칸을 초과해서 연속으로 밟을 수 없다
        // 처음 계단 2개는 값을 미리 넣는다(메모제이션)
        dp[0] = 0; //floor[0]은 쓰지 않는다 => 값 0
        dp[1] = floor[1];

        if(N >= 2){ //N이 2일때는 차피 1과 2를 모두 밟는게 최댓값일 테니...
            dp[2] = floor[1] + floor[2];
        }

        System.out.println(solution(N));

    }
    //최댓값을 구하는 솔루션
    public static int solution(int index){

       if(dp[index] == null){ //아직 방문하지 않은 경우
           dp[index] = Math.max(solution(index-2), solution(index-3)+floor[index-1]) + floor[index];
       }

        return dp[index];
    }
}