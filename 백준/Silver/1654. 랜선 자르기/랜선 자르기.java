import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); //기존 랜선의 개수 K
        int N = Integer.parseInt(st.nextToken()); //만들어야할 랜선의 개수 N

        int[] num = new int[K]; //기존 랜선의 개수 K의 길이를 담는 배열

        long max = 0;

        //랜선의 개수 K만큼 랜선의 길이를 입력 받는다.
        for (int i = 0; i < K; i++) {
            num[i] = Integer.parseInt(br.readLine());
            if (max < num[i]) { //기존 랜선 길이에서 최대 길이
                max = num[i];
            }
        }

        /* 랜선 길이(=1)가 동일할 경우 max에 +1를 하지 않는 경우 error이 날 수 있음
            ex.
            mid = (max+min)/2 = 0
            mid = (1+0)/2 = 0
            count += (num[i] / 0) >> error!

            mid = ((max+1)+min)/2 = 1
            mid = (2+0)/2 = 1
            count += (num[i] / 1) >> ok
        */
        max++;


        long min = 0;
        long mid = 0;

        while (min < max) {
            // 범위 내에서 중간 길이(mid)를 구한다.
            mid = (max + min) / 2;

            long count = 0; //잘라서 만들어지는 랜선의 개수

            // 구해진 중간 길이(mid)로 잘라서 총 몇 개가 만들어지는지를 구한다.
            for (int i = 0; i < num.length; i++) {
                count += (num[i] / mid);
            }

            /*
             [중간길이(mid)로 잘랐을 때]

             만들려는 개수보다 적은 경우
              > 최대 길이(max)를 줄인다.

             만들려는 개수보다 크거나 같을 경우
              > 자르고자 하는 길이를 늘려야 하므로 최소 길이(min)를 늘린다.
              
             */
            if (count < N) { //만들려는 개수보다 작으면
                max = mid;
            } else{ //만들려는 개수보다 크거나 같을 경우
                min = mid + 1;
            }
        }
        System.out.println(min-1);
    }
}