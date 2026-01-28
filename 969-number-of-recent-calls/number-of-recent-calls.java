class RecentCounter {
    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        q.add(t);
        int low = t - 3000;

        while (!q.isEmpty() && q.peek() < low) {
            q.poll();
        }

        return q.size();
    }
}
