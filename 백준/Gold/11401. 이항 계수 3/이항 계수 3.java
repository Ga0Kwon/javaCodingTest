import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {

    final static long P = 1000000007; // 나누는 수

    public static void main(String[] args) throws IOException {
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

         //이항계수 자연수 N과 정수 K =>NCK를 1000000007로 나눈 수를 구하면 됨.
         long N = Long.parseLong(st.nextToken());
         long K = Long.parseLong(st.nextToken());

         long numerator =  getFatorial(N);  // 분자 (N!)
         long denominator = getFatorial(K) * getFatorial(N-K) % P; // 분모 ((K!*(N-K)!) mod P)

         //N! * 분모의 역원 (K!*(N-K)!)
        System.out.println(numerator * getPow(denominator, P-2) % P);

    }
    
    //팩토리얼 구하는 함수
    public static long getFatorial(long N) {
        long factor = 1L; //  초기 값

         while (N > 1){
             factor = (factor*N) % P;
             N--;
         }

         return factor;
    }

    //역원을 구하는 함수
    // 지수 밑의 수 num,  지수 exponent
    public static long getPow(long num, long exponent){
        long result = 1;

        while(exponent > 0){
            // 지수가 홀수면 result에 곱해주고,
            // 지수가 짝수라면 exponent가 1이 될때까지 밑의 수(num)를 제곱하다가 result에 담는다
            if(exponent % 2 == 1){
                result *= num;
                result %= P;
            }
            num = (num*num) % P;
            exponent /= 2;
        }

        return result;
    }


}