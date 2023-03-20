import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[26]; //영문자가 26개

        for(int i = System.in.read(); i >= 'A'; i = System.in.read()){
            if(i > 'Z') //대문자 Z보다 크다는 것은 소문자라는 것
                array[i - 'a']++;
            else
                array[i - 'A']++; //Z보다 작다는 것은 대문자라는 것
        }
        
        int count = -1; //배열에 최솟값이 0이기 때문에 -1로 설정
        char result = '?'; // 가장 많았던 문자를 출력하거나 ?을 출력할때 결과 값

        for(int i = 0; i < array.length; i++){
            if(array[i] > count){ //해당 배열에 -97이나 -65을 해서 수를 넣어놨다.[빈도수]
                /*만약 count보다 크면 계속 해당 값은 count에 넣어서 갱신하는 식으로*/
                count = array[i];
                result = (char)(i+65); //대문자를 출력해야하기 때문에 다시 +65하면 됨
            }else if(array[i] == count){ //여기서 걸리는 경우는 빈도수가 똑같은 문자가 있다는 것
                result = '?'; //같은 값이 있으면 result를 '?'로 바꿔줌
            }
        }

        System.out.println(result);
    }

}