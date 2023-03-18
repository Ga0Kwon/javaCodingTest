import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int count = 0;
        int prev = ' ';

        while(true){
                int ch = System.in.read();
                if(ch == '\n') { //입력값이 줄바꿈이면
                    //이전 글자가 공백이 아니면
                    if (prev != ' ') count++;
                    break; //줄바꿈을 한거니까 while문을 나온다.
                }
                if(ch == ' '){ //입력값이 공백이면
                    if(prev != ' '){//이전 글자가 공백이 아니면
                        count++;
                    }
                }
                prev = ch; //pre를 이전 단어로 바꿔준다.
            }
        System.out.println(count);
        }

    }
