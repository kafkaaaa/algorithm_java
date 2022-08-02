
/*
 * SWEA 1289번 - 원재의 메모리 복구하기
 *
 */

import java.util.Scanner;

public class SWEA1289 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = scan.nextInt();
        for (int tc=1; tc<=T; tc++) {
            char[] input = scan.next().toCharArray();
            char tmp = '0';
            int cnt = 0;

            for (char c : input) {
                if (tmp != c) {
                    tmp = c;
                    cnt++;
                }
            }
            sb.append("#" + tc + " " + cnt + "\n");
        }
        System.out.println(sb);
    }

}
