import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static char[] RArr; //R 배열
    static char[] SArr; //S 배열
    static Integer[][] dp; //R(열)와 S(행)로 작성했던 그 테이블을 표현할 배열!

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //문자열 입력 받기
        String RStr = br.readLine();
        String SStr = br.readLine();

        //배열 문자열의 길이만큼 초기화
        RArr = new char[RStr.length()];
        SArr = new char[SStr.length()];

        //RXS 크기 만큼의 이차원배열 초기회
        dp = new Integer[RStr.length()][SStr.length()];

        //문자열을 하나하나 쪼개서 배열에 넣기(단위 : 문자)
        RArr = RStr.toCharArray();
        SArr = SStr.toCharArray();

        //해당 인덱스가 0부터 시작하므로 -1을 한 값을 넣어준다.(각각의 길이)
        System.out.println(LCS(RStr.length()-1, SStr.length()-1));
    }

    //최대 부분 문자열 길이 구하기
    static int LCS(int RIndex, int SIndex){
        if(RIndex == -1 || SIndex == -1){ //공집합을 가리킬 경우(존재하지 않은 값일 경우)
            // 이 조건식 빼면 에러가 생길 수 있음(=outbound error??)
            return 0;
        }

        if(dp[RIndex][SIndex] == null){ //탐색하지 않은 자리일 경우
            if(RArr[RIndex] == SArr[SIndex]){ //만약 해당 자리가 같은 값일 경우 해당 자리값을 추가한다. 즉 길이 +1
                dp[RIndex][SIndex] =  LCS(RIndex-1, SIndex-1) +1;
            }else{ //해당 자리의 값들이 서로 다른 값일 경우 R(i-1), S(j) 의 값과 R(i), S(j-1)의 값 중 긴 값의 길이를 넣으면 된다.
                dp[RIndex][SIndex] =  Math.max(LCS(RIndex-1, SIndex), LCS(RIndex,SIndex-1));
            }
        }

        return dp[RIndex][SIndex];
    }
}