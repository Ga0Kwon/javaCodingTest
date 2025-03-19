import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] gis, dp;
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}}; //움직이는 방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //세로 크기
        N = Integer.parseInt(st.nextToken()); //가로 크기

        gis = new int[M][N]; //지도 배열
        dp = new int[M][N]; //다이나믹 배열

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                gis[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        br.close();

        solutionDFS(0, 0); //시작 점은 {0, 0}부터 {M-1, N-1}로 이동하는 것
        System.out.println(dp[0][0]);

    }


    /*파라미터 (탐색하는) x축, y축 값*/
    public static void solutionDFS(int x, int y){
        if(y == (M-1) & x == (N-1)){ //탐색 완료.
            dp[y][x] = 1;
            return;
        }

        if(dp[y][x] != -1) return; //이미 탐색 완료한 경우

        dp[y][x] = 0; //탐색 시작

        for(int[] m : move){
            int nextX = x+m[1]; //이웃한 위치 조회
            int nextY = y+m[0]; //이웃한 위치 조회

            if(nextX < N & nextX >= 0 & nextY < M & nextY >= 0) { //위치 탐색 범위를 벗어나는 것을 방지
                if(gis[y][x] > gis[nextY][nextX]){ //다음 이웃한 위치이면서 현재 탐색한 곳보다 높이가 더 낮은 지점인 경우
                    solutionDFS(nextX, nextY); //다음 위치 탐색
                    dp[y][x] += dp[nextY][nextX]; //dp에 누적 저장
                }
            }
        }


    }
}