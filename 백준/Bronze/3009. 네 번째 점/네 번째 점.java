import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token;

        int x_axis[] = new int[3];
        int y_axis[] = new int[3];
        
        for(int i = 0; i < 3; i++) {
            token = new StringTokenizer(br.readLine());

            x_axis[i] = Integer.parseInt(token.nextToken());
            y_axis[i] = Integer.parseInt(token.nextToken());
        }
        
        br.close();

        bw.write(findAxis(x_axis) + " " + findAxis(y_axis));
        bw.flush();
        bw.close();
    }

    static int findAxis(int[] array){
        if(array[0] == array[1]){
            return array[2];
        }else{

            return (array[0] == array[2]) ? (array[1]) : (array[0]);
        }
    }
}