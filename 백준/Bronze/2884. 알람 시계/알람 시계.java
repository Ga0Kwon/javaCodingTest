import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        int h = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        bf.close();

        if( m >= 45) {
            m -= 45;
        }else{
            if(h <= 0){
                h = 24;
            }
            m+=60;
            m-=45;
            h--;
        }
        System.out.printf("%d %d", h, m);

    }
}
