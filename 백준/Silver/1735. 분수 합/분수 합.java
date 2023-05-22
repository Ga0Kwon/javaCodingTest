import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] aArray = new int[2]; 
        int[] bArray = new int[2]; 

        for(int i = 0; i < 2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            aArray[i] = Integer.parseInt(st.nextToken());
            bArray[i] = Integer.parseInt(st.nextToken());
        }
        
        int commonB = bArray[0] * bArray[1] / findGCD(bArray[0], bArray[1]);
        
        int addA = aArray[0]*(commonB/bArray[0]) + aArray[1]*(commonB/bArray[1]);

        int abbreviation = findGCD(commonB, addA);

        if(abbreviation != 1){ 
            commonB = commonB/abbreviation;
            addA = addA/abbreviation;
        }

        bw.write(addA + " " +  commonB);

        br.close();
        bw.flush();
        bw.close();
    }
    
    static int findGCD(int b1, int b2){
        while(b2 != 0){
            int R = b1%b2;
            b1 = b2;
            b2 = R;
        }
        return b1;
    }
}