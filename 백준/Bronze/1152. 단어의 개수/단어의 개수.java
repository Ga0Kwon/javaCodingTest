import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine(), " "); //공백으로 분리
        br.close();

        System.out.println(token.countTokens()); //분리한 걸로 몇개인지 count를 반환

    }
}
