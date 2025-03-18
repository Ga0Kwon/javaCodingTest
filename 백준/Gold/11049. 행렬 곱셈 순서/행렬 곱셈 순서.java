import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //행렬의 개수
        int[][] matrixs = new int[N][2]; //행렬 크기 저장하는 배열
        int[][] dp = new int[N][N]; //행렬의 곱셈연산 횟수를 저장하는 배열

        //입력 순서 (행렬의 크기 행(r) x 열(c))
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            matrixs[i][0] = Integer.parseInt(st.nextToken()); //행 크기
            matrixs[i][1] = Integer.parseInt(st.nextToken()); //열 크기
        }

        br.close();

        for(int k = 1; k < N; k++){
            for(int i = 0; i+k < N; i++){
                dp[i][i+k] = Integer.MAX_VALUE; //초기값은 일단 가장 큰 값으로 저장
                for(int j = i ; j < i+k; j++){
                    dp[i][i+k] = Math.min(dp[i][i+k], dp[i][j]+dp[j+1][i+k] + matrixs[i][0]*matrixs[j][1]*matrixs[i+k][1]);
                }
            }
        }

        System.out.println(dp[0][N-1]);

    }

}