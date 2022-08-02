
/*
 * SWEA 1208번(D3) - Flatten
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class SWEA1208 {

    static int[] arr = new int[100];    // (가로길이 100) 각각의 높이 저장
    static int nDump;                    // 덤프(1평탄화 작업) 횟수

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            nDump = scan.nextInt();
            for (int i = 0; i < 100; i++) {
                arr[i] = scan.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < nDump; i++) {
                dump();
            }
            System.out.println("#" + tc + " " + (arr[99] - arr[0]));
        }
    }

    // (정렬 후) 최소높이에서+1, 최대높이에서-1
    static void dump() {
        arr[0]++;
        arr[99]--;
        Arrays.sort(arr);
    }
}
