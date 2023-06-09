import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> stack = new ArrayList<>(); //정수를 담는 배열(스택)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); //명령어의 수

        for(int i  = 0; i < N; i++){
            String str = br.readLine();

            if(str.contains(" ")){ //push인 경우만 공백이 존재해서 StringTokenizer 사용
                StringTokenizer st = new StringTokenizer(str);

                if(st.nextToken().equals("push")) { //push 명령어
                    push(Integer.parseInt(st.nextToken())); //push는 따로 출력할게 없음
                }
            }

           if(str.equals("pop")){ //pop 명령어
               bw.write(pop() + "\n");
           }else if(str.equals("size")){ //size 명령어
               bw.write(size() + "\n");
           }else if(str.equals("empty")){ //empty 명령어
               bw.write(empty() + "\n");
           }else if(str.equals("top")){ //top 명령어
               bw.write(top() + "\n");
           }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    //push 명령어
    static void push(int num){
        stack.add(num); //요소 추가
    }

    //pop 명령어
    static int pop(){
        if(empty() == 1){ //스택이 비어있으면
            return -1; //정수가 없는 경우
        }

        //pop을 할때 가장 최근에 추가한 것을 뺀다
        int popNum = top(); //삭제되면 사라지니까 미리 변수에 저장한다.

        stack.remove(stack.size()-1); //최근에 추가한 것을 삭제한다.

        return popNum;
    }

    //size 명령어
    static int size(){
        return stack.size();
    }

    //empty 명령어
    static int empty(){
        if(stack.size() <= 0){ //비어있으면
            return 1;
        }
        return 0; //비어있지 않으면
    }

    //top 명령어
    static int top(){
        if(empty() == 1){ //스택이 비어있으면 -1 출력
            return -1;
        }

        // stack(스택)은 FIFO구조로 새로운 요소는 TOP으로 쌓이는데
        // 가장 위에 있는 것이 최근에 추가한 요소인 것이다.
        // (즉 ArrayList의 마지막 인덱스에 있는 것이 최근 것!)
        return stack.get(stack.size()-1); //맨 위에 있는 정수 출력
    }

}