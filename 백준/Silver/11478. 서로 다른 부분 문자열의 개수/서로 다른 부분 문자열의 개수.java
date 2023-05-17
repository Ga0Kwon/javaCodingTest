import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        br.close();

        HashSet<String> partS = new HashSet<String>();

        for(int i = 0; i < S.length(); i++) {
            for(int j = i+1; j <= S.length(); j++){
                partS.add(S.substring(i, j));
            }
        }

        bw.write(partS.size() + "");
        bw.flush();
        bw.close();
    }
}