import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws  Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(bf.readLine());

        bf.close();
        
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());

        if(a < b){
            System.out.println("<");
        }else if (a > b){
            System.out.println(">");
        }else{
            System.out.println("==");
        }
    }
}