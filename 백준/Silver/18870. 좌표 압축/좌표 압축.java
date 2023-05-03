import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] notSortArr = new int[N];
        for(int i = 0; i < N; i++){
            notSortArr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        int[] sortArr = notSortArr.clone();

        Arrays.sort(sortArr);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int index = 0;
        // 비교할 배열 만들기
        for(int i : sortArr){
            if(!map.containsKey(i)){
                map.put(i, index++);
            }
        }

        for(int i : notSortArr){
            bw.write(map.get(i) + " ");
        }

        bw.flush();
        bw.close();
    }
}