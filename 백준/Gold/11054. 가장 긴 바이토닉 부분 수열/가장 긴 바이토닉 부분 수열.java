import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static Integer[] dp_right;
    static Integer[] dp_left;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp_right = new Integer[N];	// 왼->오
        dp_left = new Integer[N];	// 오->왼
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            solution_right(i);
            solution_left(i);
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(dp_right[i] + dp_left[i], max);
        }

        System.out.println(max - 1);
        br.close();
    }

    static int solution_right(int N) {

        // 만약 아직 조회하지 않은 경우
        if (dp_right[N] == null) {
            dp_right[N] = 1; // 1로 초기화

            // N 이전 노드 탐색
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] < arr[N]) {
                    dp_right[N] = Math.max(dp_right[N], solution_right(i) + 1);
                }
            }
        }
        return dp_right[N];
    }

    static int solution_left(int N) {

        // 만약 아직 조회하지 않은 경우
        if (dp_left[N] == null) {
            dp_left[N] = 1; // 1로 초기화

            // N 이후 노드 탐색
            for (int i = N + 1; i < dp_left.length; i++) {
                if (arr[i] < arr[N]) {
                    dp_left[N] = Math.max(dp_left[N], solution_left(i) + 1);
                }
            }
        }
        return dp_left[N];
    }
}