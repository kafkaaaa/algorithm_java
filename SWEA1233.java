/**
 * SWEA 1233번(D4)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1233 {

    public static void main(String[] args) throws IOException {

        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc=1; tc<=10; tc++) {
            int isValid = 1;

            int N = Integer.parseInt(br.readLine());	// 1<=N<=200 정점의 개수

            for (int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());

                // 정점 번호 | 연산자or정수값 | 왼쪽 자식 번호 | 오른쪽 자식 번호
                st.nextToken();	// 정점 번호

                char tmp = st.nextToken().charAt(0);

                // case1 : 리프 노드인 경우 -> 연산자가 오면 안.
                if (!st.hasMoreTokens()) {
                    if (tmp == '+' || tmp == '-' || tmp == '*' || tmp == '/') {
                        isValid = 0;
                        // 남은 입력값 버리기
                        for (int x=i+1; x<=N; x++) br.readLine();
                        break;
                    }
                }
                // case2 : 리프 노드가 아닌 경우 -> 정수가 오면 안.
                else if (st.hasMoreTokens()) {
                    if (tmp >= '0' && tmp <= '9') {
                        isValid = 0;
                        // 남은 입력값 버리기
                        for (int x=i+1; x<=N; x++) br.readLine();
                        break;
                    }
                }
            }

            System.out.println("#" + tc + " " + isValid);
        }
    }
}
