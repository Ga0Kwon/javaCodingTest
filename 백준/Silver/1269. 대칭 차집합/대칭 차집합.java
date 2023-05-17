import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); //A 집합 요소 개수
        int B = Integer.parseInt(st.nextToken()); //B 집합 요소 개수

        //중복을 알아서 제거해줌
        HashSet<Integer> Elements = new HashSet<Integer>(); //요소들을 저장할 공간

        st = new StringTokenizer(br.readLine()); //A의 요소를 받음
        
        for(int i = 0; i < A; i++) {
            Elements.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine()); //B의 요소를 받음
        for(int i = 0; i < B; i++) {
            Elements.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println((Elements.size() - B) + (Elements.size() - A));

    }
}