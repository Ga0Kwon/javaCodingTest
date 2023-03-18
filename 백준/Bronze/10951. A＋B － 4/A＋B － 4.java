import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String st ;

        while((st = br.readLine()) != null){
           int  a = st.charAt(0) - '0'; //아스키코드값으로 계산
           int b = st.charAt(2) - '0'; //가운데는 공백이 있으니까 2번째 문자를 받는다.

            sb.append(a+b+"\n");
        }
        System.out.println(sb);
        
        br.close();

    }
}
