
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        //기본형이 아닌 List개열 중에 써야한다. Collections.sort()를 쓰기 위해 Arrays.sort보다 빠름
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        br.close();

        Collections.sort(list);

        for(int i : list){
            bw.write(i + "\n");
        }


        bw.flush();
        bw.close();


    }
}