import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for(int i = 1; i <= N; i++){
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
