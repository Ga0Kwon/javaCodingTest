import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder initMember[] = new StringBuilder[201];

        for(int i = 0; i < 201; i++){
            initMember[i] = new StringBuilder();
        }

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            initMember[age].append(age +" "+ st.nextToken() +"\n");
        }

        br.close();

        for (StringBuilder sb : initMember) {
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();


    }
}