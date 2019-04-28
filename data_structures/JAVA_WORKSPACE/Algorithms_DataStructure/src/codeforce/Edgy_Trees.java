//package codeforce;

import java.util.*;

public class Edgy_Trees {
    static int mod = 1000000007;
    public static void main(String []args){

    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for(int i = 0; i<n-1;i++){
        int u = in.nextInt();
        int v = in.nextInt();
        int color = in.nextInt();
        if(color == 0){
            graph.computeIfAbsent(u, f-> new HashSet<>()).add(v);
            graph.computeIfAbsent(v, f-> new HashSet<>()).add(u);
        }
    }
    long totalCount = pow(n, k);
    boolean visited[] = new boolean[n+1];
    long removeCount = 0;
    for(int i = 1; i <= n; i++){
        if(!visited[i])
        {
            int []count = new int[]{0};
            dfs(graph, visited, i, count);
            removeCount += pow(count[0], k);
        }
    }
    removeCount %= mod;
    long ans = (totalCount - removeCount + mod) % mod;
    System.out.println(ans);

    }

    public static void dfs(Map<Integer, Set<Integer>> graph, boolean []visited, int node, int []count){
        if(visited[node]) return;
        visited[node] = true;
        count[0]++;
        if(graph.containsKey(node)){
            for(int adjNode: graph.get(node)){
                dfs(graph, visited, adjNode, count);
            }
        }
    }

    public static long pow(int num, int power){
        if(power == 0) return 1;
        long curr = pow(num, power >> 1);
        curr = curr * curr % mod;
        if(power % 2 == 1){
            curr = curr * num % mod;
        }
        return curr;
    }
}
