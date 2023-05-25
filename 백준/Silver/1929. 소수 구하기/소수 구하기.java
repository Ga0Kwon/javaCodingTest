import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    //입력 부분
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M  = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        br.close();

        printSection(M, N);
    }

    //소수 판별 & 출력 부분
    static void printSection(int M, int N) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = M; i <= N; i++){
            BigInteger bigNumber = new BigInteger(String.valueOf(i));

            if(bigNumber.isProbablePrime(10)){ 
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}