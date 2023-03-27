import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token;

        int[][] axis = new int[n][2];

        for(int i = 0; i < n; i++){
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                axis[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        br.close();

        int x_min = axis[0][0];
        int x_max = axis[0][0];
        int y_min = axis[0][1];
        int y_max = axis[0][1];

        for(int i = 0; i < n; i++) {
            if (x_max < axis[i][0]) {
                x_max = axis[i][0];
            }

            if (x_min > axis[i][0]) {
                x_min = axis[i][0];
            }

            if (y_max < axis[i][1]) {
                y_max = axis[i][1];
            }

            if (y_min > axis[i][1]) {
                y_min = axis[i][1];
            }
        }

        System.out.println((x_max-x_min)*(y_max-y_min));

    }
}