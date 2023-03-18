import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        int N = Integer.parseInt(br.readLine()) ;
        int []numbers = new int[N];

        token  = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(token.nextToken());
        }
        br.close();

        System.out.println(findMin(numbers) + " " + findMax(numbers));
    }
    
    /*최댓값 구하는*/
    static int findMax(int[] arrays){
        int max = arrays[0];
        for(int i = 0; i < arrays.length; i++){
            if(max < arrays[i]){
                max = arrays[i];
            }
        }
        return max;
    }
    /*최솟값을 구하는*/
    static int findMin(int[] arrays){
        int min = arrays[0];
        for(int i = 0; i < arrays.length; i++){
            if(min > arrays[i]){
                min = arrays[i];
            }
        }
        return min;
    }

}
