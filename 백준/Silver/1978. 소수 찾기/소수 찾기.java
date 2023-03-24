import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (checkNumber(num)) {
                count++;
            }
        }
        br.close();
        System.out.println(count);
    }


    static boolean checkNumber(int num) {
        int check = 0;
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= num; i++) { //1은 제외해서 나눠야한다.
            if((num != i) && (num % i == 0)){
               return false;
            }
        }

        return true;
    }
}