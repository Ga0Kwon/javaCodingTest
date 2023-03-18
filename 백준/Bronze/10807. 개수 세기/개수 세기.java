import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer token  = new StringTokenizer(br.readLine());
        int []numbers = new int[N];

        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt( token.nextToken());
        }
        int num = Integer.parseInt(br.readLine());

        int count = 0;

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == num){
                count++;
            }
        }

        System.out.println(count);

        br.close();

    }
}
