
/*
 * BOJ 2563번(B1)
 */

import java.util.Scanner;

public class BOJ2563 {

    static int map[][];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();     // 색종이의 수
        map = new int[100][100];
        int cnt = 0;
        for (int i=0; i<N; i++) {
            int col = scan.nextInt();
            int row = scan.nextInt();
            for (int j=row; j<row+10; j++) {
                for (int k=col; k<col+10; k++) {
                    if (map[j][k] == 1) continue;
                    map[j][k] = 1;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
