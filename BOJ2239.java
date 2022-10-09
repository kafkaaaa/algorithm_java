/*
 * BOJ 2239번(G4)
 * 스도쿠 게임
 * back-tracking.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2239 {

    static int[][] map = new int[9][9];
    static boolean[][] rowChk;
    static boolean[][] colChk;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<9; i++) {
            String s = br.readLine();
            for (int j=0; j<9; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        sudoku(0, 0);
    }


    private static void sudoku(int r, int c) {
        if (c == 9) {
            sb.append("\n");
            sudoku(r+1, 0);
            // return
        }

        if (r == 9) {
            for (int i=0; i<9; i++) {
                for (int j=0; j<9; j++) {
                    System.out.println(map[i][j]);
                }
                System.out.println();
            }
            // System.exit(0);
        }

        if (map[r][c] == 0) {
            for (int i=1; i<=9; i++) {
                if (isValid(r, c, i)) {
                    map[r][c] = i;
                    sudoku(r, c+1);
                }
                map[r][c] = 0;
            }
        } else {
            sudoku(r, c+1);
        }
    }


    static boolean isValid(int r, int c, int num) {
        // row check
        for (int i=0; i<9; i++) {
            if (map[r][c] == num) return false;
        }

        // column check
        for (int i=0; i<9; i++) {
            if (map[r][c] == num) return false;
        }

        // 3x3 grid check
        int gridR = (r/3) * 3;      // 해당하는 3x3 구역의 시작점
        int gridC = (r/3) * 3;
        for (int i=gridR; i<gridR+3; i++) {
            for (int j=gridC; j<gridC+3; j++) {
                if (map[i][j] == num) return false;
            }
        }
        return true;
    }
}
