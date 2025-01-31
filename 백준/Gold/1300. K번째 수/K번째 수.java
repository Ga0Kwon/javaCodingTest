import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //배열의 행과 열의 크기 (NxN의 배열이 만들어짐)
        int K = Integer.parseInt(br.readLine()); //정렬된 배열 B에서의 구하고자 하는 인덱스

        //변수 X는 start <= X <= end의 범위값을 가진다.
        long start = 1; //초기값 ; 최소 1개
        long end = K; //초기값 ; K개보다 더 많은 값을 가질 수 없기 때문

        while(start < end){

            long mid = (start+end)/2; //중간 값 (=X값 조정)
            long count = 0; //개수

            //구구단 공식을 사용해서 해당 단에는 몇개의 X보다 적거나 같은 수를 가질 수 있는지 누적합을 통해 구한다.
            for(int i =1; i <= N; i++){
                count += Math.min(mid/i, N);
            }

            //count가 많다는 것은 중간값으로 설정한 X값보다 작은 수가 K보다 많다는 뜻
            if(K <= count){
                end = mid; //크기를 줄이면된다.
            }else{
                start = mid+1; // 크기를 늘린다.
            }
        }

        System.out.println(start);
    }


}