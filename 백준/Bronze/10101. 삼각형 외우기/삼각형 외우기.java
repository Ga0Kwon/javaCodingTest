import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int angle[] = new int[3]; //각도를 저장하는 배열
        int wholeangle = 0;

        for(int i = 0; i < 3; i++){
            angle[i] = Integer.parseInt(br.readLine());
            wholeangle += angle[i];
        }
        br.close();

        if(wholeangle != 180){
            bw.write("Error");
        }else{
            int[] distinct = removeDuplicate(angle);

            if(distinct.length == 1){
                bw.write("Equilateral");
            }else if(distinct.length == 2){
                bw.write("Isosceles");
            }else if(distinct.length == 3){
                bw.write("Scalene");
            }
        }

        bw.flush();
        bw.close();

    }

    public static int[] removeDuplicate(int[] arr) {
        //받은 배열을 크기만큼 반복문을 돌림(forEach) = Stream()
        // distinct() 메소드는 스트림에서 중복되는 요소들을 모두 제거해주고 새로운 스트림을 반환
        //  List 컨테이너의 인스턴스를 배열(array)로 만드는것이 'toArray' 메서드
        return Arrays.stream(arr).distinct().toArray();
    }
}