import javafx.scene.layout.CornerRadii;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;

        ArrayList<Coordinate> coorList = new ArrayList<Coordinate>(); 

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coorList.add(new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        br.close();

        Collections.sort(coorList); 

        for(int i = 0; i < N; i++){
            bw.write(coorList.get(i).toString());
        }

        bw.flush();
        bw.close();
    }
}

class Coordinate implements Comparable<Coordinate>{
    int x ; //x 좌표
    int y; //y 좌표

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coordinate o) { 
        if (this.y != o.y) return this.y - o.y; 
        else return this.x - o.x; 
    }

    public String toString() {
        return x + " " + y + "\n";
    }
}