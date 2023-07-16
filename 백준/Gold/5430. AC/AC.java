import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb =  new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수

        while(T --> 0){ //테스트 케이스 만큼 반복
            //테스크 한번씩마다 초기값 -> 결과값 만드는 대상 큐 선언
            ArrayDeque<Integer> deque =  new ArrayDeque<>(); //반복할 때마다 초기화
            String p = br.readLine(); //수행 함수(문자열 통째로 저장)
            int n = Integer.parseInt(br.readLine()); //배열에 들어있는 수의 개수

            //구분해야 할 문자 : 여는 대괄호('['), 닫는 대괄호(']'), 반점(',')
            //StringTokenizer은 split()과 달리 정규식 검사가 아니기 때문에 아래와 같이 한꺼번에 넘겨주면 된다.
            st = new StringTokenizer(br.readLine(), "[],");

            //spilt()으로 구분하고자 한다면 아래와 같이 구분할 수 있다.
            /*
               String str = "[1,2,3,4]"
               String[] strArr = str.subString(1, s.length - 1); => strArr = 1,2,3,4가 될 것이다.
               String[] realStrArr = strArr.split(",");
               => split('분할하고하는 문자') : 현재 위치에서 분할하고자 하는 문자와 매칭될 문자가 존재할 경우 선행 문자열과 분리된다.
             */
            for(int i = 0; i < n; i++){
                deque.add(Integer.parseInt(st.nextToken()));
            }
            solution(p, deque);
        }
        br.close();

        System.out.println(sb);
    }

    static void solution(String p, ArrayDeque<Integer> deque){
        //함수 R을 쓸때 자리를 하나씩 바꾸지 않고 그냥 시작 위치만 바꾼다 : 시간 효율성을 위해!
        //direction = true이면 왼쪽부터 차례대로
        //direction = false이면 오른쪽부터 차례대로(역순)
        boolean direction = true; // 시작위치를 담는 변수

        //함수들이 붙어서 RDDRD이런식으로 붙어 있기 때문에 문자하나씩 뽑아 수행한다.(함수 모두 수행)
        for(char order : p.toCharArray()){
            if(order == 'R'){ //R(뒤집기)일 경우
                direction = !direction;
                continue; //다음 반복문으로
            }

            // 아래부터는 D(버리기)일 경우

            if(direction){ //민약 D(버리기)이면서 direction가 True일 경우

                //반환될 원소가 없을 경우 error를 출력하도록 하고 함수 종료한다.
                if(deque.pollFirst() == null){
                    sb.append("error\n");
                    return;
                }

            }else{ //민약 D(버리기)이면서 direction가 False일 경우
                //반환될 원소가 없을 경우 error를 출력하도록 하고 함수 종료한다.
                if(deque.pollLast() == null){
                    sb.append("error\n");
                    return;
                }
            }
        }
        printResult(deque, direction); //함수 모두 수행하고 나머지 결과값 출력하는 메소드 호출
    }

    //결과 값을 출력하는 메소드
    static void printResult(ArrayDeque<Integer> deque, boolean direction){
        sb.append('['); //왼쪽 여는 괄호부터 시작해야함(출력 값)

        if(deque.size() > 0){ //덱의 사이즈가 0보다 클 경우까지만 반복
            if(direction){ //왼쪽부터(정방향)
                sb.append(deque.pollFirst()); //첫번째 원소를 가장 먼저 넣고

                //그 다음 원소가 비어있지 않으면 반점을 추가한다.
                while(!deque.isEmpty()){ //비어질 때까지 반복
                    sb.append(',').append(deque.pollFirst());
                }

            }else{ //오른쪽부터(역방향)
                sb.append(deque.pollLast()); //첫번째 원소를 가장 먼저 넣고

                //그 다음 원소가 비어있지 않으면 반점을 추가한다.
                while(!deque.isEmpty()){ //비어질 때까지 반복
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append(']').append('\n'); //마지막 닫는 괄호랑 줄바꿈 추가
    }

}
        