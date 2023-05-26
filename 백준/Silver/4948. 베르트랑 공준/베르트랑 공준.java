import java.io.*;

public class Main {

    static boolean[] primeNumber = new boolean[246913];

    //입력&출력 부분
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        countPrime();

        while(true){

            int N = Integer.parseInt(br.readLine());

            if(N == 0){
                break;
            }

            int count = 0;

            for(int i = N+1; i <= 2*N; i++){
                if(!primeNumber[i])  count++;
            }

            bw.write(count + "\n");
        }

        br.close();

        bw.flush();
        bw.close();

    }
    //소수인지 판별하는 배열 만들기
    static void countPrime(){

        primeNumber[0] = primeNumber[1] = true;

        for(int i = 2; i <= Math.sqrt(primeNumber.length); i++){

            if(primeNumber[i]) continue;

            for(int j = i * i; j < primeNumber.length; j += i) {
                primeNumber[j] = true;
            }
        }
    }
}