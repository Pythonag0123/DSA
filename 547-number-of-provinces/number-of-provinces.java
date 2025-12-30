class Solution {
    public int findCircleNum(int[][] isConnected) {
        return answer(isConnected);
    }

    public int answer(int[][] mat){
        int n = mat.length;

        //create graph
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=1 ;i<=n ;i++){
            map.put(i, new ArrayList<>());
        }
        for(int i=0; i<n ;i++){
            for(int j=0 ;j<n ;j++){
                if(i != j && mat[i][j] == 1){
                    map.get(i+1).add(j+1);
                    map.get(j+1).add(i+1);
                }
            }
        }

        //now apply bfs to find no. of components
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int com =0;

        for(int src : map.keySet()){
            if(visited.contains(src)){
                continue;
            }
            com++;
            q.add(src);

            while(!q.isEmpty()){
                // remove
                int r = q.poll();

                // ignore if visited
                if(visited.contains(r)){
                    continue;
                }
                // mark visited
                visited.add(r);
                // self work

                // add unvisited nbrs
                for(int nbrs : map.get(r)){
                    if(!visited.contains(nbrs)){
                        q.add(nbrs);
                    }
                }

            }
        }
        return com;

        
    }
}