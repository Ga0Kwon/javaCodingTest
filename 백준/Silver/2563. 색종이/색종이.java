import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //도화지에 들어갈 정사각형의 개수

        int [][]paper = new int[101][101]; //0,0부터 100,100이기 때문에 101,101로 해야함[배열 인덱스!]

        int area = 0; //면적 넓이
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine()); //x, y좌표 구함
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j = x; j < x+10; j++){ //정사각형이 10x10크기 이기 때문에
                for(int h = y; h < y+10; h++){
                    if(paper[j][h] == 1){
                        continue; //이미 1이있으면 다음 반복문으로 돈다.
                    }else{
                        paper[j][h] = 1; //해당 값에 1이 있는지 판별용[즉 겹치는지]
                        area++; //넓이 값
                    }
                }
            }
        }  
        br.close();
        System.out.println(area);
    }

}