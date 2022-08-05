
/*
 * BOJ 12891번(S2) - DNA 비밀번호
 * 슬라이딩 윈도우 기법
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12891 {

    static int[] criteria = {0, 0, 0, 0};    // 부분 문자열에 포함되어야 할 {A, C, G, T}의 최소 개수
    static int[] cnt = {0, 0, 0, 0};        // 부분 문자열에 포함된 {A, C, G, T}의 개수
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String GATTACA = br.readLine();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            criteria[i] = Integer.parseInt(st.nextToken());
        }

        // 처음 검사 카운팅
        for (int i = 0; i < p; i++) {
            add(GATTACA.charAt(i));
        }
        if(isValid()) result++;

        // 한 칸씩 오른쪽으로 이동하면서 검사 (슬라이딩 윈도우)
        for (int i = 1; i <= s - p; i++) {
            int before = i - 1;
            int next = i + p - 1;
            remove(GATTACA.charAt(before));
            add(GATTACA.charAt(next));
            if(isValid()) result++;
        }

         System.out.println(result);
    }


    static void add(char c) {     // A,C,G,T가 포함된 개수 카운팅 (추가)
        switch (c) {
            case 'A' : cnt[0]++; break;
            case 'C' : cnt[1]++; break;
            case 'G' : cnt[2]++; break;
            case 'T' : cnt[3]++; break;
        }
    }

    static void remove(char c) {     // A,C,G,T가 포함된 개수 카운팅 (제외)
        switch (c) {
            case 'A' : cnt[0]--; break;
            case 'C' : cnt[1]--; break;
            case 'G' : cnt[2]--; break;
            case 'T' : cnt[3]--; break;
        }
    }

    static boolean isValid() {         // 유효한 비밀번호이면 ++
        for (int i=0; i<4; i++) {
            if (cnt[i] < criteria[i]) return false;
        }
        return true;
    }

}
