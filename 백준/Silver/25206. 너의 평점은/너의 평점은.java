import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double totalScore = 0;
        double divScore = 0; //학점의 총합

        String ScoreStr[] = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"}; //10개 요소
        double ScoreInt[] = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0}; //10개 요소

        for(int i = 0; i < 20; i++){ //20줄에 걸쳐서 성적을 입력하므로
            StringTokenizer token = new StringTokenizer(br.readLine());
            /*과목은 저장할 필요가 없다. -> 학점과 성적만 가져오겠다.*/
            ; //여기가 과목명에 해당
            token.nextToken();
            double A = Double.parseDouble(token.nextToken()); //몇 학점
            String B = token.nextToken(); //성적

            for(int j = 0; j < 10; j++){
                if(B.equals(ScoreStr[j])){
                    totalScore += A*ScoreInt[j];

                    if( j != 9){ //9번 인덱스가 P다 P는 계산에 포함 X
                        divScore += A;
                    }
                }
            }
        }
        br.close();

        System.out.printf( "%.6f", totalScore/divScore);
    }
}