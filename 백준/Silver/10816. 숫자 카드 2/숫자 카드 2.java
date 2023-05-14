import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] sangeunArray = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sangeunArray[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        
        Arrays.sort(sangeunArray);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int value = Integer.parseInt(st.nextToken());
            bw.write(findEndIndex(sangeunArray,value) - findStartIndex(sangeunArray, value) + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static int findStartIndex(int[] array, int value) {
        int left = 0;
        int right = array.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (value <= array[mid]) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int findEndIndex(int[] array, int value) {
        int left = 0;
        int right = array.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (value < array[mid]) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

}