class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int cmp = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                cmp++;
                dfs(i, graph, vis);
            }
        }
        return cmp;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] vis){
        vis[node] = true;
        for(int nei : graph.get(node)){
            if(!vis[nei]) dfs(nei, graph, vis);
        }
    }
}
