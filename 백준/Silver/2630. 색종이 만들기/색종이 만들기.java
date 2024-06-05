import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] colorPaper; //정사각형 색종이 색 구별(1과 0으로)

    //흰색, 파란색 색상 카운트할 변수
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //종이의 한 변의 길이 N

        colorPaper = new int[N][N]; //정사각형 색종이 색 구별(1과 0으로)

        for(int i = 0; i < N; i++){ //색종이 내부의 1과 0 입력받기
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                colorPaper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        cutPaper(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    static void cutPaper(int row, int col, int size){//색종이 탐색 시작점

        if(chkColor(row, col, size)){ //색비교했을 때 정사각형을 이루면 (해당 (row, col, row+size, col+size)의 정사각형이)
            if(colorPaper[row][col] == 0){ //흰색이면
                white++; //흰색 색종이 추가
            }else{ //파란색이면
                blue++; //파란색 색종이 추가
            }
            return;
        }

        int mSize = size/2; //절반 사이즈 (left+right)/2와 같은 역할을 함
        
        cutPaper(row, col+mSize, mSize);            //1사분면
        cutPaper(row, col, mSize);                      //2사분면
        cutPaper(row+mSize, col, mSize);           //3사분면
        cutPaper(row+mSize, col+mSize, mSize); //4사분면
    }

    static boolean chkColor(int row, int col, int size){ //색종이 색 확인
        int color = colorPaper[row][col]; // (row, col)을 기준(처음 색)으로 색 비교

        for(int i = row; i < row+size; i++){
            for(int j = col; j < col+size; j++){
                if(colorPaper[i][j] != color){ //처음 색 기준으로 색이 다르면 (정사각형을 만들 수 X)
                    return false; //다른색이 하나라도 있다면
                }
            }
        }
        
        return true; //모두 같은 색이면
    }
}