class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        ArrayList<Integer> ls=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adj.get(v).add(u);
        }
        //indegree
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int nbrs:adj.get(i)){
                indegree[nbrs]++;
            }
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            ls.add(curr);
            for(int nbrs:adj.get(curr)){
                indegree[nbrs]--;
                if(indegree[nbrs]==0){
                    q.add(nbrs);
                }
            }
        }
        if (ls.size() != n) {
            return new int[0];
        }
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=ls.get(i);
        }
        return arr;

        
    }
}