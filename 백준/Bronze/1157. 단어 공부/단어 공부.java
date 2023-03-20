import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  Exception{

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
            if(array[i] > count){ 

                count = array[i];
                result = (char)(i+65);
            }else if(array[i] == count){ 
                result = '?'; 
            }
        }

        System.out.println(result);
    }

}