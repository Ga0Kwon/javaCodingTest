import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int totalPrice = Integer.parseInt(bf.readLine());
        int productCount = Integer.parseInt(bf.readLine());
        
        StringTokenizer token;
        int purchase = 0;

        for (int i = 0; i < productCount; i++){
            token = new StringTokenizer(bf.readLine());

            int price = Integer.parseInt(token.nextToken());
            int count = Integer.parseInt(token.nextToken());

            purchase+= price*count;
        }

        bf.close();

        System.out.println((totalPrice == purchase ? "Yes" : "No"));
    }
}
