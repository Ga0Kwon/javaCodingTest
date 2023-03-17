import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());

        if(a==b && b==c){

            System.out.println(10000+1000*a);

        }else if(a==b){
                System.out.println(1000+100*a);
        }else if(a==c){
            System.out.println(1000+100*a);
        }else if(c==b){
            System.out.println(1000+100*b);
        }else{
            /*int max = a;
            if(max < b){
                max = b;
            }
            if(max < c){
                max = c;
            }*/
            /* 여기서 부턴 가장 큰 수를 찾기만 하면 되는 거니까 a의 값을 기억할 필요 없다.*/
            if(a < b){
                a = b;
            }
            if(a < c){
                a = c;
            }

            System.out.println(100*a);
        }
    }
}
