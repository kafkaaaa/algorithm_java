/**
 * 정올 1828번
 * Greedy.
 * 참고 -> https://haerang94.tistory.com/285
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q1828 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();     // 화학물질의 수  1 <= N <= 100
        Chemical[] chemicals = new Chemical[N];
        for (int i=0; i<N; i++) {
            chemicals[i] = new Chemical(scan.nextInt(), scan.nextInt());
        }
        Arrays.sort(chemicals);

        int cnt = 1;
        int max = chemicals[0].maxTemp;
        for (int i=1; i<chemicals.length; i++) {
            if (chemicals[i].minTemp > max) {
                max = chemicals[i].minTemp;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

class Chemical implements Comparable<Chemical> {
    int minTemp, maxTemp;

    public Chemical (int minTemp, int maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    @Override
    public int compareTo(Chemical o) {
        return this.maxTemp - o.maxTemp;
    }
}
