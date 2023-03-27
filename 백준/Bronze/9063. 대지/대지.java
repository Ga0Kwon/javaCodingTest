import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int x_axis[] = new int[n]; //x좌표 배열 따로
        int y_axis[] = new int[n]; //y좌표 배열 따로

        int x_min = Integer.MAX_VALUE;
        int x_max = Integer.MIN_VALUE;
        int y_min = Integer.MAX_VALUE;
        int y_max = Integer.MIN_VALUE;

        for(int i  = 0; i < n; i++){
            //어차피 token for문 안에서만 쓰니까
            StringTokenizer token = new StringTokenizer(br.readLine());
            x_axis[i] = Integer.parseInt(token.nextToken());
            y_axis[i] = Integer.parseInt(token.nextToken());


            //for문을 최소화로 하기 위해 if문으로 해서 각 x, y의 최솟값을 구했다.
            if(y_axis[i] >  y_max){
                y_max = y_axis[i];
            }

            if(y_axis[i] < y_min){
                y_min = y_axis[i];
            }

            if(x_axis[i] >  x_max){
                x_max = x_axis[i];
            }

            if(x_axis[i] < x_min){
                x_min = x_axis[i];
            }
        }
        br.close();

        System.out.println((x_max-x_min)*(y_max-y_min));
    }
}