import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] chars = new char[5][15]; //5개 줄 각 줄마다 최대 15글자

        for(int i = 0; i < 5; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                chars[i][j] =str.charAt(j);
            }
        }
        br.close();

        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 5; j++){
                //null 문자란 문자열의 마지막을 나타내는 문자이다. '\0'(역슬래쉬 0)로 표기
                if(chars[j][i] == '\0') continue;
                sb.append(chars[j][i]);
            }
        }
        System.out.println(sb);

    }
}