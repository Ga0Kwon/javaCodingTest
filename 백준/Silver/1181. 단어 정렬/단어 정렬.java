import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] array = new String[N]; 


        for(int i = 0; i < N; i++) {
            array[i] =br.readLine();
        }
        
        br.close();
        
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) { 
                if(str1.length() == str2.length()){ 
                    return str1.compareTo(str2); 
                }else{ 
                    return str1.length() - str2.length(); 
                }
            }
        });

        bw.write(array[0] + "\n"); 

        for(int i = 1; i < N; i++){
            if(!array[i].equals(array[i-1])){ 
                bw.write(array[i] + "\n"); 
            }
        }

        
        bw.flush();
        bw.close();
    }
}
