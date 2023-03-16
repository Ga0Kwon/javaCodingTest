import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bf.readLine())-543;

        System.out.println(a);
    }
}