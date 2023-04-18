
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] numnbers = new int[N];

        for(int i = 0; i < N; i++){
            numnbers[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(numnbers);

        for(int i = 0; i < N; i++){
            bw.write(numnbers[i] + "\n");
        }

        bw.flush();
        bw.close();

    }
}