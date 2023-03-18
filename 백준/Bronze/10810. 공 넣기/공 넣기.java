import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int []numbers = new int[N];

        for(int p = 0; p < M; p++){
            token = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(token.nextToken())-1; //배열의 인덱스는 0부터 시작하기 때문에 -1
            int j = Integer.parseInt(token.nextToken())-1; //배열의 인덱스는 0부터 시작하기 때문에 -1
            int k = Integer.parseInt(token.nextToken());
            for(int x = i; x <= j; x++){
                numbers[x] = k;
            }

        }
        br.close();
        
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }

    }

}
