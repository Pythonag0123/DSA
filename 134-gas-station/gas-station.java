class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int kharcha=0;
        int kamai=0;
        int total=0;
        int res=0;
        for(int i=0;i<n;i++){
            kharcha+=cost[i];
            kamai+=gas[i];
        }
        if(kamai<kharcha) return -1;
        else{
            for(int i=0;i<n;i++){
                total=total+gas[i]-cost[i];
                if(total<0){
                    total=0;
                    res=i+1;
                }
                

            }
            

        }
        return res;
        
    }
}