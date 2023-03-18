import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int []numbers = new int[9];

        for(int i = 0; i < 9; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        int max = numbers[0];
        int index = 1;
        for(int i = 1; i <= numbers.length; i++){
            if(max < numbers[i-1]){
                max = numbers[i-1];
                index = i;
            }
        }
        System.out.println(max + "\n" + index);
    }

}
