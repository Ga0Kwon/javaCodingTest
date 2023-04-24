
import java.io.*;
import java.util.Arrays;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //입력 숫자의 개수

        int[]arrays = new int[10001]; //N이 10,000보다 작거나 같다고 했으므로 인덱스가 0부터이므로 10001까지

        for(int i = 0; i < N; i++){
            arrays[Integer.parseInt(br.readLine())]++; //해당 입력받은 값을 인덱스로 갖는 요소의 값을 증가시킴
        }

        for(int i = 0; i < 10001; i++){
            while(arrays[i] > 0){ //0보다 크면 ++한것이므로 입력받은 숫자에 속한다는 뜻
                bw.write(i + "\n"); //arrays[i] 값은 i의 값이 몇번있냐를 의미하는 것이고, 실질적으로 입력받은 값은 i이다.
                arrays[i]--; //한번 꺼냈으니 --해준다.
            }
        }

        bw.flush();
        bw.close();

    }
}