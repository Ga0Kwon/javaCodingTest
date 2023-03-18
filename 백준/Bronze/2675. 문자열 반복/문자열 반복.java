import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer token;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            token = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(token.nextToken());
            String S = token.nextToken();
            for(int j = 0;  j < S.length(); j++){
                for(int x = 0; x < num; x++){
                    sb.append(S.charAt(j));
                }
            }
            sb.append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}
