class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        int oldcolor=image[sr][sc];
        dfs(image,sr,sc,oldcolor,color);
        return image;

        
    }
    public void dfs(int[][] image,int x,int y,int oldcolor,int newcolor){
        if(x<0||y<0||x>=image.length||y>=image[0].length||image[x][y]!=oldcolor){
            return;
        }
        image[x][y]=newcolor;
        dfs(image,x+1,y,oldcolor,newcolor);
        dfs(image,x-1,y,oldcolor,newcolor);
        dfs(image,x,y+1,oldcolor,newcolor);
        dfs(image,x,y-1,oldcolor,newcolor);
    }
}