import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int[] numArr; //배열
    static Integer[] memoArr; //값을 저장할 배열
    static int max; //최댓값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        numArr = new int[N];
        memoArr = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        /*
          * memoArr[0]은 첫 원소로 이전에 더 이상 탐색할 것이 없기 때문에
          * numArr[0]의 값이 되기 때문에 numArr[0]으로 초기화
          * max도 첫 번째 원소로 초기화
        */
        memoArr[0] = numArr[0];
        max = numArr[0];

        //memoArr의 마지막 인덱스는 N-1이기때문에
        solution(N-1);

        System.out.println(max);
    }

    //최대 연속합을 찾는 메소드
    static int solution(int N){
        //탐색하지 않았다면,
        if(memoArr[N] == null){
            //이전 배열의 합한 값 + 현재의 값 중 최댓값을 넣는다.
            memoArr[N] = Math.max(solution(N-1) + numArr[N], numArr[N]);

            max = Math.max(memoArr[N], max);
        }

        return memoArr[N];

    }
}