import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> noDuplication = new HashSet<>(); //중복값을 제거해주는 클래스

        for(int i = 0; i < 10; i++){
            noDuplication.add((Integer.parseInt(br.readLine()))%42);
        }

        br.close();

        System.out.println(noDuplication.size());

    }
}
