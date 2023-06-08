import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //입력받을 영단어 수
        int M = Integer.parseInt(st.nextToken()); //출력할 단어의 길이

        String[] words = new String[N]; //영단어 저장할 배열

        for(int i = 0; i < N; i++){
            words[i] = br.readLine();
        }

        br.close();

        List<String> result = findSolution(words);

        for(int i = 0; i < result.size(); i++){
            if(result.get(i).length() < M) continue;
            bw.write(result.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }

    //조건 1~3을 처리해서 배열을 반환시키는 메소드
    static List<String> findSolution(String[] array){
        Map<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < array.length ; i++) {
            //이미 Map에 있는 건 같은 값을 한번더 마주한 것
            if (mp.containsKey(array[i])) {
                // 해당 array[i]을 key 값으로 가지고, 그 key 값의 value(지금까지의 빈도수) + 1
                mp.put(array[i], mp.get(array[i]) + 1);
            } else {// 한 번도 마주한 적이 없는 숫자일 경우
                // 해당 array[i]을 key 값으로 가지고, 빈도수는 당연히 1이므로 value는 1 값을 가짐
                mp.put(array[i], 1);
            }
        }

        //키 값이 영단어인데 해당 영단어만 뽑아서 리스트로 만듬
        List<String> wordList = mp.keySet().stream().collect(Collectors.toList());

        wordList.sort((o1, o2) -> {
            int s1 = mp.get(o1); //빈도수
            int s2 = mp.get(o2); //빈도수

            if(s1 == s2){ //빈도수가 같으면
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2); //3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치
                }
                return o2.length()-o1.length(); //2. 해당 단어의 길이가 길 수록 앞에 배치
            }
            return s2-s1; //1. 자주 나오는 단어일 수록 앞에 배치
        });

        return wordList;
    }

}