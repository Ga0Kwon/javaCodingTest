import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        br.close();
        String A = token.nextToken();
        String B = token.nextToken();

        /*문제에서 같지 않는 세자리수라고 했으므로, 첫번째 자리와 세번째 자리 위치만 바꾸면 됨*/
        int changeA = changeStr(A);
        int changeB = changeStr(B);

        System.out.println(changeA > changeB ? changeA : changeB);
    }

    static int changeStr(String str){
        StringBuilder sb = new StringBuilder();

        sb.append(str.charAt(str.length()-1)).append(str.charAt(1)).append(str.charAt(0));

        return Integer.parseInt(String.valueOf(sb));
    }
}
