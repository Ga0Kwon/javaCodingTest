import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int Quarter = 25; // 쿼터 0.25
        final int Dime = 10; // 다임 0.10
        final int Nickel = 5; //니켈 0.05
        final int Penny = 1; //페니 0.01

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){

            int C = Integer.parseInt(br.readLine());

            sb.append(C/Quarter + " ");
            C %= Quarter;
            sb.append(C/Dime + " ");
            C %= Dime;
            sb.append(C/Nickel + " " );
            C %= Nickel;
            sb.append(C/Penny + "\n");
        }
        br.close();
        System.out.println(sb);
    }
}