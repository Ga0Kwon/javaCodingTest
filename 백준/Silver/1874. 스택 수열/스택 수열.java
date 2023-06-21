import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); //입력받을 숫자이면서 스택의 크기

        int[] stack = new int[N];

        int index = 0; //가장 마지막에 있는 요소의 인덱스
        int start = 0; //입력받은 숫자의 누적 크기(입력받은 가장 큰 숫자가 저장됨) => 오름차순 판정 여부

        // N 번 반복
        while(N -- > 0) {
            int value = Integer.parseInt(br.readLine()); //입력받은 숫자(하나)

            if(value > start) { // 입력받은 값이 가장 큰 숫자가 입력받은 값보다 클 경우 (오른차순 판별)
                // start + 1부터 입력받은 value 까지 push를 한다.
                for(int i = start + 1; i <= value; i++) { //value만큼 넣는다. 요소들을
                    stack[index] = i;
                    index++;
                    sb.append('+').append('\n');
                }

                start = value;     // 다음 push 할 때 오름차순인지 알 수 있도록 변수 초기화

            } else if(stack[index - 1] != value) { // top에 있는 원소가 입력받은 값과 같지 않은 경우
                // 여기서 한번이라도 여기에 걸리면 여태까지 수행한 출력값도 무시하고 그냥 NO만 출력해야하므로
                // 버퍼를 쓰지 않고 println을 사용
                System.out.println("NO");
                System.exit(0);    // 찾을 수 없는 요소이므로 빠져나온다. (시스템 종료)
            }

            index--;

            sb.append('-').append('\n'); // 오름차순의 경우 마지막 입력받은 요소는 넣자마자 빼야하므로 pop(-)
        }

        br.close();

        System.out.println(sb);
    }

}