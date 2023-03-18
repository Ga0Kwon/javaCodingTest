import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] member = new int[30];

        for(int i = 0; i < 28; i++){
            member[Integer.parseInt(br.readLine())-1] = 1; //배열은 0부터 시작하기 때문에 인덱스값 -1
        }
        br.close();
        for(int i = 0; i < member.length; i++){
            if(member[i] == 0){
                System.out.println(i+1); //출석부는 1부터 시작하기 때문에 +1해서 출력한다.
            }
        }
    }
}
