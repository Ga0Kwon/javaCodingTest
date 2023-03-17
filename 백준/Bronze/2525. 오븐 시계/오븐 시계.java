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
        int t = Integer.parseInt(bf.readLine()); //타이머는 줄바꿈이 되어야하니까

        bf.close();

        m+= t;

        t = m/60;

        if(t > 0){
            h += t;
            m = m%60;
        }

        if(h >= 24){
            h -= 24;
        }

        System.out.printf("%d %d", h, m);
    }
}
