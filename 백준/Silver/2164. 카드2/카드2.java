import java.io.*;

public class Main {

    static int[] queue; // 정수를 저장하는 큐
    static int front, back;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 명령어의 개수

        //크기를 N*2를 한 이유는 배열을 옮길 때 크기를 N으로 지정했을 경우,
        // 자리를 모두 바꿔야하는 경우가 생긴다.
        // 하지만, 크기를 2배로 늘리면 그럴 수고가 없어 진다.
        // index는 1부터 시작할 것이므로 (0을 제외) 따라서 2*N -1가 아니라 2*N을 사용할 것이다.
        queue = new int[N*2]; //정수 1~N개 만큼 저장하는 큐 배열 초기화

        front = 1; //맨 앞의 요소 인덱스 1(0부터 시작하지 않고 1부터 시작하기 때문에)
        back = N; //맨 뒤의 요소 인덱스 N

        // 1이 제일 위에 가고 N이 제일 아래 가도록 카드를 놓는 것이기 때문에 1~N까지 반복
        for(int i = 1; i <= N; i++) {//배열 N부터 1까지 채워넣기
            queue[i] = i;
        }

        br.close();

        solution(N); //답을 구하는 솔루션 메소드
        
        System.out.println(queue[front]);
    }

    static void solution(int N){
        while(N-- > 1) { //인덱스를 1부터 지정했기 때문에 N이 1이 될때까지 반복한다.(인덱스 시작이 1이다)

            //(1) 제일 위에 있는 요소를 버리고, 제일 위에 있는 카드를 밑으로 옮기는 작업
            front++;
            queue[back + 1] = queue[front];

            //(2) 기존 인덱스 값을 모두 바꾼 것이 아니기 때문에 back+1에 현재 제일 위에 있던 카드를 밑으로 저장했기 때문에
            // back도 증가시켜준다.
            back++;

            //(3) 제일 위에 있는 요소를 버렸기 때문에 front값도 증가시켜준다.
            // 2번 증가시키는 이유는 제일 위에 있는 요소를 먼저 버리고 나서의 또 제일 위에 있는 카드를 가장 밑으로 옮기기 때문
            front++;
        }
    }
}