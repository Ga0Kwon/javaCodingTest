import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine()); //총 회의의 개수

        //int[N][0] = 회의 시작 시간
        //int[N][1] = 회의 종료 시간
        int[][] schedule = new int[N][2]; // (시작시간, 종료시간)을 구현하기 위해 이차원 배열로

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            schedule[i][0] =  Integer.parseInt(st.nextToken()); //시작 시간
            schedule[i][1] =  Integer.parseInt(st.nextToken()); //종료 시간
        }

        br.close();

        //종료시간이 짧은 순으로 정렬해야 함. (단, 종료시간이 같을 경우에는 시작시간이 빠른 것)
        /* 종료시간이 같을 경우 시작 시간이 빠른 걸로 정렬해야 하는 이유.
            1  3
            6  7
            7  7
            이 있을 경우 1 ~ 3을 선택하고 그 다음 시작 시간은 3이 되었을 것이다.
            근데 여기서 시작시간이 빠른 걸로 선택을 안했다면
            1  3
            7  7
            6  7
            로 정렬된 경우
            다음 7~7로 인해 그 다음 시작 시간이 7이 되었을 거고 6 ~ 7은 충분히 들어갈 수 있음에도
            그 다음 시작 시간이 7이 되는 바람에 들어갈 수 없게 된다
            => 최대의 총 회의 개수를 구할 수 없게 된다.
         */
        Arrays.sort(schedule, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {

                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬
                if(o1[1] == o2[1]) {
                    /*
                        [오름차순 정렬]
                        o1  > o2  => o1이 더 큼 => 정렬 시 o1이 o2의 뒤에 위치
                        o1 == o2  - return 0  : 순서를 변경X
                        o1  < o2  => o2가 더 큼 => 정렬 시 o2가 o1의 뒤에 위치
                    */
                    return o1[0] - o2[0];

                }

                return o1[1] - o2[1];
            }

        });


        int count = 0;
        int resetStartTime = 0;

        for(int i = 0; i < N; i++) {
            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같으면 회의 개수에 카운트 + 1
            if(resetStartTime <= schedule[i][0]) {
                resetStartTime = schedule[i][1];
                count++;
            }
        }

        System.out.println(count);

    }
}