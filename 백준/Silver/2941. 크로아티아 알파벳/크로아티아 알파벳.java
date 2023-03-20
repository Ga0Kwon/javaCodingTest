import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        String [] strArray = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=","z="};

        int count = 0;
        for(int i = 0; i < strArray.length; i++){
            if(str.contains(strArray[i])){ //문자열 배열에 있는 값이 str이 포함하면
                str = str.replace(strArray[i], "0"); //replace('기존문자', '바꿀문자')
                /*str에 포함되는 크로아티아 알파벳 자리에 "!"둔다 => 문자가 치환된것!*/
            }
        }
        System.out.println(str.length()); //치환이 완료된 str의 길이가 즉, 문자의 개수가된다.
    }
}