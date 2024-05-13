import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String problem = br.readLine();

        br.close();

        // 1.  결과 값이 최솟 값이 나오기 위해선 큰 값으로 빼야 한다.
        // 1-1. 큰 값을 만들기 위해 더하기를 진행한다.
        // 1-2. 일단, 빼기는 나중에 하므로 빼기를 기준으로 나눠서 더하기 붙어있는 기준으로 더한다.
        String[] splitMinusProblem = problem.split("-");

        int result = Integer.MAX_VALUE; //최종 값을 저장하는 변수

        // 2. 빼기(-)를 기준으로 식을 분리했으니 분리된 상태에서 각각 더하기를 진행한다.
        for(int i = 0; i < splitMinusProblem.length; i++){
            int sum = 0;

            // 2-1. 더하기 위해 숫자를 더하기(+)를 기준으로 분리한다.
            String[] splitPlusProblem = splitMinusProblem[i].split("\\+"); // +는 특정 의미를 가지고 있어 백슬래시(\\)해야 작동함

            // 2-2. 빼기로 분리한 식별 더하기를 수행한다.
            for(int j = 0; j < splitPlusProblem.length; j++){
                sum += Integer.parseInt(splitPlusProblem[j]); //더하기 누적
            }

            // 2-3. 모두 더했다면 최종 값에 누적으로 빼줘야한다.
            if(result == Integer.MAX_VALUE){ //처음 값이면 빼는 게 아니라 그대로의 값이 들어감
                result = sum;
            }else{ //처음 값이 아닌 경우 누적으로 빼준다.
                result -= sum;
            }

        }

        System.out.println(result);

    }
}