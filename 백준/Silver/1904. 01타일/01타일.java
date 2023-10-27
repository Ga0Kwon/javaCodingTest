import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static int[] fibonacci = new int[1000001]; //(1 ≤ N ≤ 1,000,000)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        br.close();

        /*0과 1은 1이다. => 고정된 초기값*/
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        fibonacci[2] = 2;

        //-1로 초기화 (구한 값인지 체크하기 위해)
        for(int i = 3; i < fibonacci.length; i++){
            fibonacci[i] = -1;
        }
        System.out.println(getFibonacci(N));

    }

    static int getFibonacci(int n){

        //구하지 않은 값이라면
        if(fibonacci[n] == -1){
            //어차피 증가폭은 같으므로 0~2까지 초기값 넣어주고 그 값들을 계속 더해주는 방향으로...
            fibonacci[n] = (getFibonacci(n-1) + getFibonacci(n-2)) % 15746;
        }

        return fibonacci[n]; 
    }
}