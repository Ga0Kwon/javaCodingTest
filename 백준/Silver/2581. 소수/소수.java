import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine()); //M이상
        int N = Integer.parseInt(br.readLine()); //N이하
        StringBuilder sb = new StringBuilder();

        br.close();

        int sum = 0;
        int min = 0;

        for(int i = M; i <= N; i++){

            int check = findDecimal(i);

            if(check != -1){
                if(min == 0){
                    min = check;
                }
                sum += check;
            }

        }

        System.out.println(sum == 0 ? -1 : sum + "\n" + min);
    }

    static int findDecimal(int number){
        if(number == 1){
            return -1;
        }

        for(int i = 2; i < number; i++){
            if(number%i == 0 && number != i){
                return -1;
            }
        }
        return number;
    }
}