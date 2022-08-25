/**
 * BOJ 6603번(S2)
 * 조합. DFS.
 */

import java.util.Scanner;

public class BOJ6603 {

    static int n;                   // n개의 수 (6 < n < 13)
    static int[] num;               // 오름차순으로 입력되는 N개의 수를 저장.
    static boolean[] isSelected;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {
            n = scan.nextInt();
            if (n == 0) System.exit(0);
            num = new int[n];
            for (int i=0; i<n; i++) {
                num[i] = scan.nextInt();
            }
            isSelected = new boolean[n];
            Combination(0, 0);
            System.out.println();
        }
    }

    // n개의 수에서 6개를 선택하는 모든 경우의 수를 사전 순으로 출력.
    private static void Combination(int start, int cnt) {
        if (cnt == 6) {
            for (int i=0; i<n; i++) {
                if (isSelected[i] == true) {
                    System.out.print(num[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        // 재귀 호출
        for (int i=start; i<n; i++) {
            isSelected[i] = true;
            Combination(i+1, cnt+1);
            isSelected[i] = false;
        }
    }
}
