import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] arrays = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        Arrays.sort(arrays);

        int roundSum = 0;

        if(arrays[0] + arrays[1] <= arrays[2]){
            int maxLength = arrays[0] + arrays[1] - 1; //각 막대의 길이는 양의 정수
            roundSum += arrays[0] + arrays[1] + maxLength;
        }else{
            roundSum += arrays[0] + arrays[1] + arrays[2];
        }

        System.out.println(roundSum);

        br.close();
    }
}