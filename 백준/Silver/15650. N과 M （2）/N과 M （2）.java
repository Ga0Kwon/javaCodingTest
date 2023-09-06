import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N; // N
    static int M; // M
    static int[] list; //해당 순열을 저장하는 배열
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //N
        M = Integer.parseInt(st.nextToken()); //M

        list = new int[M]; //M개의 숫자의 순열 저장하는 배열 초기화

        backTracking(1,0); // 1~N임으로 시작 1
        br.close();
        System.out.println(sb);
    }

    //start부분을 파라미터에 추가한 이유 => 1 3과 3 1은 같은 수열이기 때문에 빼기 위해
    // start를 추가하여 시작점을 바꿨다
    static void backTracking(int start, int row) {
        if (row == M) { //순열의 크기가 M일 경우(M개의 숫자 순열을 고르는 거기때문에 이때 종료
            for(int value : list){
                sb.append(value + " "); //순열 차례대로 배열에서 꺼내서 StringBuilder에 추가
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            list[row] = i; //재귀함수에 i+1값으로 시작점을 바꿔야하기 때문에 i를 넣어준다. (start 최소값이 1이기 때문)
            backTracking(i+1,row+1); //자식노드 방문
        }
    }
}

        