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

        backTracking(0); // 배열에 저장할 열 인덱스만 파라미터로 넘긴다.
        br.close();
        System.out.println(sb);
    }

    //start부분을 파라미터에 추가한 이유
    // start를 추가하여 시작점을 바꿨다
    static void backTracking(int row) {
        if (row == M) { //순열의 크기가 M일 경우(M개의 숫자 순열을 고르는 거기때문에 이때 종료
            for(int value : list){
                sb.append(value + " "); //순열 차례대로 배열에서 꺼내서 StringBuilder에 추가
            }
            sb.append("\n");
            return;
        }

        //시작점을 설정하지 않고 1부터 쭉 나올 수 있도록 설정한다.
        for (int i = 1; i <= N; i++) {
            list[row] = i; // 해당 수열을 추가
            backTracking(row+1); //자식노드 방문
        }
    }
}
