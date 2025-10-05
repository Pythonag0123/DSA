class Solution {
    int count = 0;

    public int countArrangement(int n) {
        boolean[] used = new boolean[n + 1];
        beautiful(n, 1, used);
        return count;
    }

    public void beautiful(int n, int pos, boolean[] used) {
        if (pos > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i] && (i % pos == 0 || pos % i == 0)) {
                used[i] = true;
                beautiful(n, pos + 1, used);
                used[i] = false;
            }
        }
    }
}
