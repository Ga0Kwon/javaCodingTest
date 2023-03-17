import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws  Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        //받는 숫자가 int형보다 큰 값을 출력 하므로 long 형(8byte)을 사용하여 출력합니다.
        //A, B, C (1 ≤ A, B, C ≤ 10^12) 조건이 각 ABC가 1부터 10의 12승까지이다.
        //즉 long으로 바꿔줘야한다.
        //10^12 => 1e+12
        //2^31[2^32] => 약 2147483648
        long a = Long.parseLong(token.nextToken());
        long b = Long.parseLong(token.nextToken());
        long c = Long.parseLong(token.nextToken());

        System.out.println(a+b+c);
    }
}