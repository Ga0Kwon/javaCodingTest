import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine()); //총 사람 수

        int[] schedule = new int[N]; // 사람 횟수

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            schedule[i] =  Integer.parseInt(st.nextToken()); //시작 시간
        }

        br.close();

        Arrays.sort(schedule); //배열 정렬 (적은 시간 -> 큰 시간)

        int[] preSum = new int[N]; //시간을 누적합해서 저장할 배열

        preSum[0] = schedule[0];
        int result = preSum[0]; //총 최소 시간을 넣는 배열

        for(int i = 1; i < schedule.length; i++){
            preSum[i] = preSum[i-1] + schedule[i]; //누적합
            result += preSum[i]; //총 최소 시간 
        }

        System.out.println(result);

    }
}