import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N; // N
    static int M; // M
    static int[] list; //해당 순열을 저장하는 배열
    static boolean[] check; //방문여부 체크하는 배열

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //N
        M = Integer.parseInt(st.nextToken()); //M

        list = new int[M]; //M개의 숫자의 순열 저장하는 배열 초기회
        check = new boolean[N]; //방문 체크하는 배열 초기화

        backTracking(0);
        br.close();
        System.out.println(sb);
    }

    static void backTracking(int row) {
        if (row == M) { //순열의 크기가 M일 경우(M개의 숫자 순열을 고르는 거기때문에 이때 종료
            for(int value : list){
                sb.append(value + " "); //순열 차례대로 배열에서 꺼내서 StringBuilder에 추가
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (check[i] == false) {
                check[i] = true; //자식노드 방문할때 자기자신을 빼야하므로 true처리
                list[row] = i+1; //1부터 N까지의 숫자가 들어가기 때문에 i는 0부터 시작하므로 i+1을 넣어준다.
                backTracking(row+1); //자식노드 방문
                check[i] = false; //자식노드 모두 방문했으면 부모노드 다시 방문기록지움
            }
        }
    }
}

        