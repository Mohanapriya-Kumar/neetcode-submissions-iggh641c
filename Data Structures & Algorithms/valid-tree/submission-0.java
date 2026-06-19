class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
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

        boolean[] vis = new boolean[n];
        dfs(0, graph, vis);
    
        for(int i = 0; i < n; i++){
            if(!vis[i]) return false;
        }
        return true;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] vis){
        if(vis[node]) return;
        vis[node] = true;

        for(int nei : graph.get(node)){
            dfs(nei, graph, vis);
        }
    }
}
