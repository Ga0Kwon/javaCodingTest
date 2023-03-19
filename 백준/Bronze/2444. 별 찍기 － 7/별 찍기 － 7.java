import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        br.close();

        int line = 2*N-1; //총 줄의 수가 홀수만 나옴
        /*첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력*/
        for(int i = 1; i <= line; i++){
            /*공백 먼저*/
            if(i <= N){ //윗부분
                for(int b = 1; b <= N-i; b++){ //공백 부분
                    sb.append(" ");
                }
                for(int s = 0; s < 2*i-1; s++){
                    sb.append("*");
                }
                sb.append("\n"); //한줄 끝나는 부분
            }else{ //아래 부분
                for(int b = 1; b <= i - N; b++){
                    sb.append(" ");
                }
                for(int s = 0; s < (2*line)-(2*i-1); s++){
                    sb.append("*");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
