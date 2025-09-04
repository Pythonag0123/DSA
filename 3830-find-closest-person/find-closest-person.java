class Solution {
    public int findClosest(int x, int y, int z) {
        int a=z-x;
        if(a<0){
            a=-a;
        }
        int b=z-y;
        if(b<0){
        b=-b;
        }
        if(a>b){
            return 2;
        }
        else if(b>a){
            return 1;
        
        }
        else{
            return 0;
        }
        
    }
}