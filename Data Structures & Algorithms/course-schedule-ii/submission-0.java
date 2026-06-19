class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] p : prerequisites){
            int course = p[0];
            int preq = p[1];
            graph.get(preq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        int[] res = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            res[idx++] = course;
            for(int nxt : graph.get(course)){
                indegree[nxt]--;
                if(indegree[nxt] == 0) q.offer(nxt);
            }
        } 
        return idx == numCourses ? res : new int[]{};
    }
}
