import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());

        bf.close();

        for(int i = 1; i <= N; i++){
            for(int b = 1; b <= N-i; b++){
                bw.write(" ");
            }
            for(int j = 0; j < i; j++){
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
