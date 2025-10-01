class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n=people.length;
        int s=0;
        int e=n-1;
        int boats=0;
        while(s<=e){
            if(people[s]+people[e]<=limit){
                boats++;
                s++;
                e--;
            }
            else{
                boats++;
                e--;

            }

        }
        return boats;
        
    }
}