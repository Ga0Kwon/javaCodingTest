import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer token;
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++){
            token = new StringTokenizer(bf.readLine());
            int a =  Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            sb.append("Case #"+i+": " + (a+b) + "\n");
        }
        bf.close();

        System.out.println(sb);
    }
}
