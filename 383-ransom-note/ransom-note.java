class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length()<ransomNote.length()) return false;
        int[] freq=new int[26];
        for(int i=0;i<magazine.length();i++){
            freq[magazine.charAt(i)-'a']--;
            if(i<ransomNote.length()){
                freq[ransomNote.charAt(i)-'a']++;
            }

        }
        for(int c:freq){
            if(c>0) return false;
        }
        return true;
        
    }
}