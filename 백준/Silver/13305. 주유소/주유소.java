import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //지역의 개수

        int[] oil = new int[N-1]; //지역->지역으로 필요한 기름의 양
        int[] cost = new int[N];  //지역별 기름 값

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < oil.length; i++){ //필요한 기름의 양 입력
           oil[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int prevMin = Integer.MAX_VALUE; //전인덱스 기준으로 최솟값 저장하는 변수
        
        for(int i = 0; i < cost.length; i++){ //지역별 기름 값 입력
            int currentValue = Integer.parseInt(st.nextToken());

            if(prevMin > currentValue){ //이전 비용보다 현재 비용이 더 작을 경우 현재 비용으로 갱신
                cost[i] = currentValue;
                prevMin = currentValue;
            }else{ // 같거나 클 경우 
                cost[i] = prevMin; // 이전 비용을 그대로 사용
            }
        }

        br.close();

        long result = 0; //결과(최소 비용)

        for(int i = 0; i < N-1; i++){
            result += ((long) cost[i] *oil[i]);
        }

        System.out.println(result);

    }
}