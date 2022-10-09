/**
 * 순열 중복순열 조합 중복조합
 * https://url.kr/qgel4o
 */
public class Permutation {

    static int[] source = {1, 2, 3, 4};
    static int r = source.length;
    static int[] result = new int[r];
    static boolean[] visit = new boolean[r];
    static int cnt = 0;

    public static void main(String[] args) {
        System.out.println("=====순열=====");
        permutation(0, r);                  // 4P3
        System.out.println(cnt);

        System.out.println("=====중복순열=====");
        permutation_rep(0, r);              // 4ㅠ3
        System.out.println(cnt);

        System.out.println("=====조합=====");
        combination(0, r-1, 0);     // 4C3
        System.out.println(cnt);

        System.out.println("=====중복조합=====");
        combination_rep(0, r-1, 0); // 4H3
        System.out.println(cnt);
    }

    // 순열 nPr = n! / (n-r)!
    private static void permutation(int depth, int r) {
        if (depth == r) {
            for (int i=0; i<r; i++) System.out.print(result[i]);
            System.out.println();
            cnt++;
            return;
        }

        for (int i=0; i<source.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = source[i];
                permutation(depth+1, r);
                visit[i] = false;
            }
        }
    }

    // 중복순열 nㅠr = n^r
    private static void permutation_rep(int depth, int r) {
        if (depth == r) {
            for (int i=0; i<r; i++) System.out.print(result[i]);
            System.out.println();
            cnt++;
            return;
        }

        for (int i=0; i<source.length; i++) {
            result[depth] = source[i];
            permutation_rep(depth+1, r);
        }
    }

    // 조합 nCr = n! / (n-r)! r!
        // 현재 선택한 원소보다 뒤에 있는 원소에 대해서만 탐색을 하기 위해
        // 탐색의 시작 index를 의미하는 start를 사용
        // result배열 사용X -> 선택된 원소를 따로 저장하지 않고,
        // visit 체크가 되어있는 원소만 출력
    private static void combination(int depth, int r, int start) {
        if (depth == r) {
            for (int i=0; i<source.length; i++) {
                if (visit[i]) System.out.print(source[i]);
            }
            System.out.println();
            cnt++;
            return;
        }

        for (int i=start; i<source.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combination(depth+1, r, i+1);
                visit[i] = false;
            }
        }
    }

    // 중복조합 nHr = n+r-1Cr
        // 조합 선택 시 start+1 부터 하는 부분을 -> 그냥 start부터 선택하는 걸로 바꾸면 끝
        // 중복이 가능하기 때문에 -> 결과 배열 필요.
    private static void combination_rep(int depth, int r, int start) {
        if (depth == r) {
            for (int i=0; i<r; i++) System.out.print(result[i]);
            System.out.println();
            cnt++;
            return;
        }

        for (int i=start; i<source.length; i++) {
            result[depth] = source[i];
            combination_rep(depth+1, r, i);
        }
    }

}
