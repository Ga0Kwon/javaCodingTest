import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //입력 받을 집의 개수
        int C = Integer.parseInt(st.nextToken()); //설치할 공유기의 개수

        home = new int[N]; //입력 받은 집의 위치

        //집의 개수 만큼 집의 위치를 입력 받는다.
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home); //위치 순으로 정렬 (처음부터 끝까지)

        //만약 +1이 없다면, 탐색 과정에서 가장 마지막 거리인 home[N-1] - home[0]은 탐색 범위에서 제외되기 때문에 +1을 해준다.
        // +1은 탐색 범위를 포함-미포함 방식으로 다루는 이진 탐색의 특성을 고려한 것
        int max = home[N-1] - home[0] + 1; //최대값(거리)
        int min = 1; //최솟값(거리)

        while(min < max){
            int mid = (max+min)/2; //중간 값

            //mid(중간 값)으로 공유기 개수가 M개보다 적으면 거리를 좁힌다.
            if(getWifiCount(mid) < C){
                max = mid;
            }else{
                /*
                    mid(중간 값)으로 공유기 개수를 구했을 때 M개보다 크거나 같으면 거리를 벌리면서
                    최소 거리가 가질 수 있는 최대거리를 구한다.
                */

                min = mid+1;
            }

        }

        System.out.println(min-1);
    }

    //거리(간격)을 입력받아 공유기 설치 개수를 구하는 메소드
    public static int getWifiCount(int dist){
        //첫번째 집은 무조건 설치
        int count = 1;
        int updatePosition = home[0];

        for(int i = 1; i < home.length; i++){
            int currentPosition = home[i];

            /*
              현재 탐색하는 집의 위치와 바로 전에 설치했던 집의 거리가
              입력받은 파라미터 거리(dist)보다 클때 공유기를 설치하고 마지막 설치 위치를 갱신한다.
            */

            if(currentPosition - updatePosition >= dist) {
                count++;
                updatePosition = currentPosition;
            }
        }

        return count;
    }
}