import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        br.close();
        System.out.println(checkStr(str));
    }
    static int checkStr(String str){
        StringBuilder sb = new StringBuilder(str);
        if(str.equals(sb.reverse().toString())){ //reverse() : 문자열을 거꾸로 돌려주는 메서드
           return 1;
        }else{
            return 0;
        }
    }
}
