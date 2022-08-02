
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
        // nextLine() : \n 개행문자 까지 읽고, 개행문자를 버린 뒤 나머지 문자열을 가져옴.
        // next() : 공백문자 이전 까지 읽어옴. (앞의 개행문자는 무시)
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
