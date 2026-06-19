class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //it is given in q tht we use 1 based indexing
        // actually for a tree num of nodes is n-1 here + 1 so n
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            if(!union(u,v,parent,rank)) return e;
        }
        return new int[]{0,0};
    }

    private boolean union(int a, int b, int[] parent, int[] rank){
        int pa = find(a, parent);
        int pb = find(b, parent);
        if(pa == pb) return false;

        if(rank[pa] < rank[pb]){
            parent[pa] = pb;
        } else if (rank[pb] < rank[pa]) {
            parent[pb] = pa;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
        return true;
    }

    private int find(int x, int[] parent){
        if(x != parent[x]) parent[x] = find(parent[x], parent);
        return parent[x];
    }
}
