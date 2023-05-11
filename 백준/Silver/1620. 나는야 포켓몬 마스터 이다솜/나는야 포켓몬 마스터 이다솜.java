import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> poketArray_String = new HashMap<>();
        HashMap<String, Integer> pocketArray_int = new HashMap<>();

        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            poketArray_String.put(i, str);
            pocketArray_int.put(str, i);
        }

        for(int i = 0; i < M; i++){
            String pocket = br.readLine();
            if(isNum(pocket)){
                bw.write(poketArray_String.get(Integer.parseInt(pocket)) + "\n");
            }else{
                bw.write(pocketArray_int.get(pocket) + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
    public static boolean isNum(String str) { 
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}