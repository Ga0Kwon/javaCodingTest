import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] histogram;

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int N;

        while(true){
            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());

            if(N == 0){ //종료 조건
                break;
            }

            histogram = new int[N];

            for(int i = 0; i < N; i++){ //히스토그램 입력
                histogram[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(dividArea(0, N-1)).append("\n");

        }

        br.close();
        System.out.println(sb);

    }

    //히스토그램 분할
    static long dividArea(int start, int end){
        
        if(start == end) { //더 이상 분할 할 수 없을 때
            return histogram[end];
        }

        int middle = (start+end)/2;

        //(0 ≤ hi ≤ 1,000,000,000) 이기 때문에 long형
        long leftHeight = dividArea(start, middle);
        long rightHeight = dividArea(middle+1, end);

        long maxWidth = Math.max(leftHeight, rightHeight); //쪼개는 순으로 최대값을 가져옴.

        /*
        * 쪼개지는 부분에 서로 이웃한 부분이 최대가 될 수 있기 때문에
        * 중간 분위 탐색해서 최대값을 한번 더 비교해 구한다.
        * */

        maxWidth = Math.max(maxWidth, getWidthToMiddle(start, end, middle));

        return maxWidth;
    }


    static long getWidthToMiddle(int start, int end, int middle){
        int toLeft = middle;  //중간 지점부터 왼쪽으로
        int toRight = middle; //중간 지점부터 오른쪽으로

        //중간 지점 높이
        long midHeight = histogram[middle];

        // 초기 넓이
        long maxArea = midHeight;

        while(start < toLeft && toRight < end) { //서로 중간부터 벌어지면서 끝 범위를 벗어나기 전까지만 반복

            //midHight에 작은 값을 넣는 이유 : 직사각형 넓이는 작은 높이가 높이 값이 됨.
            if(histogram[toLeft - 1] < histogram[toRight + 1]) { //중간 지점을 기준으로 벌어지는데 오른쪽의 값이 더 클경우
                toRight++;
                midHeight = Math.min(midHeight, histogram[toRight]);
            }
            else { //중간 지점을 기준으로 벌어지는데 왼쪽 값이 더 클 경우
                toLeft--;
                midHeight = Math.min(midHeight, histogram[toLeft]);
            }

            // 최대 넓이 갱신 (움직인 만큼의 각 막대기의 움직인 거리만큼 * 높이)
            maxArea = Math.max(maxArea, midHeight * (toRight - toLeft + 1));
        }

        // 오른쪽 부분을 끝까지 탐색 못했다면 마저 탐색
        while(toRight < end) {
            toRight++;
            midHeight = Math.min(midHeight, histogram[toRight]);
            maxArea = Math.max(maxArea, midHeight * (toRight - toLeft + 1));
        }

        // 왼쪽 부분을 끝까지 탐색 못했다면 마저 탐색
        while(start < toLeft) {
            toLeft--;
            midHeight = Math.min(midHeight, histogram[toLeft]);
            maxArea = Math.max(maxArea, midHeight * (toRight - toLeft + 1));
        }

        return maxArea;
    }
}