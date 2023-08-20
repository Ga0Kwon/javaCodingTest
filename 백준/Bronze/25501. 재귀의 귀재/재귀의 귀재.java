import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            isPalindrome(br.readLine());
        }

        br.close();
        System.out.println(sb);
    }

    //재귀 함수 호출하는 부분 + 반환된 값 입력하는 부분
    static void isPalindrome(String str){
        int[] result = recursion(str, 0, str.length()-1, 0);
        sb.append(result[0]).append(" ").append(result[1] + "\n");
    }

    //팰린드롬인지 판별하는 메소드 (파라티머 : 문자열, 재귀 수행 횟수)
    static int[] recursion(String str, int fp, int ep, int count){
        count++; //함수를 돌때마다 재귀 수행 횟수 +1해줘야하므로 증가시킴
        //앞 부분 매칭 값의 위치가 끝 부분 매칭 값의 위치보다 크거나 같은 경우는 이미 다 체크했고 걸리는 부분이 없었다는 것이므로
        // => 1과 재귀 횟수 반환
        if(fp >= ep){
            return new int[]{1, count};
        }
        //매칭되는 값이 서로 다르면 더이상 수행 X => 0, 재귀 횟수 반환
        else if(str.charAt(fp) != str.charAt(ep)){ 
            return new int[]{0, count};
        }
        // 앞 매칭 값이 끝 매칭 값의 위치보다 작은데 또 해당 매칭 값이 같다면
        // 아직 체크해야하는 부분이 존재하는 것이므로 재귀 함수 호춝
        else{
            return recursion(str, fp+1, ep-1, count);
        }
    }

}
        