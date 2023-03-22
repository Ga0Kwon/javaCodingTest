import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

       String[] strs = new String[5];

        for(int i = 0; i < 5; i++){
            strs[i] = br.readLine();
        }
        br.close();

        for(int i = 0; i < 15; i++){
            for(int j = 0; j < strs.length; j++){
                if(i < strs[j].length()){
                    sb.append(strs[j].charAt(i));
                }
            }
        }
        System.out.println(sb);

    }
}