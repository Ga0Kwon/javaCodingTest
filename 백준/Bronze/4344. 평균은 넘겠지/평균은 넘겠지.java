import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int C = Integer.parseInt(br.readLine());

        for(int i = 0; i < C; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken()); //줄마다 사람 수
            int [] students = new int[N];
            double total = 0;

            for(int j = 0;  j < N; j++){
                students[j] = Integer.parseInt(token.nextToken());
                total += students[j];
            }

            double avg = total/N;

            int count = 0;
            for(int j = 0; j < N; j++){
                if(students[j] > avg){
                    count++;
                }
            }
            String str = String.format("%.3f", ((double)count/(double)N)*100);
            
            sb.append(str+"%\n");
        }
        br.close();
        System.out.println(sb);
    }
}