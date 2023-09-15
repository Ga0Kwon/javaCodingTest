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

        backTracking(1, 0); // 배열에 저장할 열 인덱스만 파라미터로 넘긴다.
        br.close();
        System.out.println(sb);
    }

    //start부분을 통해 시작점을 판별할 수 있게끔 하였다. (각각의 숫자는 내림차순이거나 같아야하므로)
    static void backTracking(int start, int row) {
        if (row == M) { //순열의 크기가 M일 경우(M개의 숫자 순열을 고르는 거기때문에 이때 종료
            for(int value : list){
                sb.append(value + " "); //순열 차례대로 배열에서 꺼내서 StringBuilder에 추가
            }
            sb.append("\n");
            return;
        }

        //리스트엔 넣기
        for (int i = 1; i <= N; i++) {
            if(i >= start){ //i가 start보다 크거나 같을때만 list에 추가
                list[row] = i; // 해당 수열을 추가
                backTracking(i,row+1); //자식노드 방문
            }
        }
    }
}
