import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] sdoku = new int[9][9]; //스도쿠 판 9X9

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                sdoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0);
    }

    public static void solution(int row, int col){
        //해당 행의 열이 모두 채워졌을 경우 다음 행 첫번째 부터 시작한다.
        if(col == 9){
            solution(row+1, 0);
            return;
        }

        //행과 열이 모두 채워졌을 경우 결과 스도쿠 출력
        if(row == 9){
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    sb.append(sdoku[i][j]).append(' ');
                }
                sb.append("\n");
            }

            System.out.println(sb);
            //시스템 종료
            System.exit(0);// 경우의 수가 많을 경우 '한 개'만 출력해야하기 때문 => 하나를 출력했다면 바로 시스템 종룥ㄴ
        }


        //만약 해당 위치의 값이 0(=없는 수)라면 가능한 수를 찾음
        if(sdoku[row][col] == 0){
            for(int i = 1; i <= 9; i++){
                if(checkSameNum(row, col, i)){ //넣을 수 있는 숫자이면
                    sdoku[row][col] = i; //숫자를 넣고
                    solution(row, col+1); //다음 열의 수를 확인
                }
            }
            sdoku[row][col] = 0; //다른 경우의 수를 확인하기 위해 다시 0으로 돌려놓는다.
            return;
        }

        //숫자가 존재할 경우 다음 열 검사
        solution(row, col+1);
    }

    // 같은 열/행에 해당 숫자가 있는지 없는 지 체크하여 있으면 false, 없으면 true
    public static boolean checkSameNum(int row, int col, int num){
        /* 열에 해당 숫자가 있는지 체크 */
        for(int i = 0; i < 9; i++){
            if(sdoku[row][i] == num){ //열을 증가시키면서 열에 존재하는지 확인
                return false;
            }
        }

        /* 행에 해당 숫자가 있는지 체크 */
        for(int i = 0; i < 9; i++) {
            if (sdoku[i][col] == num) {
                return false;
            }
        }

        int rowLocation = (row/3)*3; //행의 첫 위치
        int colLocation = (col/3)*3; //열의 첫 위치

        /* 존재하는 값의 위치에 해당하는 3x3 행렬에 있는지 체크 */
        for(int i = rowLocation; i < rowLocation+3; i++){
            for(int j = colLocation; j < colLocation+3; j++){
                if(sdoku[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}