import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer token ;

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < N; i++){
            token = new StringTokenizer(bf.readLine());
            builder.append(Integer.parseInt(token.nextToken())+ Integer.parseInt(token.nextToken()));
            builder.append("\n");
        }

        bf.close();

        System.out.println(builder);
    }
}
