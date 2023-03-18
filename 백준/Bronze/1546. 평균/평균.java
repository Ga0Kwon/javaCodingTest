import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());

        double [] score = new double[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            score[i] = Integer.parseInt(token.nextToken());
        }

        br.close();
        double Max =  findMaxScore(score);

        double totalScore = 0;

        for(int i = 0; i < score.length; i++){
            totalScore += ((score[i]/Max)*100);
        }
        
        System.out.println(totalScore/score.length);

    }

    static double findMaxScore(double [] array){
        double max = array[0];

        for(int i = 0; i < array.length; i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        return max;
    }
}
