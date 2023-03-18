import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str  = br.readLine();

        bw.write(str.charAt(Integer.parseInt(br.readLine())-1));
        br.close();
        bw.flush();
        bw.close();
    }
}
