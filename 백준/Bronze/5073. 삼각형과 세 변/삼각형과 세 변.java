import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            
            //배열이 아닌 int형 변수 선언
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            if(a == 0&& b == 0 && c == 0){
                break;
            }

            if((a >= b+ c) || (b >= a+ c) || (c >= a+ b)){ //삼각형에 부합하지 않을 경우
                bw.write("Invalid\n");
            }else if(a ==b && b == c){ //세변이 같을 경우
                bw.write("Equilateral\n");
            }else if((a == b) || (a == c) || (b == c)){ //두변이 같을 경우
                bw.write("Isosceles\n");
            }else if((a != b) && (b != c) && (c != a)){ //세변이 전부 다를 경우
                bw.write("Scalene\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}