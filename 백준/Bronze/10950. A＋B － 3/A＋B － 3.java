import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer token ;

        int [] result = new int[N];
        for(int i = 0; i < N; i++){
            token = new StringTokenizer(bf.readLine()); //입력을 새로 받아야하니까 반복문 돌때마다 다시 new 연산자를 사용한다.
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            result[i] = a+b;
        }

        bf.close();
        
        for(int i = 0; i < N; i++){
            System.out.println(result[i]);
        }
    }
}
