import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //숫자의 개수
        int M = Integer.parseInt(st.nextToken()); //나누는 수

        st =  new StringTokenizer(br.readLine());

        int[] count;
        //입력과 동시에 누적합 구하기
        count = new int[M]; //나머지 종류별로

        int sum = 0; //누적합
        for(int i = 0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            sum = (sum+num)%M; //누적합하여 M으로 나눈 나머자
            count[sum]++;
        }

        long cnt = count[0]; //자기 스스로 나머지가 0이 나오는 경우
        for(int i = 0; i < count.length; i++){
            //조합으로 나머지가 0이 나오는 경우
           cnt += (long)count[i] * (count[i]-1)/2; //10^6 * 10^6임으로 overflow 방지로 long형으로
        }

        System.out.println(cnt);
    }

}