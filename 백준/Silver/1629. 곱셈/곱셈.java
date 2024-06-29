import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int C;
    static char[][] chessBoard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); //주어진 수
        int B = Integer.parseInt(st.nextToken()); //몇승인지
        C = Integer.parseInt(st.nextToken()); //나눠야 하는 수

        System.out.println(pow(A, B));
    }

    //A의 exp승 구하는 함수
    private static long pow(int A, int exp){
        if(exp == 1){
            return A%C;
        }

        //exp 절반한 값을 구한다.
        long value = pow(A, exp/2);

        /*
            문제 해석에서는 넣지는 않았지만 아래에 나온 공식은 모듈러공식으로
            (AxB)modC = ((AmodC)X(BmodC))modC
            => (A*B)%C =  ((A%C)*(B%C))%C
                       = ((AxB)%C)%C 인 것을 알 수 있다.
        */
        if(exp % 2 != 0){ //만약 지수가 홀수이면
            return (value*value%C)*A%C;
        }

        //짝수의 경우
        return value*value%C;
    }
}