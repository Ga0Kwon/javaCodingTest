import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        int arrays[][] = new int[9][9];


        for(int i = 0; i < 9; i++){
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                arrays[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        br.close();

        int max = 0; //최댓값을 저장하는 변수
        int row = 0; //최댓값의 행을 저장하는 변수
        int col = 0; //최댓값의 열 인덱스를 저장하는 변수

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(max < arrays[i][j]){
                    max  = arrays[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println(max + "\n" + (row+1) + " " + (col+1) + " ");
    }
}