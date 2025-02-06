import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); //연산 개수
        //절댓값이 최소인 값을 먼저 추출한다.
        PriorityQueue<Integer> Queue = new PriorityQueue <>(new compareAbsNum());

        while(N --> 0){
            int x = Integer.parseInt(br.readLine()); //연산
            if(x == 0){ //0이면 가장 작은 값을 출력하고 배열에서 제거
                if(Queue.isEmpty()){ //배열이 비어있으면 0을 출력
                    sb.append(0).append("\n");
                }else{ //배열이 안비어있으면
                    sb.append(Queue.poll()).append("\n");
                }
            }else{ //0이 아니고, 자연수라면 배열에 x를 추가
                Queue.add(x);
            }
        }
        br.close();
        System.out.println(sb);
    }

    //절댓값의 크기를 비교하는 클래스 
    public static class compareAbsNum implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2){
            if(Math.abs(o1) > Math.abs(o2)){
                return 1;
            }else if(Math.abs(o1) < Math.abs(o2)){
                return -1;
            }else{
                if(o1 >= o2){
                    return 1;
                }else{
                    return -1;
                }
            }
        }
    }
}