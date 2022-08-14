/**
 * SWEA 6808번(D3)
 * 순열
 */
import java.util.Scanner;

public class SWEA6808 {

    static int a[];					// 규영이가 내는 카드
    static int b[];					// 인영이가 내는 카드
    static boolean isSelected[];	// 규영이가 선택한 카드이면 true
    static int result[];			// 인영이의 카드 순열
    static boolean isVisited[];
    static int winCnt, loseCnt;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int tc=1; tc<=T; tc++) {
            // init
            a = new int[9];
            b = new int[9];
            isSelected = new boolean[19];
            result = new int[9];
            isVisited = new boolean[9];
            winCnt = loseCnt = 0;
            // end init
            for (int i=0; i<9; i++) {
                int input = scan.nextInt();
                a[i] = input;
                isSelected[input] = true;
            }

            // 규영이가 뽑지 않은 나머지 카드는 인영이의 카드가 됨
            for (int i=1, idx=0; i<=18; i++) {
                if (isSelected[i] == false) {
                    b[idx++] = i;
                }
            }
            Permutation(0);
            System.out.println("#" + tc + " " + winCnt + " " + loseCnt);
        }
    }


    // 9개의 숫자를 순열
    static void Permutation(int cnt) {
        if (cnt == 9) {
            int sumA = 0;		// 규영이의 점수 합
            int sumB = 0;		// 인영이의 점수 합
            for (int i=0; i<9; i++) {
                if (a[i] > result[i])	// 규영이의 숫자가 더 높으면
                    sumA += (a[i] + result[i]);
                else					// 인영이의 숫자가 더 높으면
                    sumB += (a[i] + result[i]);
            }
            if (sumA > sumB) winCnt++;
            else loseCnt++;
            return;
        }

        for (int i=0; i<9; i++) {
            if (isVisited[i] == false) {
                isVisited[i] = true;
                result[cnt] = b[i];
                Permutation(cnt+1);
                isVisited[i] = false;
            }
        }
    }

}
