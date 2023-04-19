
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int [] arrs =  new int[5]; 
        int sum = 0; 

        for(int i =  0; i < 5; i++){
            arrs[i] = Integer.parseInt(br.readLine()); 
            sum += arrs[i]; 
        }
        br.close();

        Arrays.sort(arrs); 


        bw.write(sum/5 +"\n" + arrs[2]);

        bw.flush();
        bw.close();


    }
}