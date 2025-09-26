class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        
        
        boolean[] possible = canBePlaced(flowerbed);
        
        for(int i = 0; i < m; i++){
            
            if(possible[i] == true && flowerbed[i] == 0){
                
                flowerbed[i] = 1;
                n = n - 1;
                
                
                possible = canBePlaced(flowerbed);
                
                
                if(n == 0){
                    return true;
                }
            }
        }
        
        
        if(n <= 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean[] canBePlaced(int[] arr){
        int n = arr.length;
        boolean[] ans = new boolean[n];
        
        
        for(int i = 0; i < n; i++){
            ans[i] = true;
        }

        for(int i = 0; i < n; i++){
            if(arr[i] == 1){
                ans[i] = false;
                if(i > 0){
                    ans[i - 1] = false;
                }
                if(i < n - 1){
                    ans[i + 1] = false;
                }
            }
        }
        
        return ans;
    }
}
