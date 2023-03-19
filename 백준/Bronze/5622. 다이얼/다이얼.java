import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            옆에 있는 숫자를 클릭할때 +1초임으로 [일단 1은 2초] +1을 해주면 된다!
            1 2초
            2 ABC 3초
            3 DEF 4초
            4 GHI 5초
            5 JKL 6초
            6 MNO 7초
            7 PQRS 8초
            8 TUV 9초
            9 WXYZ 10초
            0 11초
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        br.close();

        String str = token.nextToken();

        int time = 0;
        for(int i = 0; i < str.length(); i++){
            time += chagetime(String.valueOf(str.charAt(i)));
        }
        System.out.println(time);
    }
    static int chagetime(String ch){
        if("ABC".contains(ch)){
            return 3;
        }else if("DEF".contains(ch)){
            return  4;
        }else if("GHI".contains(ch)){
            return  5;
        }else if("JKL".contains(ch)){
            return  6;
        }else if("MNO".contains(ch)){
            return  7;
        }else if("PQRS".contains(ch)){
            return  8;
        }else if("TUV".contains(ch)){
            return  9;
        }else if("WXYZ".contains(ch)){
            return  10;
        }else if("0".contains(ch)){
            return  11;
        }else{ //1클릭시
            return 2;
        }
    }
}
