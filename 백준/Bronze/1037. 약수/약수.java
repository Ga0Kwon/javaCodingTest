import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine()); //약수의 개수

        int[] divisor = new int[count]; //약수를 저장할 배열

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < count; i++){
            divisor[i] = Integer.parseInt(st.nextToken()); //진짜 약수들 입력받기
        }

        //약수들을 작은 순으로 정렬 후, 입력받은 진짜 약수의 0번째 인덱스 값과 마지막 인덱스 값을 곱하면 N을 찾을 수 있다.
        Arrays.sort(divisor);

        bw.write(divisor[0] * divisor[count-1] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}