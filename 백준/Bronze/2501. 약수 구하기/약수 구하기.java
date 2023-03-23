import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        br.close();
        
        int [] arrays = new int[N];

        for(int i = 1; i <= N; i++){
            if(N%i == 0){
                arrays[i-1] = i;
            }else{ //약수가 아닐 경우
                arrays[i-1] = -1; //약수 중 -1은 나올 수 없어서 임의로 -1
            }
        }

        int count = 0;

        for(int i = 1; i <= N; i++){
            if(arrays[i-1] != -1){
                count++;
                if(count == K){
                    System.out.println(i);
                    break;
                }
            }
        }

        if(count != 0 && count != K){
            System.out.println(0); //찾지 못했을 경우
        }

    }

}