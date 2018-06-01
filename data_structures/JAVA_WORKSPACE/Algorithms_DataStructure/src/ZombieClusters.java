import java.util.*;
public class ZombieClusters {
	public static void main(String[] args) {
		System.out.println(zombieCluster());
	}

	public static int zombieCluster() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n == 0) return 0;

		String[] m = new String[n];
		for (int i = 0; i < n; i++) {
			m[i] = sc.next();
		}

		Set<Integer> visited = new HashSet<>();

		int res = 0;
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (visited.contains(i)) continue;
			q.offer(i);
			while (!q.isEmpty()) {
				int temp = q.poll();
				for (int j = temp+1; j < n; j++) {
					if (m[temp].charAt(j) == '1') {
						visited.add(j);
						q.offer(j);
					}
				}
			}
			
			res++;
			
		}

		return res;
	}
}
