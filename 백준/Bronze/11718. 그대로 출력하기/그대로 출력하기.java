import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 100; i++){
            String str = br.readLine();
            if(str == null || str.isEmpty()){ //str이 비어있거나 null이면
                break; //반복문을 끝낸다.
            }
            sb.append(str + "\n");
        }
        br.close();
        System.out.println(sb);
    }
}
