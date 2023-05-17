import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashSet<Integer> Elements = new HashSet<Integer>();

        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < A; i++) {
            Elements.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < B; i++) {
            Elements.add(Integer.parseInt(st.nextToken()));
        }
        br.close();

        bw.write((Elements.size() - B) + (Elements.size() - A) + "");
        bw.flush();
        bw.close();
    }
}