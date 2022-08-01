
/*
 * 백준 1244번 - 스위치 켜고 끄기
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {

    static int nOfSwitch, nOfStudent;
    static int[] switches;
    static int[][] student;

    public static void main(String[] args) throws IOException {

        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        nOfSwitch = Integer.parseInt(br.readLine());
        switches = new int[nOfSwitch+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=nOfSwitch; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        nOfStudent = Integer.parseInt(br.readLine());
        student = new int[nOfStudent+1][2];
        for (int i=1; i<=nOfStudent; i++) {
            st = new StringTokenizer(br.readLine());
            student[i][0] = Integer.parseInt(st.nextToken());   // 남학생=1, 여학생=2
            student[i][1] = Integer.parseInt(st.nextToken());   // 학생이 받은 스위치 개수
        }

        // Switching
        for (int i=1; i<=nOfStudent; i++) {
            if (student[i][0] == 1) doMan(student[i][1]);
            else doWoman(student[i][1]);
        }

        // Output : 스위치 상태 - 한 줄에 (최대)20개 출력
        for (int i=1; i<=nOfSwitch; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) System.out.println();
        }


    }

    // 남학생 -> 받은 수의 배수인 스위치의 상태를 바꿈
    private static void doMan(int n) {
        for (int i=n; i<=nOfSwitch; i+=n) swap(i);
    }

    // 여학생 -> 받은 수를 중심으로 가장 큰 대칭을 이루는 구간전체를 바꿈
    private static void doWoman(int n) {

        int cnt = 0;
        while(true) {
            if (n-cnt>=1 && n+cnt<=nOfSwitch && switches[n-cnt] == switches[n+cnt]) {
                cnt++;
            }
            else break;
        }
        if (cnt == 0) swap(n);
        else {
            cnt--;
            for (int i=n-cnt; i<=n+cnt; i++) swap(i);
        }
    }

    private static void swap(int idx) {
        if (switches[idx] == 1) switches[idx] = 0;
        else switches[idx] = 1;
    }

}
