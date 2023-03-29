import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            
            //배열로 저장
           int [] array = {Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken())};


            if(array[0] == 0&& array[1] == 0 && array[2] == 0){
                break;
            }

            if((array[0] >= array[1]+ array[2]) || (array[1] >= array[0]+ array[2]) || (array[2] >= array[0]+ array[1])){ //삼각형에 부합하지 않을 경우
                bw.write("Invalid\n");
            }else if(array[0] ==array[1] && array[1] == array[2]){ //세변이 같을 경우
                bw.write("Equilateral\n");
            }else if((array[0] == array[1]) || (array[0] == array[2]) || (array[1] == array[2])){ //두변이 같을 경우
                bw.write("Isosceles\n");
            }else if((array[0] != array[1]) && (array[1] != array[2]) && (array[2] != array[0])){ //세변이 전부 다를 경우
                bw.write("Scalene\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}