import java.util.*;

class Solution {

    public int totalSteps(int[] nums) {

        // stack stores: {value, stepsToDie}
        Stack<int[]> stack = new Stack<>();

        int maxSteps = 0;

        for (int current : nums) {

            int stepsToDie = 0;

            // Remove all smaller or equal elements
            while (!stack.isEmpty() && current >= stack.peek()[0]) {
                stepsToDie = Math.max(stepsToDie, stack.pop()[1]);
            }

            // If stack empty → survives forever
            if (stack.isEmpty()) {
                stepsToDie = 0;
            } 
            // Else → dies one round after the max popped
            else {
                stepsToDie += 1;
            }

            maxSteps = Math.max(maxSteps, stepsToDie);

            stack.push(new int[]{current, stepsToDie});
        }

        return maxSteps;
    }
}
