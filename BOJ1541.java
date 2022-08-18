/**
 * BOJ 1541번(S2)
 * 수학. 문자열 분리.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1541 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 처음 입력된 수식은 -를 기준으로 나눈다
        String[] input = br.readLine().split("-");
        int result = 0;

        // 처음 -가 나오기 이전의 수들은 모두 더해준다
        String[] s1 = input[0].split("[+]");	// 특수문자는 [ ] 혹은  \\ 처리를 해야한다..
        // String[] s1 = first[0].split("\\+");
        for (String e : s1)
            result += Integer.parseInt(e);

        // 처음 -가 나오고 뒤에 나오는 숫자들은 모두 빼주면 최소값이 된다..
        for (int i=1; i<input.length; i++) {
            String[] s2 = input[i].split("\\+");
            for (String e : s2)
                result -= Integer.parseInt(e);
        }

        System.out.println(result);
    }

}
