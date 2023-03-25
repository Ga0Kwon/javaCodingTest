import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        br.close();

        int x = Integer.parseInt(token.nextToken());
        int y = Integer.parseInt(token.nextToken());
        int w = Integer.parseInt(token.nextToken());
        int h = Integer.parseInt(token.nextToken());
        
        //직사각형의 경계선까지 가는 거리[w, h로 가는 거리가 아니다.]
        int x_axisMin = min(x, w-x);
        int y_axisMin = min(y, h-y);

        System.out.println(min(x_axisMin, y_axisMin));
    }

}