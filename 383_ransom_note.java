class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Step 1: ek array banao 26 letters ke liye
        int[] letters = new int[26];

        // Step 2: magazine ke sab letters count karo
        for (char c : magazine.toCharArray()) {
            letters[c - 'a']++;   // jis letter pe ho uski count badha do
        }

        // Step 3: ransomNote ke letters use karo
        for (char c : ransomNote.toCharArray()) {
            letters[c - 'a']--;   // ek letter use kar liya
            if (letters[c - 'a'] < 0) {
                return false;     // agar letter available hi nahi tha
            }
        }

        // Step 4: sab letters mil gaye
        return true;
    }
}