import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //동전의 총 종류
        int K = Integer.parseInt(st.nextToken()); //만들어야하는 금액
        
        int[] coinArr = new int[N]; //동전의 종류(가치)별로 넣는 배열
        
        for(int i = 0;  i < N; i++){ //동전의 총 종류 수만큼
            coinArr[i] = Integer.parseInt(br.readLine()); //동전 가치 넣기 
        }

        br.close();

        int cnt = 0; //코인 넣는 횟수
        //동전이 큰 값부터 비교해야 더 적게 비교할 수 있으므로 거꾸로 반복문을 진행한다.
        for(int i = N-1; i >= 0; i--){
            if(coinArr[i] <= K){
                //현재 반복문이 돌고 있는 동전의 값을 넣을 수 있는 만큼 넣는다.
                // 큰 값 -> 작은 값 이기 때문에 큰 값이 많이 들어가야 K(금액)을 만들기 위해 최소 동전 개수를 구할 수 있다.
                cnt += (K / coinArr[i]);
                K = (K % coinArr[i]); //K(금액)을 갱신(그래야 초기 K값을 -하여 만들 수 있기 때문)
            }
        }

        bw.write(cnt+"\n");
        bw.flush();
        bw.close();


    }
}