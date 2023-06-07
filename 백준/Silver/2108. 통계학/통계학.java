import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N]; //N개의 숫자를 저장하는 배열

        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        bw.write(findAvg(numbers) + "\n"); //산술 평균
        bw.write(findMiddle(numbers) + "\n"); //중앙 값
        bw.write(findFrequence(numbers) + "\n"); //최빈 값
        bw.write(findDiffer(numbers) + "\n"); //범위(최대와 최소의 차이) 값

        bw.flush();
        bw.close();
    }

    //산술 평균 구하는 메소드
    static int findAvg(int[] array){
        double sum = 0;
        int avg = 0;

        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }

        avg = (int)Math.round(sum/array.length);

        return avg;
    }

    //중앙 값 구하는 메소드
    static int findMiddle(int[] array){
        Arrays.sort(array);
        return array[array.length/2];
    }

    //최빈 값 구하는 메소드
    static int findFrequence(int[] array){
        Map<Integer, Integer> mp = new HashMap<>();

        if (array.length == 1) {
            return array[0];
        }
        for (int i = 0; i < array.length ; i++) {

            if (mp.containsKey(array[i])) {
                mp.put(array[i], mp.get(array[i]) + 1);
            } else {
                mp.put(array[i], 1);
            }
        }

        int maxValue = Collections.max(mp.values());

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> newMap : mp.entrySet()) {
            if (newMap.getValue() == maxValue) {
                arrayList.add(newMap.getKey());
            }
        }

        Collections.sort(arrayList);

        if (arrayList.size() > 1)
            return arrayList.get(1);
        else
            return arrayList.get(0);
    }

    //범위(최대값과 최솟값의 차이) 구하는 메소드
    static int findDiffer(int[] array){
        Arrays.sort(array);

        return Math.abs(array[array.length-1] - array[0]);
    }

}