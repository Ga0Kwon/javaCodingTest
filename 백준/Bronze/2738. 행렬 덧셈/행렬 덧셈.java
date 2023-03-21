import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int A[][] = new int[N][M];
        int B[][] = new int[N][M];

        for(int i = 0; i < 2; i++){
            for(int r = 0; r < N; r++ ){
                if(i == 0){ //A일 경우
                    token = new StringTokenizer(br.readLine());
                    for(int j = 0; j < M; j++){
                        A[r][j] = Integer.parseInt(token.nextToken());
                    }
                }else{ //B행렬의 경우
                    token = new StringTokenizer(br.readLine());
                    for(int j = 0; j < M; j++){
                        B[r][j] = Integer.parseInt(token.nextToken());
                    }
                }
            }
        }

        br.close();
        
        /*행렬 더하기*/
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(A[i][j] + B[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}