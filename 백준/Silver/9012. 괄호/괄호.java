import java.io.*;

public class Main {
    static int size = 0; //현재 인덱스가 어디까지 찼는지 알려주는 지표
    static char[] stack; //각각의 테스트마다

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); //테스트 수

        // [시간 체크!!!]
        // 여기서, 괄호 문자열의 길이는 2 이상 50 이하인 조건 덕분에
        // 이중 for문을 돌려도 시간 제한 1초에 걸리지 않는다.
        // 즉, 시간은 그래도 생각을 덜해도 된다는 의미!
        // 이중 for문은 약 1만일때까진 1초가 나온다 50^2이라고 쳐도 2500이니까 이중 for문은 괜찮다!

        for(int i = 0; i < T; i++) {
            size = 0; // 테스트의 수만큼 찾는 인덱스용 변수를 초기화해야한다.

            String str = br.readLine(); // 하나의 괄호 문자열

            //문자열 하나당 stack이 필요할 것 같음.
            stack = new char[str.length()]; // 배열 초기화와 동시에 크기 지정

            //문자열의 크기만큼 구해야 한다.(문자열 -> 문지 배열로)
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {// ( [여는 괄호] : push()를 쓰고
                    push(str.charAt(j));
                } else { // ) [닫는 괄호] : pop()을 쓰면
                    if (size == 0) { //스택 사이즈가 0보다 작거나 같으면
                        //닫는 괄호가 많은 경우도 체크를 해줘야하기 때문에
                        //이 경우에도 괄호를 배열에 추가해야한다.
                        push(str.charAt(j));
                    } else { //스택 사이즈가 0보다 크면 하나 빼면 된다.
                        pop();
                    }
                }
            }

            //모든 괄호를 검사 완료했다면
            if (empty()) { //스택이 비어있다면 괄호가 모두 쌍을 이룬다는 것이므로
                bw.write("YES" + "\n");
            } else { //스택이 비어있지 않다면 괄호가 어느 하나 부족하다는 뜻이므로
                bw.write("NO" + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    //push 명령어(문자열 크기만큼)
    static void push(char ch){
        stack[size] = ch;
        size++;
    }

    //pop 명령어
    static void pop(){
        if(stack[size-1] == '('){ //전에 들어있는 괄호가 (일 경우만 삭제한다.
            stack[size] = '\0' ; //최근에 추가한 것을 삭제한다.
            size--; //삭제했으니 size를 줄인다.
        }
    }


    //empty 명령어
    static boolean empty(){
        if(size == 0){ //비어있으면
            return true;
        }
        return false; //비어있지 않으면
    }

    //top 명령어(가장 최근에 들어간 괄호 가져오기)
    static char top(){
        if(!empty()){ //스택이 비어있으면 -1 출력
            return '\0';
        }

        // stack(스택)은 FIFO구조로 새로운 요소는 TOP으로 쌓이는데
        // 가장 위에 있는 것이 최근에 추가한 요소인 것이다.
        return stack[size-1]; //맨 위에 있는 정수 출력
    }

}