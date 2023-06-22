import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] queue; // 정수를 저장하는 큐

    /// 가장 앞에 있는 정수, 가장 뒤에 있는 정수의 인덱스를 저장하는 숫자, 큐 사이즈
    static int back, front, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 명령어의 개수

        queue = new int[N]; //큐 배열의 크기는 명령어의 수보다 같거나 작을 수 밖에 없다.
        back = 0;
        front = 0;
        size = 0;

        while(N --> 0){ //명령어의 개수(N)만큼 반복
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if(order.contains("front")){ //큐의 가장 앞에 있는 정수
                sb.append(front()).append("\n");
            }else if(order.contains("back")){ //큐의 가장 뒤에 있는 정수
                sb.append(back()).append("\n");
            }else if(order.contains("size")){ //큐에 들어있는 정수의 개수
                sb.append(size).append("\n");
            }else if(order.contains("empty")){ //큐가 비어있으면 1, 아니면 0을 출력
                sb.append(empty() ? 1 : 0).append("\n");
            }else if(order.contains("pop")){ //큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력
                //큐에 들어있는 정수가 없는 경우에는 -1을 출력
                sb.append(pop()).append("\n");
            }else if(order.contains("push")){ //정수 X를 큐에 넣는 연산
                int num = Integer.parseInt(st.nextToken());
                push(num);
            }
        }

        br.close();

        System.out.println(sb);
    }

    //push 명령어
    static void push(int num){
        queue[back] = num;
        back++; // 맨뒤의 요소의 인덱스값을 늘린다.
        size++; //사이즈 증가
    }

    //pop 명령어
    static int pop(){
        if(empty()){ //큐에 요소들이 없으면
            return -1;
        }

        int result = queue[front]; // 요소가 빠지면 0이되므로 미리 저장해두고

        queue[front] = 0; //맨 앞의 요소가 빠지는 것이므로 0으로 만들고
        front++; // 앞의 요소를 한칸 증가시킨다.
        size--; //사이즈 감소
        return result;
    }

    //empty 명령어
    static boolean empty(){
        //가장 뒤에 있는 요소의 인덱스가 가장 앞에 있는 인덱스보다 작게 되면 요소가 없다는 뜻
        if(size == 0){
            return true;
        }

        return false;
    }

    //front 명령어
    static int front(){
        if(empty()){
            return -1;
        }
        return queue[front];
    }

    //back 명령어
    static int back(){
        if(empty()){
            return -1;
        }
        return queue[back-1]; //맨뒤의 요소는 back-1을 해야한다.
        // back은 다음 요소가 추가될 인덱스이다.
    }
}