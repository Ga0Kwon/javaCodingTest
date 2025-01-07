import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //기존 나무의 개수 N
        int M = Integer.parseInt(st.nextToken()); //가져가야할 나무의 길이 M

        int[] trees = new int[N]; //기존 나무의 길이를 담는 배열

        long max = 0;

        st = new StringTokenizer(br.readLine());

        //나무의 개수 K만큼 나무의 길이를 입력 받는다.
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (max < trees[i]) { //기존 나무 길이에서 최댓값
                max = trees[i];
            }
        }

        long min = 0;
        long mid = 0;

        while (min < max) {
            // 범위 내에서 중간 길이(mid)를 구한다.
            mid = (max + min) / 2;

            long sum = 0;

            for (int i = 0; i < trees.length; i++) {
               if(trees[i] - mid > 0){ //나무의 길이가 기준 값보다 클경우만 자를 수 있기 때문에 trees[i] - mid > 0
                   sum += trees[i] - mid; //자르고 나머지를 더한다.
               }
            }

            if (sum < M) { //만들려는 길이보다 작을 경우
                max = mid;
            } else{ //만들려는 길이보다 크거나 같을 경우
                min = mid + 1;
            }
        }
        System.out.println(min-1);
    }
}