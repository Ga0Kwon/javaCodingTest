import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        ArrayList<Integer> angle = new ArrayList<>();

        angle.add(Integer.parseInt(br.readLine()));
        angle.add(Integer.parseInt(br.readLine()));
        angle.add(Integer.parseInt(br.readLine()));

        br.close();

        if((angle.get(0) + angle.get(1) + angle.get(2))== 180){ //세각이 180일 경우

            HashSet data = new HashSet(angle);

            if(data.size() == 1){
                bw.write("Equilateral");
            }else if(data.size() == 2){
                bw.write("Isosceles");
            }else if(data.size() == 3){
                bw.write("Scalene");
            }

        }else{ //세각이 180아닌 경우
            bw.write("Error");
        }
        bw.flush();
        bw.close();

    }
}