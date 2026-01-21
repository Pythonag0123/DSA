class Solution {
    public int minimizeXor(int num1, int num2) {
        int setbit = 0;
        int temp = num2;

        
        while (temp > 0) {
            temp &= (temp - 1);
            setbit++;
        }

        int x = 0;

        
        for (int i = 30; i >= 0 && setbit > 0; i--) {
            int mask = 1 << i;
            if ((num1 & mask) != 0) {
                x |= mask;
                setbit--;
            }
        }

        
        for (int i = 0; i <= 30 && setbit > 0; i++) {
            int mask = 1 << i;
            if ((x & mask) == 0) {
                x |= mask;
                setbit--;
            }
        }

        return x;
    }
}
