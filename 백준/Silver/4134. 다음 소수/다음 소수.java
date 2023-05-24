import java.io.*;
import java.math.BigInteger;

public class Main {
    //입력 부분
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long[] numbers =  new long[T];

        for(int i = 0; i < T; i++){
            numbers[i] = Long.parseLong(br.readLine());
        }

        br.close();

        printSection(numbers);
    }
    //소수 찾는 메소드
    static BigInteger findPrimeNumber(BigInteger num){

        if(num.isProbablePrime(10)){
            return num;
        }else{
            return num.nextProbablePrime();
        }
    }

    //출력 부분
    static void printSection(long[] array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < array.length; i++){
            BigInteger bigNumber = new BigInteger(String.valueOf(array[i]));
            bw.write(findPrimeNumber(bigNumber) + "\n");
        }

        bw.flush();
        bw.close();
    }
}