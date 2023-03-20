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
            for(int j = 0;  j < N; j++){
                students[j] = Integer.parseInt(token.nextToken());
            }
            String str = String.format("%.3f", getOverAvg(students));
            sb.append(str+"%\n");
        }
        br.close();
        System.out.println(sb);
    }

    static double getAvg(int [] array){
        double total = 0;
        for(int i = 0; i < array.length; i++){
            total += array[i];
        }
        return total/array.length;
    }

    static double getOverAvg(int [] array){
        double avg = getAvg(array);
        double overStudent = 0;
        for(int i = 0; i < array.length; i++){
            if(avg < array[i]){
                overStudent++;
            }
        }
        return (overStudent/ array.length)*100;
    }
}