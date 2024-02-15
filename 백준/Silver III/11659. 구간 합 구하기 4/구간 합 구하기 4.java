import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //주어진 수의 개수(N)
        int M = Integer.parseInt(st.nextToken()); //누적합을 수행해야하는 횟수(M)

        number = new int[N+1]; // 인덱스는 0부터 시작하는데 구간은 1부터 시작하므로 N+1을 해줬다. (직관적으로 구할 수 있게)

        st = new StringTokenizer(br.readLine());

        number[0] = 0; //인덱스 0은 0으로 초기화
        for(int i = 0; i < N; i++) { //누적합할 숫자 배열에 넣기
            number[i+1] = number[i] + Integer.parseInt(st.nextToken()); //누적합을 해서 넣는 것이다.
        }

       while(M --> 0){
           st = new StringTokenizer(br.readLine());
           int i = Integer.parseInt(st.nextToken()); //i번째 부터
           int j = Integer.parseInt(st.nextToken()); //j번재 까지

            bw.write(number[j] - number[i - 1] + "\n"); //i번째는 i를 포함이므로 그 전의 값을 빼야하는 구조
        }

       br.close();
       bw.flush();
       bw.close();

    }

}