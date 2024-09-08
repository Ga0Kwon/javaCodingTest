import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static long MOD = 1000000007; //니눠야하는 수
    static long[][] A = {{1, 1}, {1, 0}}; //A 행렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //구해야하는 피보나치 수 (N번째)
        long N = Long.parseLong(br.readLine());
        br.close();

        //피보나치 수를 구할 때
        /*  (예시, 7번째의 피보나치를 구한다 했을 때)
           Fn+1
           Fn
           이므로 n은 6만 들어가도 A(1,1)(정리상) = A(0,0)(자바 배열상) F7(7번째 피보나치 수)를 구할 수 있다.
           즉, N--은 감소시킨다.
         */

        N--;

        System.out.println(pow(A, N)[0][0]);

    }

    //행렬 제곱 분할정복
    static long[][] pow(long[][] matrix, long exp){

        //F0 = 0, F1 = 1이기 때문에 exp이 1과 0일 경우는 그대로 출력하면된다.
        if(exp == 1 || exp == 0){
            return matrix;
        }

        //지수 제곱하깆 전 절반으로 나눠 재귀
        long[][] result = pow(matrix, exp/2);

        //절반으로 나눈 값을 가져와 제곱한다.
        result = multiply(result, result);

        if(exp % 2 != 0L){ //홀수 제곱이라면
            result = multiply(result, A); //하나 초기값으로 한번더 곱한다.
        }

        return result; //제곱하면 제곱만큼 빠진다.
    }

    //행렬(파라미터)과 행렬(파라미터)을 곱해주는 메소드
    public static long[][] multiply(long[][] m1, long[][] m2){
        long[][] result = new long[2][2]; //피보나치 배열은 2x2형태의 행렬이다.

        //행렬 곱을 구하는 식이다.(곰셈하는 방식)
        result[0][0] = ((m1[0][0]*m2[0][0])+(m1[1][0]*m2[0][1]))%MOD; //A(1,1)
        result[0][1] = ((m1[0][0]*m2[0][1])+(m1[0][1]*m2[1][1]))%MOD; //A(1,2)
        result[1][0] = ((m1[1][0]*m2[0][0])+(m1[1][1]*m2[1][0]))%MOD; //A(2,1)
        result[1][1] = ((m1[1][0]*m2[0][1])+(m1[1][1]*m2[1][1]))%MOD; //A(2,2)

        return result;

    }
}