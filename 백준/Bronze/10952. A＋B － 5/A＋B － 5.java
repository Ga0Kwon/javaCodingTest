import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;

        int a, b;

        while(true){
            token = new StringTokenizer(bf.readLine());
             a = Integer.parseInt(token.nextToken());
             b = Integer.parseInt(token.nextToken());
            if(a == 0 && b == 0){
                break;
            }
            sb.append(a+b+"\n");
        }
        System.out.println(sb);
        bf.close();

    }
}
