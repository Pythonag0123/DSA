

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int m = people.length;

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int day = people[i];
            int started = upperBound(start, day);   // ≤ day
            int ended = lowerBound(end, day);       // < day
            ans[i] = started - ended;
        }

        return ans;
    }

    private int upperBound(int[] arr, int x) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= x) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int lowerBound(int[] arr, int x) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < x) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
