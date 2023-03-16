import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());


        System.out.println(a*((b%100)%10));
        System.out.println(a*((b%100)/10));
        System.out.println(a*(b/100));

        System.out.println(a*b);
    }
}