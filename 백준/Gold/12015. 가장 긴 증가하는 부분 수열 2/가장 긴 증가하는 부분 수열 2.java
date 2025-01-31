import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] A; //수열A 요소 배열
    static int[] LISA; //가장 긴 수열 A의 부분 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //수열 A의 크기
        A = new int[N]; //수열A 요소 배열 초기화(원본)
        LISA = new int[N];  //가장 긴 부분 수열 초기화(결과 구할때 사용하는 배열)

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){ //수열A의 요소 입력받기
            A[i] = Integer.parseInt(st.nextToken());
        }

        // LISA (가장 긴 부분수열) 초기 값으로 첫 번째 수열의 값을 가진다.
        LISA[0] = A[0];
        int length = 1; //가장 긴 부분 수열의 길이 저장하는 변수

        for(int i = 1; i < N; i++){ //첫번째 수열값이 시작점이니 1부터 시작

            int keyFromA = A[i];

            // 만약 key가 LIS의 마지막 값보다 클 경우 추가해준다.
            if (LISA[length - 1] < keyFromA) {
                length++;
                LISA[length - 1] = keyFromA;
            }else{ //만약 이미 들어간 배열에서 작지 않으면
                
                //배열을 처음부터 끝까지 돌면서 가까운 값을 고르면 오래 걸리기 때문에 이분탐색을 해준다.
                int start = 0;
                int end = length;

                while(start < end){
                    int middle = (start+end)/2; //중간 값
                    if(LISA[middle] < keyFromA){ //중간값과 비교 대상의 key값을 비교했을 때 중간값이 작을 경우
                        //크기를 증가시킨다. (시작점을 증가)
                        start = middle+1;
                    }else{ //중간값과 비교대상의 key값을 비교했을 때 중간값이 더 클 경우
                        //크기를 감소시킨다. (끝점을 감소)
                        end = middle;
                    }
                }
                //가장 가까운 원소의 값을 넣어준다.
                LISA[start] = keyFromA;
            }
        }
        System.out.println(length);
    }
}