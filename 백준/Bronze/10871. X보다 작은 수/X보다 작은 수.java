import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token  = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int X = Integer.parseInt(token.nextToken());
        int []numbers = new int[N];

        token  = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(token.nextToken());
        }

        StringBuilder builder = new StringBuilder();

        for(int i =0; i < numbers.length; i++){
           if(numbers[i] < X){
               builder.append(numbers[i]+" ");
           }
        }

        System.out.println(builder);
        br.close();

    }
}
