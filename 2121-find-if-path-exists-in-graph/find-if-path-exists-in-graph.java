class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return dfs(adj,source,destination,visited);

        

        
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int src,int des,boolean[] visited){
        visited[src]=true;
        if(src==des){
            return true;
        }
        for(int nbrs:adj.get(src)){
            if(!visited[nbrs]){
                if(dfs(adj,nbrs,des,visited)){
                    return true;
                }
            }
        }
        return false;


    }
}