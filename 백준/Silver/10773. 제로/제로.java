import java.io.*;

public class Main {
    static int size = 0; //현재 인덱스가 어디까지 찼는지 알려주는 지표
    static int[] stack;//ArrayList을 사용하지 않고 기본 배열을 사용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine()); //명령어의 수
        int result = 0; //스택에 있는 모든 수를 더해 저장하는 변수
        stack = new int[K];//정수를 담는 배열(스택)

        for(int i = 0; i < K; i++){
            int num = Integer.parseInt(br.readLine()); //처리할 정수

            if(empty() == 1 && num == 0){ //만약 스택이 비어있는데 0을 입력받았다면 0을 추가
                push(num); //0인 경우는 더해도 기존 값과 같음
            }else if(num == 0){ //비어있지 않고 0일 경우(취소)
                result -= pop(); // 삭제한 경우는 빼주면 되고(스택; 모든 수를 받아 적은 후 그 수의 합을 알기 위해)
            }else{ //나머지 정수는 그냥 추가
                result += push(num); // 추가한 경우는 더해주면 됨(스택; 모든 수를 받아 적은 후 그 수의 합을 알기 위해)
            }
        }

        br.close();

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    //push 명령어
    static int push(int num){
        stack[size] = num; //요소 추가
        size++; //요소를 추가했으니 다음 추가될 인덱스를 추가함
        return num;
    }

    //pop 명령어
    static int pop(){

        int popNum = top(); //삭제할 정수를 미리 저장(삭제되면 없어지니까)
        stack[stack.length-1] = 0; //최근에 추가한 것을 삭제한다.
        size--; //삭제했으니 size를 줄인다.

        return popNum;
    }


    //empty 명령어
    static int empty(){
        if(stack.length <= 0){ //비어있으면
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
        return stack[size-1]; //맨 위에 있는 정수 출력
    }

}