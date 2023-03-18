import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        while( (str = bufferedReader.readLine()) != null){
            st = new StringTokenizer(str, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bufferedWriter.write(a+b + "\n");
        }
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
     /*   Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.println(A+B);
        }
        sc.close();*/
    }
}