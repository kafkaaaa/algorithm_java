/**
 * BOJ 3040번(B2)
 * 조합.
 */
import java.util.Scanner;

public class BOJ3040 {

    static int[] arr, real;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        arr = new int[9];    // 아홉 난쟁이
        real = new int[7];   // 진짜 일곱 난쟁이
        for (int i=0; i<9; i++) {
            arr[i] = scan.nextInt();
        }
        comb(0, 0);
    }

    // 9C7 = 100이 되는 경우를 찾자.
    private static void comb(int start, int cnt) {
        if (cnt == 7) {
            int sum = 0;    // 일곱 난쟁이의 수 합
            for (int e : real) sum += e;
            if (sum == 100) {
                for (int e : real) System.out.println(e);
            }
            return;
        }

        for (int i=start; i<9; i++) {
            real[cnt] = arr[i];
            comb(i+1, cnt+1);
        }
    }
}
