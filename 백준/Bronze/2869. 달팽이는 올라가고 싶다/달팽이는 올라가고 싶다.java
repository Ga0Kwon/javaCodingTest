import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        //(1 ≤ B < A ≤ V ≤ 1,000,000,000) => long
        long A = Long.parseLong(st.nextToken()); //낮에 올라갈 수 있는 미터
        long B = Long.parseLong(st.nextToken()); //밤에 자는 동안 미끄러지는 미터
        long V = Long.parseLong(st.nextToken()); // 총 나무 막대 미터

        long dayDist = A - B; //하루에 움직이는 거리(미터)
        long goalDest = V -B; //최종 목적지(미터)
        
        // 최종목적지 / 하루에 움직이는 거리
        if(goalDest%dayDist != 0){ //나눠 떨어지지 않는 경우는 하루를 더 추가로 가야한다는 것
            System.out.println(goalDest/dayDist + 1);
        }else{ // 나눠떨어진다는 것은 바로 낮에 도착했다는 뜻
            System.out.println(goalDest/dayDist);
        }

    }
}
