import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        /*체스는 총 16개의 피스를 사용하며, 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개로 구성*/
        br.close();
        //각각의 가져야할 개수
        int K = 1; //킹
        int Q = 1; //퀸
        int L = 2; //룩
        int B = 2; //비숍
        int N = 2; //나이트
        int P = 8; //폰*/

        K -= Integer.parseInt(token.nextToken());
        Q -= Integer.parseInt(token.nextToken());
        L -= Integer.parseInt(token.nextToken());
        B -= Integer.parseInt(token.nextToken());
        N -= Integer.parseInt(token.nextToken());
        P -= Integer.parseInt(token.nextToken());

        System.out.println(K + " " + Q + " "+ L + " "+ B + " "+ N + " "+ P);

    }
}
