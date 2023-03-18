import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str  = br.readLine();
        int index = Integer.parseInt(br.readLine())-1; //str의 인덱스는 0부터 시작하므로 -1을 해준다
        br.close();

        bw.write(str.charAt(index));
        bw.flush();
        bw.close();
    }
}
