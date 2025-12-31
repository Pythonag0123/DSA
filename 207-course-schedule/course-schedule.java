class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> ls=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int v=prerequisites[i][0];
            int u=prerequisites[i][1];
            adj.get(u).add(v);
        }
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int nbr:adj.get(i)){
                indegree[nbr]++;
            }
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            ls.add(curr);
            for(int nbr:adj.get(curr)){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.add(nbr);
                }
            }

        }
        return ls.size()==numCourses;






        
    }
    
    
}