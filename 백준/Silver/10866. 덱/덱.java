import java.io.*;
import java.util.*;

public class Main {

    static ArrayDeque<Integer> queue = new ArrayDeque<>(); //큐(덱)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); //명령어의 수(N)

        while(N --> 0){ //명령어의 수만큼 명령어를 입력받는다.(한줄에 하나씩)
            String str = br.readLine(); //명령어(한줄에 하나)

            if(str.contains("push")){ //명령어에 push가 들어가는 경우는 StringTokenizer로 쪼개야 함
                StringTokenizer st = new StringTokenizer(str);

                if(st.nextToken().contains("front")){//push -> front 명령어
                    push_front(Integer.parseInt(st.nextToken()));
                }else if(str.contains("back")){ //push -> back 명령어
                    push_back(Integer.parseInt(st.nextToken()));
                }
            }else if(str.contains("pop")){ //pop 관련 명령어
                if(str.contains("front")){//pop -> front 명령어
                    sb.append(pop_front()).append("\n");
                }else if(str.contains("back")){ //pop -> back 명령어
                    sb.append(pop_back()).append("\n");
                }
            }else if(str.contains("size")){ //size 명령어
                sb.append(size()).append("\n");
            }else if(str.contains("empty")){ //empty 명령어
                sb.append(empty()).append("\n");
            }else if(str.contains("front")){ //front 명령어
                sb.append(front()).append("\n");
            }else if(str.contains("back")){ //back 명령어
                sb.append(back()).append("\n");
            }
        }
        br.close();
        System.out.println(sb);
    }

    //push_front 명령어
    static void push_front(int X){
        queue.addFirst(X); //맨 앞에 해당 숫자 추가
    }
    //push_back 명령어
    static void push_back(int X){
        queue.addLast(X); //맨 뒤에 해당 숫자 추가
    }
    //pop_front 명령어
    static int pop_front(){
        if(empty() == 1){
            return -1;
        }
        return queue.pollFirst(); //가장 앞 인덱스 요소 뽑기
    }
    //pop_back 명령어
    static int pop_back(){
        if(empty() == 1){
            return -1;
        }
        return queue.pollLast(); //마지막 인덱스 요소 뽑기
    }
    //size 명령어
    static int size(){
        return queue.size();
    }
    //empty 명령어
    static int empty(){
        return (queue.size() <= 0) ? 1 : 0;
    }
    //front 명령어
    static int front(){
        if(empty() == 1){//비어있는 경우 -1 출력
            return -1;
        }
        return queue.peekFirst();
    }
    //back 명령어
    static int back(){
        if(empty() == 1){ //비어있는 경우 -1 출력
            return -1;
        }
        return queue.peekLast();
    }
}