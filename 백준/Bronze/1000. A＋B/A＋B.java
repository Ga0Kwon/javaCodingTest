import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException { //IOException : 입출력 예외처리
        /*System.in을 이용해 값을 입력받을 때, 잘못된 값을 입력받은 경우를 대비해 항상 예외 처리를 해줘야 한다.*/
        /* 0은 아스키코드로 48이다. 즉 입력받은 아스키코드에서 -48을 햐주면 입력받은 숫자가 된다. */
        int a =  System.in.read() - 48 ; //아스키 코드값이 입력된다. [키보드의 모든 자판에는 아스키코드가 지정]

        System.in.read(); // System.read.in() 값 입력 후에 '\n'(엔터)가 남아있어서 아래 b입력이 종료된다는 것! 한번더 써줘야한다.

        int b = System.in.read() - 48 ;

        System.out.println(a+b);

    }
}
