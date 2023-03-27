import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //10^9 까지임으로 long으로 입력받는다.
        long n = Long.parseLong(br.readLine()); //가장 아랫부분의 정사각형 개수
        br.close();

        System.out.println(n*4); //둘레의 규칙성을 보면 n*4만큼이다.
    }
}