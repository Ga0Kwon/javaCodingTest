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
        int [] chessPiece = {1, 1, 2, 2, 2, 8};

        for(int i = 0; i < chessPiece.length; i++){
            sb.append(chessPiece[i] - Integer.parseInt(token.nextToken()) +" ");
        }
        System.out.println(sb);

    }
}
