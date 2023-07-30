import java.io.*;

public class Main {

    static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        result = N;

        br.close();
        System.out.println(factorial(N));
    }


    static long factorial(int n){
        if (n < 0){
            return 1;
        }

        if(n == 0){
            return 1;
        }

        return n*factorial(n-1);
    }
}
        