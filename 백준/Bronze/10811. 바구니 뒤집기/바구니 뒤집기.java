import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            [문제 해석]
            1 2 3 4 5 이 초기값이고, <<여기서 명심해야하는 건! 첫번째에선 12345가 순서지만 그 이후부턴 순서X>>
            입력받은 값 두개 중 하나는 i 하나는 j이다.
            ex) 첫번째 값으로 1 2로 받았다면,
            2 1 3 4 5 가 된다. 값과 순서는 이렇게 된다.[처음 돈거니까]
            ex) 두번째 값으로 3 4를 받았다면,
            2 1 4 3 5가 된다. 값은 2 1 4 3 5 이지만 순서는 1 2 4 3 5 로 볼 수 있다.
            ex) 세번째 값으로 1 4를 받았다면,
            3 4 1 2 5가 된다. 값은 3 4 1 2 5이지만 순서로 따지면 4 3 2 1 5 로 볼 수 있다.
            => 순서와 값이 혼동될 수 있는데 잘 구분하기!
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int [] cart = new int[N]; 

        for(int i = 0; i < cart.length; i++){
            cart[i] = i+1;
        }

        for(int d = 0; d < M; d++){
            token = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(token.nextToken())-1;
            int j = Integer.parseInt(token.nextToken())-1;
            
            while(i < j){ //시작 인덱스값이 끝 인덱스보다 커지면 반복문 멈춤
                int temp = cart[i];
                cart[i] = cart[j];
                cart[j] = temp;
                i++;
                j--;
            }
        }

        br.close();

        for(int i = 0; i < cart.length; i++){
            System.out.print(cart[i]+ " ");
        }

    }
}
