/**
 * BOJ 11286번(S1)
 * 우선순위 큐. 힙. 정렬.
 */
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11286 {

	public static void main(String[] args) {
		
		// Comparator
		// 두 수의 절대값이 같으면->오름차순 정렬, 같지 않으면->절대값으로 오름차순 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}
				else return Math.abs(o1) - Math.abs(o2);
			}
		});
		
//		// 람다
//		PriorityQueue<Integer> pq = new PriorityQueue<>( (o1, o2) ->
//			// 두 수의 절대값이 같으면->오름차순 정렬, 같지 않으면->절대값으로 오름차순 정렬
//			Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2)) );
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		for (int i=0; i<N; i++) {
			int n = scan.nextInt();
			if (n == 0) {
				if (pq.isEmpty()) System.out.println(0);
				// 절대값이 가장 작은 값을 출력하고, 해당 값을 제거
				else System.out.println(pq.poll());
			}
			else pq.offer(n);
		}
	}
}
